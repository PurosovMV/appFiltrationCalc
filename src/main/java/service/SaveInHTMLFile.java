package service;

import java.io.FileWriter;
import java.io.IOException;

public class SaveInHTMLFile {

    /**
     *
     * @param filePath - путь к файлу, в который сохраняем HTML страницу
     * @param htmlContent - записываемый контент типа String
     */
    public void saveInHTMLFile(String filePath, String htmlContent) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(htmlContent);
            fileWriter.close();
            System.out.println("HTML page generated successfully.");


        } catch (
                IOException e) {
            System.out.println("An error occurred while generating the HTML page.");
            e.printStackTrace();
        }
    }
}
