package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void run(){
        String input = InputView.read();
        int result = StringCalculator.calculate(input);
        OutputView.printResult(result);
    }
}
