package calculator.model.parser;

import calculator.model.Numbers;

public class ExpressionParser {
  private final CustomDelimiterParser customParser = new CustomDelimiterParser();
  private final DefaultDelimiterParser defaultParser = new DefaultDelimiterParser();

  public Numbers parse(String input) {
    if (input == null || input.isEmpty()){
      return Numbers.empty();
    }
    if (customParser.supports(input)){
      return customParser.parse(input);
    }
    return defaultParser.parse(input);
  }
}
