import org.junit.Assert;
import org.junit.Test;

import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRunner {

    private static Result getResult(String fileName) throws MissingResourceException {
        final String KEY_REG_EXP = "index(.*)";
        final String NUM_REG_EXP = "[1-9]\\d*";
        final String VALUE = "value";
        final int TAIL_INDEX = 1;
        ResourceBundle rb = ResourceBundle.getBundle(fileName);
        Enumeration<String> keys = rb.getKeys();
        double sum = 0.0;
        int errorLines = 0;
        while (keys.hasMoreElements()) {
            String key;
            Pattern keyPattern = Pattern.compile(KEY_REG_EXP);
            key = keys.nextElement();
            Matcher keyMatcher = keyPattern.matcher(key);
            if (keyMatcher.matches()) {
                String iStr = keyMatcher.group(TAIL_INDEX);
                String jStr = rb.getString(key).trim();
                Pattern numPattern = Pattern.compile(NUM_REG_EXP);
                Matcher iMatcher = numPattern.matcher(iStr);
                Matcher jMatcher = numPattern.matcher(jStr);
                if (iMatcher.matches() && jMatcher.matches()) {
                    String valueIJ = VALUE + iStr + jStr;
                    try {
                        sum += Double.parseDouble(rb.getString(valueIJ));
                    } catch (NumberFormatException | MissingResourceException e) {
                        errorLines++;
                    }
                } else {
                    errorLines++;
                }
            }
        }
        return new Result(sum, errorLines);
    }

    static class Result {
        private double sum;
        private int errorLines;

        public Result() {

        }

        public Result(double sum, int errorLines) {
            this.sum = sum;
            this.errorLines = errorLines;
        }

        public double getSum() {
            return sum;
        }

        public int getErrorLines() {
            return errorLines;
        }
    }

    @Test
    public void testMainScenarioIn1() throws MissingResourceException {
        class TestCase {
            private final static double NUMBER_PRECISION = 0.0001;
            private final String filename;
            private final Result expectedResult;

            public TestCase(String filename, Result expectedResult) {
                this.filename = filename;
                this.expectedResult = expectedResult;
            }

            public Result getExpectedResult() {
                return expectedResult;
            }

            public double getSum() {
                return getResult(filename).getSum();
            }

            public int getNumberErrors() {
                return getResult(filename).getErrorLines();
            }
        }

        TestCase[] testCases = {
                new TestCase("in1", new Result(8.24, 3)),
                new TestCase("in2", new Result(30.242, 9)),
                new TestCase("in3", new Result(1.9, 0))
        };

        for (TestCase testCase : testCases) {
            Assert.assertEquals(testCase.getSum(), testCase.getExpectedResult().sum, TestCase.NUMBER_PRECISION);
            Assert.assertEquals(testCase.getNumberErrors(), testCase.getExpectedResult().errorLines);
        }
    }

    @Test(expected = MissingResourceException.class)
    public void testWrongFileName() throws MissingResourceException {
        String fileName = "in23";
        getResult(fileName);
    }
}
