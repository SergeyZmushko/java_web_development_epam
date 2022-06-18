package by.epam.lab.producerConsumer;

import by.epam.lab.utils.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

import static by.epam.lab.utils.Constants.*;

public class TrialProducer implements Runnable {
    private final BlockingQueue<String> sharedQueue;
    private final String path;
    private final int maxProducersNumber;
    private final int bufferStrLength;

    public TrialProducer(BlockingQueue<String> sharedQueue) throws IOException {
        this.sharedQueue = sharedQueue;
        this.path = Data.getProperties(FOLDER_NAME);
        this.maxProducersNumber = Integer.parseInt(Data.getProperties(MAX_PRODUCERS_NUMBER));
        this.bufferStrLength = Integer.parseInt(Data.getProperties(BUFFER_STR_LENGTH));
    }

    public int getMaxProducersNumber() {
        return maxProducersNumber;
    }

    public int getBufferStrLength() {
        return bufferStrLength;
    }

    @Override
    public void run() {
        List<File> fileList = searchFiles(new File(path));
        for (File file : fileList) {
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNextLine()) {
                    String strTrial = sc.next();
                    sharedQueue.put(strTrial);
                    System.out.println(GOT + strTrial + " " + Thread.currentThread().getName());
                    Thread.sleep(100);
                }
            } catch (FileNotFoundException e) {
                System.out.println(FILE_NOT_FOUND);
            } catch (InterruptedException ignored) {
            }
        }
        try {
            sharedQueue.put(DONE);
            System.out.println(DONE);
        } catch (InterruptedException ignored) {
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
