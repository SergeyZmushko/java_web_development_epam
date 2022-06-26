package by.epam.lab.producerConsumer;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Reader {

    public static List<File> searchFiles(File rootFile) {
        List<File> fileList = new ArrayList<>();
        if (rootFile.isDirectory()) {
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                Arrays.stream(directoryFiles).filter(file -> !file.isDirectory())
                        .collect(Collectors.toCollection(() -> fileList));
//                for (File file : directoryFiles) {
//                    if (!file.isDirectory()) {
//                        fileList.add(file);
//                    }
//                }
            }
        }
        return fileList;
    }
}
