package calculator.model;

import java.util.regex.Pattern;

public class StringParser {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";

    public static String[] parse(String input) {
        if (hasCustomDelimiter(input)){
            return parseWithCustomDelimiter(input);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_PREFIX);
    }

    private static String[] parseWithCustomDelimiter(String input) {
        int newlineIndex = input.indexOf(CUSTOM_SUFFIX);
        Validator.validateCustomDelimiterFormat(newlineIndex);

        String custom = input.substring(2, newlineIndex);
        String delimiter = DEFAULT_DELIMITER +"|" + Pattern.quote(custom);
        String numberPart = input.substring(newlineIndex + 2);

        return numberPart.split(delimiter);
    }
}
