package view;

import controller.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class View {
    private final ControllerForGeneratorPageHTML controllerForGeneratorPageHTML;
    private final PressureFreeFiltrationModeController pressureFreeFiltrationModeController;
    private final PressureFiltrationModeController pressureFiltrationModeController;
    private final PhreaticFiltrationModeController phreaticFiltrationModeController;

    public View(ControllerForGeneratorPageHTML controllerForGeneratorPageHTML, PressureFreeFiltrationModeController pressureFreeFiltrationModeController, PressureFiltrationModeController pressureFiltrationModeController, PhreaticFiltrationModeController phreaticFiltrationModeController) {
        this.controllerForGeneratorPageHTML = controllerForGeneratorPageHTML;
        this.pressureFreeFiltrationModeController = pressureFreeFiltrationModeController;
        this.pressureFiltrationModeController = pressureFiltrationModeController;
        this.phreaticFiltrationModeController=phreaticFiltrationModeController;
    }


    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    //Метод для открытия файла

    /**
     * Метод для открытия файла
     * @param filePath - путь к файлу, котороый собираемся открыть
     */
    private void openFile (String filePath){
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        while (true) {
            System.out.println("Выбор режима фильтрации:");
            System.out.println("1. Безнапорный");
            System.out.println("2. Напорный");
            System.out.println("3. Напорно-безнапорный");
            System.out.println("4. Показать теорию");
            System.out.println("5. Выход");

            String input = prompt("Выберите действие: ");
            switch (input) {
                case ("5"):
                    return;
                case ("1"):
                    System.out.println();
                    phreaticFiltrationModeController.phreaticFiltrationMode();
                    phreaticFiltrationModeController.saveInBD();
                    System.out.println();
                    System.out.println("1. Отчёт");
                    System.out.println("2. Выход");
                    String input1 = prompt("Выберите действие: ");
                    while (!(input1.equals("1") || input1.equals("2"))) {
                        System.out.println("Неверная команда!");
                        System.out.println("1. Отчёт");
                        System.out.println("2. Выход");
                        input1 = prompt("Выберите действие: ");
                    }
                    if (input1.equals("1")){
                        controllerForGeneratorPageHTML.phreaticFiltrationModeHTMLPageGenerator();
                        openFile("Безнапорная фильтрация.html");
                    }
                    System.out.println();
                    break;
                case ("2"):
                    System.out.println();
                    pressureFiltrationModeController.pressureFiltrationMode();
                    pressureFiltrationModeController.saveInBD();
                    System.out.println();
                    System.out.println("1. Отчёт");
                    System.out.println("2. Выход");
                    String input2 = prompt("Выберите действие: ");
                    while (!(input2.equals("1") || input2.equals("2"))) {
                        System.out.println("Неверная команда!");
                        System.out.println("1. Отчёт");
                        System.out.println("2. Выход");
                        input2 = prompt("Выберите действие: ");
                    }
                    if (input2.equals("1")){
                        controllerForGeneratorPageHTML.pressureFiltrationModeHTMLPageGenerator();
                        openFile("Напорная фильтрация.html");
                    }
                    System.out.println();
                    break;
                case ("3"):
                    System.out.println();
                    pressureFreeFiltrationModeController.pressureFreeFiltrationMode();
                    pressureFreeFiltrationModeController.saveInBD();
                    System.out.println();
                    System.out.println("1. Отчёт");
                    System.out.println("2. Выход");
                    String input3 = prompt("Выберите действие: ");
                    while (!(input3.equals("1") || input3.equals("2"))) {
                        System.out.println("Неверная команда!");
                        System.out.println("1. Отчёт");
                        System.out.println("2. Выход");
                        input3 = prompt("Выберите действие: ");
                    }
                    if (input3.equals("1")){
                      controllerForGeneratorPageHTML.pressureFreeFiltrationModeHTMLPageGenerator();
                        openFile("Напорно-безнапорная фильтрация.html");
                    }
                    System.out.println();
                    break;
                case ("4"):
                    openFile("Теория.pdf");
                    break;
                default:
                    System.out.println("Неизвестная команда!");
                    break;

            }

        }
    }

}
