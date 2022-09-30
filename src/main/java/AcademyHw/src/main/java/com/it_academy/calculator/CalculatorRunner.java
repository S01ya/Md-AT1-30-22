package com.it_academy.calculator;

public class CalculatorRunner {

    public static Double calculate(double number1, double number2, String operation) {
       Double result = null;
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
        return result;
    }

    public static void main(String[] args) {
        CalculatorInputService service = new CalculatorInputService(System.in, System.out);
        double number1 = service.getDouble();
        double number2 = service.getDouble();
        String operation = service.getOperation();
        Double result = calculate(number1, number2, operation);

        if (result != null) {
            System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
        }
    }
}
