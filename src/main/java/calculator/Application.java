package calculator;

import camp.nextstep.edu.missionutils.Console;
import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        try {
            CalculatorController controller = new CalculatorController();
            controller.run();
        } finally {
            Console.close();
        }
    }
}