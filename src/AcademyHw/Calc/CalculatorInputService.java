package AcademyHw.Calc;

import java.util.Scanner;

public class CalculatorInputService {

    static Scanner scanner = new Scanner(System.in);

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

    private static final String SOME_REGEX = "[\\*\\/+-]"; // регулярное выражение, представляющее собой любой из
    // доступных символов операции (или * или / или - или +), по которому потом, с пом-. метода matches происходит сравнение, а затем и валидация введенных значений пользователя
    public static String getOperation() {
        System.out.println("Введите операцию ");
        String text;
        String operation = null;

        if (scanner.hasNext()) {
            text = scanner.next();

            if (text.length() == 1 && (text.matches(SOME_REGEX) == true)) {
                operation = text;
            } else {
                System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
                operation = getOperation();
            }
        }
        return operation;
    }
}
