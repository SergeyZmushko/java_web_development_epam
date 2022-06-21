package by.epam.lab.producerConsumer;

import by.epam.lab.utils.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import static by.epam.lab.utils.Constants.*;

public class TrialProducer implements Runnable {
    private final CountDownLatch latch;
    private final BlockingQueue<String> strings;
    private final String path;
    protected final int maxProducersNumber;
 //   private static final List<File> files = searchFiles(new File("E:\\java_web_development_epam\\threads\\src\\by\\epam\\lab\\sources"));


    public TrialProducer(BlockingQueue<String> strings, CountDownLatch latch) throws IOException {
        this.latch = latch;
        this.strings = strings;
        this.path = Data.getProperties(FOLDER_NAME);
        this.maxProducersNumber = Integer.parseInt(Data.getProperties(MAX_PRODUCERS_NUMBER));
    }

    public int getMaxProducersNumber() {
        return maxProducersNumber;
    }

    @Override
    public void run() {
        List<File> files = searchFiles(new File(path));
        for (File file : files) {
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNextLine()) {
                    String strTrial = sc.next();
                    strings.put(strTrial);
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
            strings.put(DONE);
            System.out.println(DONE);
        } catch (InterruptedException e) {
            //the thread should not be interrupted
            System.err.println(EXCEPTION + e);
        }
        latch.countDown();
    }

    public static List<File> searchFiles(File rootFile) {
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
