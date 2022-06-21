package by.epam.lab;

import by.epam.lab.beans.Trial;
import by.epam.lab.producerConsumer.TrialConsumer;
import by.epam.lab.producerConsumer.TrialProducer;
import by.epam.lab.producerConsumer.Writer;

import java.io.IOException;
import java.util.concurrent.*;

public class Runner {
    public static void main(String[] args) throws IOException {

        CountDownLatch latch = new CountDownLatch(2);

        BlockingQueue<String> strings = new LinkedBlockingQueue<>(3);
        BlockingQueue<Trial> trials = new LinkedBlockingQueue<>();

        TrialProducer trialProducer = new TrialProducer(strings, latch);
        TrialConsumer trialConsumer = new TrialConsumer(strings, trials);
        Writer writer = new Writer(trials);

        ExecutorService pes = Executors.newFixedThreadPool(trialProducer.getMaxProducersNumber());
        ExecutorService ces = Executors.newFixedThreadPool(trialConsumer.getMaxConsumersNumber());

        for (int i = 0; i < trialProducer.getMaxProducersNumber(); i++){
            pes.submit(new TrialProducer(strings, latch));
        }
//        try {
//            latch.await();
//        }catch (InterruptedException ignored){
//        }
        for (int i = 0; i < trialConsumer.getMaxConsumersNumber(); i++){
            ces.submit(new TrialConsumer(strings, trials));
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
