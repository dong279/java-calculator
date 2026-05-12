package calculator.model;

public class PositiveNumber {
  private final int value;

  public PositiveNumber(String token) {
    this.value = parse(token);
  }

  private int parse(String token) {
    int number;
    try{
      number = Integer.parseInt(token.trim());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닌 값입니다."+token);
    }
    if (number < 0) {
      throw new IllegalArgumentException("음수는 입력할 수 없습니다." + number);
    }
    return number;
  }
  public int getValue() {
    return value;
  }

}
