package com.Anurag;

import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        return "WRITE ME!";
    }


    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] error = {-1};
        if (encrypted == null || encrypted.isEmpty()) return error;
        if (klength < 1) return error;
        int[] key = new int[klength];
        CaesarCracker cracker = new CaesarCracker(mostCommon);
        for (int slice = 0; slice < key.length; slice++) {
            String thisSlice = sliceString(encrypted, slice, klength);
            key[slice] = cracker.getKey(thisSlice);
        }
        return key;
    }

    public char mostCommonCharIn (HashSet<String> dictionary) {
        if (dictionary == null || dictionary.isEmpty()) return ' ';
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
        for (String word : dictionary) {
            for (char c : word.toCharArray()) {
                if (alphabet.indexOf(c) != -1) {
                    counts.put(c, counts.getOrDefault(c, 0) + 1);
                }
            }
        }
        return maxValueKey(counts);
    }

    private char maxValueKey (HashMap<Character, Integer> map) {
        char maxKey = ' ';
        int maxValue = -1;
        for (char c : map.keySet()) {
            if (map.get(c) > map.getOrDefault(maxKey, 0)) {
                maxKey = c;
                maxValue = map.get(c);
            }
        }
        return maxKey;
    }
    public void breakForAllLangs (String encrypted, HashMap<String, HashSet<String>> languages) {
        if (encrypted == null || encrypted.isEmpty()) return;
        if (languages == null || languages.isEmpty()) return;

        int bestCount = 0;
        String bestLanguage = "";
        String bestDecrypt = "";
        for (String lang : languages.keySet()) {
            HashSet<String> dictionary = languages.get(lang);
            String decrypted = breakForLanguage(encrypted, dictionary);
            int count = countWords(decrypted, dictionary);
            if (count > bestCount) {
                bestCount = count;
                bestLanguage = lang;
                bestDecrypt = decrypted;
            }
        }

        System.out.println("Message in "+bestLanguage+":");
        System.out.println(bestDecrypt);
        System.out.println("----END----\n");
    }

    public String breakForLanguage (String encrypted, HashSet<String> dictionary) {
        //int maxKeyLength = encrypted.length();
        int maxKeyLength = 101;
        // verify parameters.
        if (encrypted == null || encrypted.isEmpty()) return "";
        if (dictionary == null || dictionary.isEmpty()) return "";

        // Need to remember the decrypt with the most words in the dictionary.
        String bestDecrypt = "";
        int bestCount = 0;

        // Try various key lengths, see which gives most words in dictionary.
        char mostCommon = mostCommonCharIn(dictionary);
        for (int klength = 1; klength < maxKeyLength; klength++) {
            int[] key = tryKeyLength(encrypted, klength, mostCommon);
            String decrypt = new VigenereCipher(key).decrypt(encrypted);
            int count = countWords(decrypt, dictionary);
            if (count > bestCount) {
                bestCount = count;
                bestDecrypt = decrypt;
            }
        }

        return bestDecrypt;
    }

    public void breakVigenere () {
        String encrypted = new FileResource().asString();
        HashMap<String, HashSet<String>> dictionaries = loadDictionaries();
        breakForAllLangs(encrypted, dictionaries);
    }

    private HashMap<String, HashSet<String>> loadDictionaries() {
        String[] langs = {"Danish", "Dutch", "English", "French", "German", "Italian", "Portuguese", "Spanish"};
        HashMap<String, HashSet<String>> dictionaries = new HashMap<String, HashSet<String>>();
        for (String lang : langs) {
            dictionaries.put(lang, readDictionary(new FileResource("src/dictionaries/"+lang)));
        }
        return dictionaries;
    }

    public HashSet<String> readDictionary (FileResource fr) {
        HashSet<String> dictionary = new HashSet<String>();
        for (String word : fr.words())
            dictionary.add(word.toLowerCase());
        return dictionary;
    }

    public int countWords (String message, HashSet<String> dictionary) {
        // verify parameters.
        if (message == null || message.isEmpty()) return 0;
        if (dictionary == null || dictionary.isEmpty()) return 0;

        // count the words.
        int count = 0;
        for (String word : message.split("\\W")) {
            if (dictionary.contains(word.toLowerCase()))
                count += 1;
        }
        return count;
    }
}
