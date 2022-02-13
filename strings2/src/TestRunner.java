import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRunner {
    private static final String RESULT = "sum = ";
    private static final String VALUE = "value";
    private static final String INDEX = "index";
    private static final String REGEX_FOR_INDEX_WORD = "(index).*";
    private static final String REGEX_FOR_INDEX_LINE = "(index)([1-9]\\d*\\s*)";
    private static final String REGEX_FOR_INDEX_VALUE = "\\s*[1-9]\\d*\\s*";
    private static final String REGEX_FOR_NUMBER = "\\d+";
    private static final String FILE_NAME = "in1";

    private static int getResult() throws FileNotFoundException {
        ResourceBundle rb = ResourceBundle.getBundle(FILE_NAME);
        Enumeration<String> keys = rb.getKeys();
        String key;
        double result = 0.0;
        int errorLines = 0;
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            Pattern p1 = Pattern.compile(REGEX_FOR_INDEX_WORD);
            Matcher m1 = p1.matcher(key);
            if (m1.find()) {
                try {
                    String j = rb.getString(key);
                    System.out.println("line=" + key + "=" + rb.getString(key));
                    if (key.matches(REGEX_FOR_INDEX_LINE) && j.matches(REGEX_FOR_INDEX_VALUE)) {
                        String i = key.substring(INDEX.length());
                        String valueIJ = i + j;
                        System.out.println(valueIJ);
                        System.out.println("=" + rb.getString(VALUE + valueIJ));
                        result += Double.parseDouble(rb.getString(VALUE + valueIJ));
                    } else {
                        errorLines++;
                        System.out.println("Error lines = " + errorLines);
                    }
                } catch (NumberFormatException | MissingResourceException e) {
                    errorLines++;
                    System.out.println("Error lines = " + errorLines);
                }
            }
        }
        System.out.println(RESULT + result);
        System.out.println(errorLines);
        return errorLines;
    }

    @Test
    public void testMainScenario() throws FileNotFoundException {
        int d = getResult();
    }
}
