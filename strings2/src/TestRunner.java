import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRunner {

    private static Result getResult(String fileName) throws MissingResourceException {
        ResourceBundle rb = ResourceBundle.getBundle(fileName);
        Enumeration<String> keys = rb.getKeys();
        final String KEY_REG_EXP = "index(.*)";
        final String NUM_REG_EXP = "[1-9]\\d*";
        Pattern keyPattern = Pattern.compile(KEY_REG_EXP);
        Pattern numPattern = Pattern.compile(NUM_REG_EXP);
        final int TAIL_INDEX = 1;
        final String VALUE = "value";
        String key;
        BigDecimal sum = new BigDecimal("0.0");
        int errorLines = 0;
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            Matcher keyMatcher = keyPattern.matcher(key);
            if (keyMatcher.matches()) {
                String iStr = keyMatcher.group(TAIL_INDEX);
                String jStr = rb.getString(key).trim();
                Matcher iMatcher = numPattern.matcher(iStr);
                Matcher jMatcher = numPattern.matcher(jStr);
                if (iMatcher.matches() && jMatcher.matches()) {
                    String valueIJ = VALUE + iStr + jStr;
                    try {
                        sum = sum.add(BigDecimal.valueOf(Double.parseDouble(rb.getString(valueIJ))));
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
        private BigDecimal sum;
        private int errorLines;

        public Result() {

        }

        public Result(BigDecimal sum, int errorLines) {
            this.sum = sum;
            this.errorLines = errorLines;
        }

        public BigDecimal getSum() {
            return sum;
        }

        public int getErrorLines() {
            return errorLines;
        }
    }

    @Test
    public void testMainScenarioIn1() throws MissingResourceException {
         class TestCase {
            private String filename;
            private int expectedErrors;
            private BigDecimal expectedResults;

            public TestCase() {
            }

            public TestCase(String filename, int expectedErrors, BigDecimal expectedResults) {
                this.filename = filename;
                this.expectedErrors = expectedErrors;
                this.expectedResults = expectedResults;
            }
        }
        TestCase[] testCases = {
                new TestCase("in1", 3, new BigDecimal("8.24")),
                new TestCase("in2", 9, new BigDecimal("30.242")),
                new TestCase("in3", 0, new BigDecimal("1.9"))
        };
        for (TestCase testCase : testCases) {
            int errorLines = getResult(testCase.filename).errorLines;
            BigDecimal sum = getResult(testCase.filename).sum;
            Assert.assertEquals(testCase.expectedErrors, errorLines);
            Assert.assertEquals(testCase.expectedResults, sum);
        }
    }

    @Test(expected = MissingResourceException.class)
    public void testWrongFileName() throws MissingResourceException {
        String fileName = "in23";
        getResult(fileName);
    }
}
