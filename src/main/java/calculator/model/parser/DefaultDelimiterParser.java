package calculator.model.parser;

import calculator.model.Numbers;
import calculator.model.PositiveNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultDelimiterParser {
  private static final String DELIMITER = "[,:]";

  public Numbers parse(String input) {
    List<PositiveNumber> list = Arrays.stream(input.split(DELIMITER))
        .map(PositiveNumber::new)
        .collect(Collectors.toList());
    return new Numbers(list);
  }
}
