package by.epam.lab;

import by.epam.lab.beans.Trial;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Producer implements Runnable {
    private final Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        try (Scanner sc = new Scanner(new FileReader("src/by/epam/lab/trials.csv"))) {
            while (sc.hasNextLine()) {
                synchronized (drop) {
                    while (drop.isEmpty()) {
                        String[] str = sc.next().split(";");
                        Trial trial = new Trial(str);

                        drop.put(trial);

                        System.out.println("PUT> " + trial);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
