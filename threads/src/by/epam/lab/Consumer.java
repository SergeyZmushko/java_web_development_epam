package by.epam.lab;

public class Consumer implements Runnable {
    private final Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        synchronized (drop) {
            while (drop.isEmpty()) {
                System.out.println("GOT>" + drop.take());
            }
        }
    }
}
