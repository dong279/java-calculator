package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

  private StringCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new StringCalculator();
  }

  @Test
  @DisplayName("빈 문자열 입력 시 0을 반환한다")
  void 빈_문자열_입력() {
    assertThat(calculator.calculate("")).isEqualTo(0);
  }

  @Test
  @DisplayName("쉼표 구분자로 합산한다")
  void 쉼표_구분자_합산() {
    assertThat(calculator.calculate("1,2,3")).isEqualTo(6);
  }

  @Test
  @DisplayName("콜론 구분자로 합산한다")
  void 콜론_구분자_합산() {
    assertThat(calculator.calculate("1:2:3")).isEqualTo(6);
  }

  @Test
  @DisplayName("커스텀 구분자로 합산한다")
  void 커스텀_구분자_합산() {
    assertThat(calculator.calculate("//;\\n1;2;3")).isEqualTo(6);
  }

  @Test
  @DisplayName("음수 입력 시 IllegalArgumentException이 발생한다")
  void 음수_입력_예외() {
    assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("음수는 입력할 수 없습니다");
  }

  @Test
  @DisplayName("숫자가 아닌 값 입력 시 IllegalArgumentException이 발생한다")
  void 숫자가_아닌_값_예외() {
    assertThatThrownBy(() -> calculator.calculate("a,b,c"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("숫자가 아닌 값입니다");
  }
}
