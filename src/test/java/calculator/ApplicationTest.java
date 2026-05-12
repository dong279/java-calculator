package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("쉼표 구분자로 숫자를 더한다")
    void 쉼표_구분자() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    @DisplayName("콜론 구분자로 숫자를 더한다")
    void 콜론_구분자() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("쉼표와 콜론을 혼합하여 숫자를 더한다")
    void 쉼표_콜론_혼합_구분자() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자를 더한다")
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자를 혼합하여 숫자를 더한다")
    void 커스텀_구분자_기본_구분자_혼합() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("숫자가 하나일 때 그 숫자를 반환한다")
    void 숫자_하나() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("음수 입력 시 IllegalArgumentException이 발생한다")
    void 음수_입력_예외() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력 시 IllegalArgumentException이 발생한다")
    void 숫자가_아닌_값_예외() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("a,b,c"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 형식 입력 시 IllegalArgumentException이 발생한다")
    void 잘못된_커스텀_구분자_형식_예외() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;1;2;3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
