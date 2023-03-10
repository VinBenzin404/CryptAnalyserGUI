package com.javarush.cryptanalyser.abdeev.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOutput {
    public static String execPathStr;
    
    public Path createResultFile(Path pathOfOriginalFile){
        String pathStr = pathOfOriginalFile.toString();
        String newFileDir = Path.of(pathStr).getParent().toString();
        Path newFilePath = Path.of(newFileDir+"\\ResultFile0.txt");
        int i=1;
        while(Files.exists(newFilePath)){

            newFilePath = Path.of(newFileDir+"\\ResultFile"+i+".txt"); 
            i++;
        }
        
        try {
            execPathStr = newFilePath.toString();
            Files.createFile(newFilePath);
            return newFilePath;
        } catch (IOException e) {
            throw new RuntimeException("Не удалось создать файл!");
        }
    }

    public void writeResultToFile(String result){
        Path resultFile = createResultFile(FileInput.pathOfOriginalFile);
        try {
            Files.writeString(resultFile,result);
        } catch (IOException e) {
            throw new RuntimeException("Невозможно записать информацию в файл!");
        }
    }
}
