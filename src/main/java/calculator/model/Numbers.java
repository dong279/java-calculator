package calculator.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Numbers {
  private final List<PositiveNumber> values;

  public Numbers(List<PositiveNumber> values) {
    this.values = List.copyOf(values);
  }

  public static Numbers empty() {
    return new Numbers(Collections.emptyList());
  }

  public int sum(){
    return values.stream()
        .mapToInt(PositiveNumber::getValue)
        .sum();
  }
}
