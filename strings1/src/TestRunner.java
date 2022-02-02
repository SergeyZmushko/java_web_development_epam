import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestRunner {
    private static int getResult(String csvName, StringBuilder strResult) throws FileNotFoundException {
        int errorLines = 0;
        double result = 0.0;
        final String PLUS = " + ";
        final String MINUS = " - ";
        final int PLUS_LENGTH = PLUS.length();
        final String RESULT_HEAD = "result(";
        final String RESULT_TAIL = ") = ";
        final String RESULT_ERROR_LINES = "\nerror-lines = ";
        try (Scanner sc = new Scanner(new FileReader(csvName))) {
            String[] splittedLine;
            String line;
            while (sc.hasNext()) {
                line = sc.nextLine();
                splittedLine = line.split(";");
                int position;
                double value;
                try {
                    position = Integer.parseInt(splittedLine[0]);
                    if (position >= 0) {
                        value = Double.parseDouble(splittedLine[position]);
                        result += value;
                        if (value >= 0 || (value < 0 && strResult.isEmpty())) {
                            strResult.append(value).append(PLUS);
                        } else {
                            value = value * -1;
                            strResult.delete(strResult.length() - PLUS_LENGTH, strResult.length())
                                    .append(MINUS).append(value).append(PLUS);
                        }
                    } else {
                        errorLines++;
                    }
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    errorLines++;
                }
            }
        }
        if (!strResult.isEmpty()) {
            strResult.delete(strResult.length() - PLUS_LENGTH, strResult.length());
        }
        strResult.insert(0, RESULT_HEAD).append(RESULT_TAIL).append(result);
        strResult.append(RESULT_ERROR_LINES).append(errorLines);
        System.out.println(strResult);
        return errorLines;
    }

    @Test
    public void testMainScenario() throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        int errorLines = getResult("src/in1.csv", stringBuilder);
        Assert.assertEquals(3, errorLines);
        String expectedIn1 = "result(5.2 - 3.14 + 0.0) = 2.06\nerror-lines = 3";
        Assert.assertEquals(expectedIn1, stringBuilder.toString());
    }

    @Test(expected = FileNotFoundException.class)
    public void testWrongCsvName() throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        getResult("src/int1.csv", stringBuilder);
    }

}
