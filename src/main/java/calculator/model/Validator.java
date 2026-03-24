package calculator.model;

public class Validator {
    public static void validateCustomDelimiterFormat(int newlineIndex){
        if(newlineIndex < 0){
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
    }
    public static void validateNotNegative(int number){
        if(number < 0){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
        }
    }
}