package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SaveInHTMLFileTest {
    SaveInHTMLFile saveInHTMLFile = new SaveInHTMLFile();

    @org.junit.jupiter.api.Test
    void saveInHTMLFile() {
        String filePath = "test.html";
        String htmlContent = "<html><body><h1>Hello, World!</h1></body></html>";
        saveInHTMLFile.saveInHTMLFile(filePath, htmlContent);
        try {
            String fileContent = Files.readString(Path.of(filePath));
            assertEquals(htmlContent, fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Clean up the test file
        File file = new File(filePath);
        file.delete();
    }
}
