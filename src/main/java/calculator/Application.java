package calculator;

import camp.nextstep.edu.missionutils.Console;
import calculator.controller.CalculatorController;
import calculator.model.StringCalculator;

public class Application {
    public static void main(String[] args) {
        try {
            CalculatorController controller = new CalculatorController(new StringCalculator());
            controller.run();
        } finally {
            Console.close();
        }
    }
}
