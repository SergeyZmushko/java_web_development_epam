package by.epam.lab.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Reader {

    public static List<File> searchFiles(File rootFile) {
        List<File> fileList = new ArrayList<>();
        if (rootFile.isDirectory()) {
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                Arrays.stream(directoryFiles)
                        .filter(file -> !file.isDirectory())
                        .filter(file -> Pattern.matches(Constants.REGEX_CSV, file.getName()))
                        .collect(Collectors.toCollection(() -> fileList));
            }
        }
        return fileList;
    }
}
