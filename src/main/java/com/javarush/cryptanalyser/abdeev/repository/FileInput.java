package com.javarush.cryptanalyser.abdeev.repository;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public  class FileInput {
    public static Path pathOfOriginalFile;

    public String fileToStringConversion(Path path){
        try {
            pathOfOriginalFile=path;
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения из файла");



        }

    }

}
