package AcademyHw.Hw1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double number1 = getDouble();
        double number2 = getDouble();
        String operation = getOperation();
        Double result = calculate(number1, number2, operation);

        if (result != null) {
            System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
        }
    }

    public static double getDouble() {
        System.out.println("Введите число");
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("Число не распознано, попробуйте еще раз");
            scanner.next();
            number = getDouble();
        }
        return number;
    }

    public static String getOperation() {
        System.out.println("Введите операцию ");
        String text;
        String operation = null;
        if (scanner.hasNext()) {
            text = scanner.next();

            if (text.length() == 1 && (text.matches("[\\*\\/+-]") == true)) {
                operation = text;
            } else {
                System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
                operation = getOperation();
            }
        }
        return operation;
    }

    public static Double calculate(double number1, double number2, String operation) {
        Double result = null;
        if (number2 == 0 && operation.matches("\\/") ==true) {
            System.out.println("Деление на ноль невозможно");
        } else {
            switch (operation) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }
        }
        return result;
    }
}
