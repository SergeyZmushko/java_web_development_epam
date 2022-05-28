package by.epam.lab;

import by.epam.lab.producerConsumer.Consumer;
import by.epam.lab.producerConsumer.Drop;
import by.epam.lab.producerConsumer.Producer;

public class Runner {
    public static void main(String[] args) {
        Drop drop = new Drop();
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}
