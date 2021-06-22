package com.Anurag;

import edu.duke.*;

public class CaesarCipher{

    private String Alphabet;
    private String ShiftedAlphabet;
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;

    public CaesarCipher(int key) {
        mainKey = key;
        Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabet = Alphabet.toLowerCase();
        ShiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
    }

    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder (input);
        for (int i = 0; i < encrypted.length();i++) {
            char currChar = encrypted.charAt(i);
            if (Character.isLowerCase(currChar))
            {
                int idx = alphabet.indexOf(currChar);
                // If currChar is in the alphabet
                if (idx !=-1) {
                    char newChar = shiftedAlphabet.charAt(idx);
                    // Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i,newChar);
                }
            }
            else {
                int idx = Alphabet.indexOf(currChar);
                if (idx !=-1){
                    char newChar = ShiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
        }
        return encrypted.toString();
    }

    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        String message = cc.encrypt(input);
        return message;
    }
}