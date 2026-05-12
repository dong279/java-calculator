package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

  @Test
  @DisplayName("숫자 목록의 합산을 반환한다")
  void 숫자_합산() {
    Numbers numbers = new Numbers(List.of(
        new PositiveNumber("1"),
        new PositiveNumber("2"),
        new PositiveNumber("3")
    ));
    assertThat(numbers.sum()).isEqualTo(6);
  }

  @Test
  @DisplayName("빈 숫자 목록의 합산은 0이다")
  void 빈_숫자_합산() {
    Numbers numbers = Numbers.empty();
    assertThat(numbers.sum()).isEqualTo(0);
  }
}
