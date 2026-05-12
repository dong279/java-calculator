package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final StringCalculator calculator;

    public CalculatorController(StringCalculator calculator) {
        this.calculator = calculator;
    }

    public void run(){
        String input = InputView.read();
        int result = StringCalculator.calculate(input);
        OutputView.printResult(result);
    }
}
