import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestRunner {
    private static int getResult(String csvName, StringBuilder strResult) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader(csvName))) {
            final String BEFORE_SIGN = " ";
            final String AFTER_SIGN = " ";
            final String PLUS = BEFORE_SIGN + "+" + AFTER_SIGN;
            final String MINUS = BEFORE_SIGN + "-" + AFTER_SIGN;
            final String DELIMETER = ";";
            final String RESULT_HEAD = "result(";
            final String RESULT_TAIL = ") = ";
            final String TABULATION = "\n";
            final String ERROR_LINES = "error-lines = ";
            int errorLines = 0;
            double numResult = 0;
            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(DELIMETER);
                try {
                    int index;
                    double value;
                    index = Integer.parseInt(words[0]);
                    if (index >= 0) {
                        value = Double.parseDouble(words[index]);
                        numResult += value;
                        strResult.append(value >= 0 ? PLUS : MINUS).append(Math.abs(value));
                    }
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    errorLines++;
                }
            }
            if (strResult.length() > 0) {
                final int SIGN_LENGTH = MINUS.length();
                final char CHAR_MINUS = '-';
                String symbol = strResult.substring(0, SIGN_LENGTH);
                strResult.delete(0, SIGN_LENGTH);
                if (symbol.equals(MINUS)) {
                    strResult.insert(0, CHAR_MINUS);
                }
            }
            strResult.insert(0, RESULT_HEAD).append(RESULT_TAIL).append(numResult)
                    .append(TABULATION).append(ERROR_LINES).append(errorLines);
            System.out.println(strResult);
            return errorLines;
        }
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
