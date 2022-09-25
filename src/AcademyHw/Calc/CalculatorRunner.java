package AcademyHw.Calc;

import static AcademyHw.Calc.Calculator.*;

public class CalculatorRunner {
    private static final String DIVIDE_REGEX = "\\/";

    public static Double calculate(double number1, double number2, String operation) {
        Double result = null;
        if (number2 == 0 && operation.matches(DIVIDE_REGEX) == true) {
            System.out.println("Деление на ноль невозможно");
        } else {
            switch (operation) {
                case "+":
                    result = Calculator.summ(number1, number2);
                    break;
                case "-":
                    result = Calculator.substract(number1, number2);
                    break;
                case "*":
                    result = Calculator.multiply(number1, number2);
                    break;
                case "/":
                    result = Calculator.divide(number1, number2);
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double number1 = CalculatorInputService.getDouble();
        double number2 = CalculatorInputService.getDouble();
        String operation = CalculatorInputService.getOperation();
        Double result = calculate(number1, number2, operation);

        if (result != null) {
            System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
        }
    }
}
