package by.epam.lab.producerConsumer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Reader {

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
