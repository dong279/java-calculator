package calculator.model.parser;

import calculator.model.Numbers;
import calculator.model.PositiveNumber;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomDelimiterParser {
  private static final String PREFIX = "//"; // 상수명 의미 명확화
  private static final String SUFFIX = "\\n"; // 상수명 의미 명확화

  public Numbers parse(String input){
    int suffixIndex = input.indexOf(SUFFIX); // newlineIndex → suffixIndex
    if (suffixIndex < 0){ // Validator 대신 내부 검증
      throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
    }
    String custom =  input.substring(PREFIX.length(), suffixIndex);
    String numberPart = input.substring(suffixIndex + SUFFIX.length());
    String regex = "[,:]|" + Pattern.quote(custom);

    List<PositiveNumber> list = Arrays.stream(numberPart.split(regex))
        .map(PositiveNumber::new)
        .collect(Collectors.toList());
    return new Numbers(list);
  }
}
