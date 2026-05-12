package calculator.model.parser;

import calculator.model.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomDelimiterParserTest {

  private CustomDelimiterParser parser;

  @BeforeEach
  void setUp() {
    parser = new CustomDelimiterParser();
  }

  @Test
  @DisplayName("세미콜론 커스텀 구분자로 파싱한다")
  void 세미콜론_커스텀_구분자() {
    Numbers numbers = parser.parse("//;\\n1;2;3");
    assertThat(numbers.sum()).isEqualTo(6);
  }

  @Test
  @DisplayName("커스텀 구분자와 기본 구분자를 혼합하여 파싱한다")
  void 커스텀_기본_구분자_혼합() {
    Numbers numbers = parser.parse("//;\\n1;2,3");
    assertThat(numbers.sum()).isEqualTo(6);
  }

  @Test
  @DisplayName("정규식 특수문자를 커스텀 구분자로 사용할 수 있다")
  void 특수문자_커스텀_구분자() {
    Numbers numbers = parser.parse("//.\\n1.2.3");
    assertThat(numbers.sum()).isEqualTo(6);
  }

  @Test
  @DisplayName("커스텀 구분자 형식이 올바른지 확인한다")
  void 커스텀_구분자_supports() {
    assertThat(parser.supports("//;\\n1;2;3")).isTrue();
    assertThat(parser.supports("1,2,3")).isFalse();
  }

  @Test
  @DisplayName("잘못된 커스텀 구분자 형식 시 IllegalArgumentException이 발생한다")
  void 잘못된_형식_예외() {
    assertThatThrownBy(() -> parser.parse("//;1;2;3"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("잘못된 커스텀 구분자 형식");
  }
}
