package com.Anurag;

import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder (input);
        // Write down the alphabet
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = Alphabet.toLowerCase();

        // Compute the shifted alphabet
        String ShiftedAlphabet = Alphabet.substring(key)+ Alphabet.substring(0,key);
        String shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        // Count from 0 to < length of encrypted,(call it i)
        for (int i = 0; i < encrypted.length();i++){
            char currChar = encrypted.charAt(i);
            if (Character.isLowerCase(currChar)) {
                int idx = alphabet.indexOf(currChar);
                if (idx !=-1){
                    char newChar = shiftedAlphabet.charAt(idx);
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
    public String encryptTwoKeys(String input, int key1, int key2) {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder (input);
        // Write down the alphabet
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        // Compute the shifted alphabet
        String ShiftedAlphabet1 = Alphabet.substring(key1)+ Alphabet.substring(0,key1);
        String shiftedAlphabet1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        String ShiftedAlphabet2 = Alphabet.substring(key2)+ Alphabet.substring(0,key2);
        String shiftedAlphabet2 = alphabet.substring(key2)+ alphabet.substring(0,key2);

        for (int i = 0; i <encrypted.length();i+=2){
            char currChar = encrypted.charAt(i);
            if ((i %2 == 0) && (Character.isLowerCase(currChar))) {
                int idx = alphabet.indexOf(currChar);
                if (idx!= -1)
                {
                    char newChar = shiftedAlphabet1.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
            else if ((i %2 == 0) && (Character.isUpperCase(currChar)))
            {
                int idx = Alphabet.indexOf(currChar);
                if (idx != -1)
                {
                    char newChar = ShiftedAlphabet1.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
        }

        for (int i = 1; i <encrypted.length();i+=2){
            char currChar = encrypted.charAt(i);
            if ((i %2 != 0) && (Character.isLowerCase(currChar)))
            {
                int idx = alphabet.indexOf(currChar);
                if (idx != -1)
                {
                    char newChar = shiftedAlphabet2.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
            else if ((i %2 != 0) && (Character.isUpperCase(currChar))) {
                int idx = Alphabet.indexOf(currChar);
                if (idx != -1)
                {
                    char newChar = ShiftedAlphabet2.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
        }
        return encrypted.toString();
    }

    public void testCaesar() {
//        int key = 17;
//        int key2 = 5;
//        FileResource fr = new FileResource();
//        String message = fr.asString();
        String encrypted = encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15);
        System.out.println(encrypted);
//        String decrypted = encrypt(encrypted, 26-key);
//        System.out.println(decrypted);
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
    }

    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();
        caesarCipher.testCaesar();
    }
}

