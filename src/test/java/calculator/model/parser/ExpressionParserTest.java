package calculator.model.parser;

import calculator.model.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionParserTest {

  private ExpressionParser parser;

  @BeforeEach
  void setUp() {
    parser = new ExpressionParser();
  }

  @Test
  @DisplayName("null 입력 시 0을 반환한다")
  void null_입력() {
    Numbers numbers = parser.parse(null);
    assertThat(numbers.sum()).isEqualTo(0);
  }

  @Test
  @DisplayName("빈 문자열 입력 시 0을 반환한다")
  void 빈_문자열_입력() {
    Numbers numbers = parser.parse("");
    assertThat(numbers.sum()).isEqualTo(0);
  }

  @Test
  @DisplayName("기본 구분자 입력 시 DefaultDelimiterParser를 사용한다")
  void 기본_구분자_사용() {
    Numbers numbers = parser.parse("1,2,3");
    assertThat(numbers.sum()).isEqualTo(6);
  }

  @Test
  @DisplayName("커스텀 구분자 입력 시 CustomDelimiterParser를 사용한다")
  void 커스텀_구분자_사용() {
    Numbers numbers = parser.parse("//;\\n1;2;3");
    assertThat(numbers.sum()).isEqualTo(6);
  }
}
