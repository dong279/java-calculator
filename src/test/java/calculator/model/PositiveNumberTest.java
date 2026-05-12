package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {

  @Test
  @DisplayName("문자열을 양수로 변환한다")
  void 문자열을_양수로_변환() {
    PositiveNumber number = new PositiveNumber("3");
    assertThat(number.getValue()).isEqualTo(3);
  }

  @Test
  @DisplayName("공백이 포함된 문자열도 변환한다")
  void 공백_포함_문자열_변환() {
    PositiveNumber number = new PositiveNumber(" 3 ");
    assertThat(number.getValue()).isEqualTo(3);
  }

  @Test
  @DisplayName("음수 입력 시 IllegalArgumentException이 발생한다")
  void 음수_입력_예외() {
    assertThatThrownBy(() -> new PositiveNumber("-1"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("음수는 입력할 수 없습니다");
  }

  @Test
  @DisplayName("숫자가 아닌 값 입력 시 IllegalArgumentException이 발생한다")
  void 숫자가_아닌_값_예외() {
    assertThatThrownBy(() -> new PositiveNumber("abc"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("숫자가 아닌 값입니다");
  }
}
