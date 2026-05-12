package calculator.model.parser;

import calculator.model.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultDelimiterParserTest {

  private DefaultDelimiterParser parser;

  @BeforeEach
  void setUp() {
    parser = new DefaultDelimiterParser();
  }

  @Test
  @DisplayName("쉼표 구분자로 파싱한다")
  void 쉼표_구분자_파싱() {
    Numbers numbers = parser.parse("1,2,3");
    assertThat(numbers.sum()).isEqualTo(6);
  }

  @Test
  @DisplayName("콜론 구분자로 파싱한다")
  void 콜론_구분자_파싱() {
    Numbers numbers = parser.parse("1:2:3");
    assertThat(numbers.sum()).isEqualTo(6);
  }

  @Test
  @DisplayName("쉼표와 콜론 혼합 구분자로 파싱한다")
  void 혼합_구분자_파싱() {
    Numbers numbers = parser.parse("1,2:3");
    assertThat(numbers.sum()).isEqualTo(6);
  }

  @Test
  @DisplayName("숫자가 하나일 때 그 숫자를 반환한다")
  void 숫자_하나_파싱() {
    Numbers numbers = parser.parse("5");
    assertThat(numbers.sum()).isEqualTo(5);
  }
}
