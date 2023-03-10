package com.javarush.cryptanalyser.abdeev.services;

import com.javarush.cryptanalyser.abdeev.constants.Alphabet;



public class Decoder {
    public String decoder (String originalText, int key){
            Encryptor encryptor = new Encryptor();

            return encryptor.encryptorStart(originalText, Alphabet.ALPHABET.length()-(key%Alphabet.ALPHABET.length()));


    }
}
