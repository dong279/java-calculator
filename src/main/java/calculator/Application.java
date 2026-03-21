package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요");
        String input = Console.readLine();
    }

    private static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        String numberPart = input;

        int sum = 0;
        for (String token : numberPart.split(delimiter)) {
            int num;
            try{
                num = Integer.parseInt(token.trim());
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("숫자가 아닌 값: " + token);
            }
            sum += num;
        }
        return sum;
    }
}
