package by.epam.lab;

import by.epam.lab.beans.Trial;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static by.epam.lab.utils.Constants.*;

public class Producer implements Runnable {
    private final Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        synchronized (drop) {
            try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
                while (sc.hasNextLine()) {
                    String[] str = sc.next().split(DELIMITER);
                    Trial trial = new Trial(str);
                    drop.put(trial);
                    System.out.println(PUT + trial);
                }
                drop.put(null);
            } catch (FileNotFoundException e) {
                System.out.println(FILE_NOT_FOUND);
            }
        }
    }
}
