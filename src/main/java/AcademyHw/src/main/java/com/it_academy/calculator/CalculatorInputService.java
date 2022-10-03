package com.it_academy.calculator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CalculatorInputService {
    private PrintStream printStream;
    private Scanner scanner;

    public CalculatorInputService(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }

    public double getDouble() {
        printStream.println("Введите число");
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            printStream.println("Число не распознано, попробуйте еще раз");
            scanner.next();
            number = getDouble();
        }
        return number;
    }
    private static final String SOME_REGEX = "[\\*\\/+-]"; // регулярное выражение, представляющее собой любой из
    // доступных символов операции (или * или / или - или +), по которому потом, с пом-. метода matches происходит сравнение, а затем и валидация введенных значений пользователя

    public String getOperation() {
        printStream.println("Введите операцию ");
        String text;
        String operation = null;
        if (scanner.hasNext()) {
            text = scanner.next();
            if (text.length() == 1 && (text.matches(SOME_REGEX) == true)) {
                operation = text;
            } else {
                printStream.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
                operation = getOperation();
            }
        }
        return operation;
    }
}
