package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static by.epam.lab.utils.Constants.*;

public class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        synchronized (buffer) {
            try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
                while (sc.hasNextLine()) {
                    String[] str = sc.next().split(DELIMITER);
                    Trial trial = new Trial(str);
                    buffer.put(trial);
                    System.out.println(PUT + trial);
                }
                buffer.put(null);
            } catch (FileNotFoundException e) {
                System.out.println(FILE_NOT_FOUND);
            }
        }
    }
}
