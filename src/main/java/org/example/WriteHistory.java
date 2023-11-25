package org.example;

import java.io.*;

public class WriteHistory {


    public WriteHistory(ClientChat clientChat) throws IOException {
        File file = new File("logFile.txt");
        try (FileReader reader = new FileReader(file);
             FileWriter writer = new FileWriter(file, true);
             BufferedReader bufferedReader = new BufferedReader(reader))
        {
            while (bufferedReader.ready()){
                String line = bufferedReader.readLine();
                clientChat.area.append(line + "\n");
            }
        }

    }
}
