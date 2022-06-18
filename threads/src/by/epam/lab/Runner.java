package by.epam.lab;

import by.epam.lab.producerConsumer.Buffer;
import by.epam.lab.producerConsumer.TrialConsumer;
import by.epam.lab.producerConsumer.TrialProducer;

import java.io.IOException;
import java.util.concurrent.*;

public class Runner {
    public static void main(String[] args) throws IOException {
        Buffer buffer = new Buffer();

        TrialProducer trialProducer = new TrialProducer(buffer);
        TrialConsumer trialConsumer = new TrialConsumer(buffer);

        ExecutorService pes = Executors.newFixedThreadPool(trialProducer.getMaxProducersNumber());
        ExecutorService ces = Executors.newFixedThreadPool(trialConsumer.getMaxConsumersNumber());

        for (int i = 0; i < trialProducer.getMaxProducersNumber(); i++){
            pes.submit(new TrialProducer(buffer));
        }

        for (int i = 0; i < trialConsumer.getMaxConsumersNumber(); i++){
            ces.submit(new TrialConsumer(buffer));
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
