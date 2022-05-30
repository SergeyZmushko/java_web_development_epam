package by.epam.lab;

import by.epam.lab.producerConsumer.TrialConsumer;
import by.epam.lab.producerConsumer.TrialBuffer;
import by.epam.lab.producerConsumer.TrialProducer;

public class Runner {
    public static void main(String[] args) {
        TrialBuffer trialBuffer = new TrialBuffer();
        new Thread(new TrialProducer(trialBuffer)).start();
        new Thread(new TrialConsumer(trialBuffer)).start();
    }
}
