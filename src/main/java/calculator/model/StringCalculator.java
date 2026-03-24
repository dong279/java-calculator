package calculator.model;

public class StringCalculator {

  public static int calculate(String input) {
    if (input == null || input.isEmpty()) {
      return 0;
    }
    String[] tokens = StringParser.parse(input);
    return sum(tokens);
  }
  private static int sum(String[] tokens) {
    int total = 0;
    for (String token : tokens) {
      int number = parseNumber(token);
      Validator.validateNotNegative(number);
      total += number;
    }
    return total;
  }

  private static int parseNumber(String token) {
    try{
      return Integer.parseInt(token.trim());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다." + token);
    }
  }
}
