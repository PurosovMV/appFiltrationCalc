package service;

import java.util.Scanner;

public class Scan {

    public double number(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);

        double result = 0.0;
        boolean isValid = false;

        while (!isValid) {
            String input = scanner.nextLine();
            if (isNumeric(input)) {
                result = Double.parseDouble(input);
                isValid = true;
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите число через точку.");
            }
        }


        return result;

    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
