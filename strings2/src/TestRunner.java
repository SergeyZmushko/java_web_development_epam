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
    private static final String REGEX_FOR_INDEX_ROW = "(index)(\\s*\\d*\\s*[^0=])";
    private static final String REGEX_FOR_INDEX_VALUE = "\\d+";
    private static final String FILE_NAME = "in3";

    private static int getResult() throws FileNotFoundException {
        ResourceBundle rb = ResourceBundle.getBundle(FILE_NAME);
        Enumeration<String> keys = rb.getKeys();
        String key;
        double result = 0;
        int errorLines = 0;
        while (keys.hasMoreElements()) {
            String resultValueIndex;
            key = keys.nextElement();
            Pattern p1 = Pattern.compile(REGEX_FOR_INDEX_ROW);
            Matcher m1 = p1.matcher(key);
            if (m1.find()) {
//                Pattern p3 = Pattern.compile(REGEX_FOR_INDEX_VALUE);
//                Matcher m3 = p3.matcher(m1.group());
//                if (m3.find()) {
//                    resultValueIndex = m3.group() + rb.getString(m1.group());
//                    String regexValueIndex = VALUE + resultValueIndex;
                try {
                    String keyValue = rb.getString(key);
                    if (key.matches(REGEX_FOR_INDEX_ROW) && keyValue.matches(REGEX_FOR_INDEX_VALUE)) {
                        String i = key.substring(INDEX.length());
                        System.out.println(keyValue);
                        System.out.println("=" + rb.getString(VALUE + i + keyValue));
                        result += Double.parseDouble(rb.getString(VALUE + i + keyValue));
                    } else {
                        errorLines++;
                    }
                } catch (NumberFormatException | MissingResourceException e) {
                    errorLines++;
                }
                //}
                //   }
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

