package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = calculate(input);
        System.out.println("결과 : " + result);
    }

    private static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        String numberPart = input;

        if(input.startsWith("//")) {
            int idx = input.indexOf("\\n");
            if (idx < 0) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
            String custom = input.substring(2,idx);
            delimiter = "[,:]|" + java.util.regex.Pattern.quote(custom);
            numberPart = input.substring(idx+2);
        }

        int sum = 0;
        for (String token : numberPart.split(delimiter)) {
            int num;
            try{
                num = Integer.parseInt(token.trim());
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("숫자가 아닌 값: " + token);
            }
            if (num < 0) {
                throw new IllegalArgumentException("음수는 사용 불가: " + num);
            }
            sum += num;
        }
        return sum;
    }
}
