package by.epam.lab;

import by.epam.lab.producerConsumer.Consumer;
import by.epam.lab.producerConsumer.Buffer;
import by.epam.lab.producerConsumer.Producer;

public class Runner {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Thread(new Producer(buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}
