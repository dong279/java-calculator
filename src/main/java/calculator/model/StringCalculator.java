package calculator.model;

import calculator.model.parser.ExpressionParser;

public class StringCalculator {
  private final ExpressionParser parser = new ExpressionParser();

  public int calculate(String input) {
    Numbers numbers = parser.parse(input);
    return numbers.sum();
  }
}
