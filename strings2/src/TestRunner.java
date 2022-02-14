import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class TestRunner {
    private static final String VALUE = "value";
    private static final String INDEX = "index";
    private static final String REGEX_FOR_INDEX_WORD = "(index).*";
    private static final String REGEX_FOR_INDEX_LINE = "(index)([1-9]\\d*\\s*)";
    private static final String REGEX_FOR_INDEX_VALUE = "\\s*[1-9]\\d*\\s*";

    private static Result getResult(String fileName) throws MissingResourceException {
        ResourceBundle rb = ResourceBundle.getBundle(fileName);
        Enumeration<String> keys = rb.getKeys();
        String key;
        BigDecimal sum = new BigDecimal("0.0");
        int errorLines = 0;
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            if (key.matches(REGEX_FOR_INDEX_WORD)) {
                try {
                    String j = rb.getString(key);
                    if (key.matches(REGEX_FOR_INDEX_LINE) && j.matches(REGEX_FOR_INDEX_VALUE)) {
                        String i = key.substring(INDEX.length());
                        String valueIJ = i + j;
                        sum = sum.add(BigDecimal.valueOf(Double.parseDouble(rb.getString(VALUE + valueIJ))));
                    } else {
                        errorLines++;
                    }
                } catch (NumberFormatException | MissingResourceException e) {
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
        String fileName = "in1";
        getResult(fileName);
        int errorLines = getResult(fileName).getErrorLines();
        Assert.assertEquals(3, errorLines);
        BigDecimal sum = getResult(fileName).getSum();
        Assert.assertEquals(new BigDecimal("8.24"), sum);
    }

    @Test
    public void testMainScenarioIn2() throws MissingResourceException {
        String fileName = "in2";
        getResult(fileName);
        int errorLines = getResult(fileName).getErrorLines();
        Assert.assertEquals(9, errorLines);
        BigDecimal sum = getResult(fileName).getSum();
        Assert.assertEquals(new BigDecimal("30.242"), sum);
    }

    @Test
    public void testMainScenarioIn3() throws MissingResourceException {
        String fileName = "in3";
        getResult(fileName);
        int errorLines = getResult(fileName).getErrorLines();
        Assert.assertEquals(0, errorLines);
        BigDecimal sum = getResult(fileName).getSum();
        Assert.assertEquals(new BigDecimal("1.9"), sum);
    }

    @Test(expected = MissingResourceException.class)
    public void testWrongFileName() throws MissingResourceException {
        String fileName = "in23";
        getResult(fileName);
    }
}
