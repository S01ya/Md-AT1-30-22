package com.it_academy.calculator;

public class Calculator {

    public static Double summ(double number1, double number2) {
        double result = number1 + number2;
        return result;
    }

    public static Double subtract(double number1, double number2) {

        double result = number1 - number2;
        return result;
    }

    public static Double multiply(double number1, double number2) {
        double result = number1 * number2;
        return result;
    }

    public static Double divide(double number1, double number2) {
        Double result = null;
        if (number2 == 0) {
            System.out.println("Деление на ноль невозможно");
        } else {
            result = number1 / number2;
        }
        return result;
    }
}
