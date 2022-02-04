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
    public void testMainScenarioIn1() throws FileNotFoundException {
        StringBuilder result1 = new StringBuilder();
        int errorLines = getResult("src/in1.csv", result1);
        Assert.assertEquals(3, errorLines);
        String expectedIn1 = "result(5.2 - 3.14 + 0.0) = 2.06\nerror-lines = 3";
        Assert.assertEquals(expectedIn1, result1.toString());
    }

    @Test
    public void testMainScenarioIn2() throws FileNotFoundException {
        StringBuilder result2 = new StringBuilder();
        int errorLines = getResult("src/in2.csv", result2);
        Assert.assertEquals(0, errorLines);
        String expectedIn2 = "result(-3.1 - 1.0) = -4.1\nerror-lines = 0";
        Assert.assertEquals(expectedIn2, result2.toString());
    }

    @Test
    public void testMainScenarioIn3() throws FileNotFoundException {
        StringBuilder result3 = new StringBuilder();
        int errorLines = getResult("src/in3.csv", result3);
        Assert.assertEquals(0, errorLines);
        String expectedIn3 = "result(0.75) = 0.75\nerror-lines = 0";
        Assert.assertEquals(expectedIn3, result3.toString());
    }

    @Test
    public void testMainScenarioIn4() throws FileNotFoundException {
        StringBuilder result4 = new StringBuilder();
        int errorLines = getResult("src/in4.csv", result4);
        Assert.assertEquals(0, errorLines);
        String expectedIn4 = "result(0.0) = 0.0\nerror-lines = 0";
        Assert.assertEquals(expectedIn4, result4.toString());
    }

    @Test
    public void testMainScenarioIn5() throws FileNotFoundException {
        StringBuilder result5 = new StringBuilder();
        int errorLines = getResult("src/in5.csv", result5);
        Assert.assertEquals(1, errorLines);
        String expectedIn5 = "result() = 0.0\nerror-lines = 1";
        Assert.assertEquals(expectedIn5, result5.toString());
    }

    @Test(expected = FileNotFoundException.class)
    public void testWrongCsvName() throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        getResult("src/int1.csv", stringBuilder);
    }
}
