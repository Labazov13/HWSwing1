package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileOperation {
    public FileOperation(String message) throws IOException {
        File file = new File("logFile.txt");
        try (FileWriter fileWriter = new FileWriter(file, true);){
            fileWriter.write(message);
        }
        catch (IOException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }
}
