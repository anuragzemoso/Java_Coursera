package com.Anurag;


import edu.duke.FileResource;

public class TestCaesarCipherTwo {

    public void simpleTests() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        String breakCaesarCipher = breakCaesarCipher(message);
        System.out.println("The decryption is "+ breakCaesarCipher);
    }

    private String halfOfString(String my_message,int start) {
        String result = new String();
        for (int i = start; i < my_message.length(); i = i+2) {
            result = result + my_message.charAt(i);
        }
        return result;
    }

    private int[] countLetters(String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length();k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex!=-1){
                counts[dex]++;
            }
        }
        return counts;
    }

    private int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dKey = maxDex - 4;
        if (maxDex < 4) {
            dKey = 26 - (4 -maxDex);
        }
        return dKey;
    }


    private int maxIndex(int[] values) {
        int max = 0;
        int indexOfMax = 0;
        for(int k = 0;k<values.length;k++) {
            if (values[k]> max){
                max = values[k];
                indexOfMax = k;
            }

        }
        return indexOfMax;

    }

    private String breakCaesarCipher(String input) {

        String message1 = halfOfString(input,0);
        String message2 = halfOfString(input,1);
        int key1= getKey(message1);
        int key2= getKey(message2);

        CaesarCipherTwo cc3 = new CaesarCipherTwo(key1,key2);
        String decryption = cc3.decrypt(input);
        return decryption;
    }

}
