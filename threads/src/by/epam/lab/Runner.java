package by.epam.lab;

import by.epam.lab.beans.Trial;

import by.epam.lab.producerConsumer.TrialConsumer;
import by.epam.lab.producerConsumer.TrialProducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Runner {
    public static void main(String[] args) throws IOException {
        BlockingQueue<String> sharedQueue = new LinkedBlockingQueue<>(5);
        List<Trial> trials = new ArrayList<>();

        ExecutorService pes = Executors.newFixedThreadPool(1);
        ExecutorService ces = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 2; i++){
            pes.submit(new TrialProducer(sharedQueue));
        }

        for (int i = 0; i < 3; i++){
            ces.submit(new TrialConsumer(sharedQueue, trials));
        }

        pes.shutdown();
        ces.shutdown();


//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        try{
//            executorService.submit(new TrialProducer(sharedQueue));
//            executorService.submit(new TrialConsumer(sharedQueue, trials));
//            executorService.submit(new TrialConsumer(sharedQueue, trials));
//            executorService.submit(new TrialConsumer(sharedQueue, trials));
//        }catch (IOException e){
//            System.out.println("Wrong property");
//        }
//
//        executorService.shutdown();

    }
}
