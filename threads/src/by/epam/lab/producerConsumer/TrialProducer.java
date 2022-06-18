package by.epam.lab.producerConsumer;

import by.epam.lab.utils.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static by.epam.lab.utils.Constants.*;

public class TrialProducer implements Runnable {
    private final Buffer buffer;
    private final String path;
    protected final int maxProducersNumber;

    public TrialProducer(Buffer buffer) throws IOException {
        this.path = Data.getProperties(FOLDER_NAME);
        this.maxProducersNumber = Integer.parseInt(Data.getProperties(MAX_PRODUCERS_NUMBER));
        this.buffer = buffer;
    }

    public int getMaxProducersNumber() {
        return maxProducersNumber;
    }

    @Override
    public void run() {
        List<File> fileList = searchFiles(new File(path));
        for (File file : fileList) {
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNextLine()) {
                    String strTrial = sc.next();
                    buffer.getSharedQueue().put(strTrial);
                    System.out.println(GOT + strTrial + BLANK + Thread.currentThread().getName());
                    Thread.sleep(100);
                }
            } catch (FileNotFoundException e) {
                System.out.println(FILE_NOT_FOUND);
            } catch (InterruptedException e) {
                //the thread should not be interrupted
                System.err.println(EXCEPTION + e);
            }
        }
        try {
            buffer.getSharedQueue().put(DONE);
            System.out.println(DONE);
        } catch (InterruptedException e) {
            //the thread should not be interrupted
            System.err.println(EXCEPTION + e);
        }
    }

    private static List<File> searchFiles(File rootFile) {
        List<File> fileList = new ArrayList<>();
        if (rootFile.isDirectory()) {
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (!file.isDirectory()) {
                        fileList.add(file);
                    }
                }
            }
        }
        return fileList;
    }
}
