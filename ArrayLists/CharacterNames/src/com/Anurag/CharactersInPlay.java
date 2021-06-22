package com.Anurag;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> characterNames;
    private ArrayList<Integer> characterFrequencies;

    public CharactersInPlay() {
        characterNames = new ArrayList<String>();
        characterFrequencies = new ArrayList<Integer>();
    }

    private int mainCharacterSpeakingThreshold = 13;

    private boolean hasValue (String s) { return s != null && ! s.isEmpty(); }

    public void update(String person) {
        int index = characterNames.indexOf(person);
        if (index == -1) {
            characterNames.add(person);
            characterFrequencies.add(1);
        } else {
            int freq = characterFrequencies.get(index);
            characterFrequencies.set(index, freq + 1);
        }
    }

    public void findAllCharacters() {
        characterNames.clear();
        characterFrequencies.clear();

        FileResource fileResource = new FileResource();
        for (String line : fileResource.lines()) {
            if (line.contains(".")) {
                int index = line.indexOf(".");
                String character = line.substring(0, index);
                update(character);
            }
        }
    }
    private boolean isMainCharacter (String person) {
        if (! hasValue(person)) return false;
        int index = characterNames.indexOf(person);
        int freq = characterFrequencies.get(index);
        return freq > mainCharacterSpeakingThreshold;
    }

    public void tester() {
        characterNames.clear();
        characterFrequencies.clear();

        findAllCharacters();
        int maxIndex = findIndexOfMax();
        System.out.println("Character with highest speaking parts: "+characterNames.get(maxIndex)+" "+characterFrequencies.get(maxIndex));
        for (int k = 0; k < characterNames.size(); k++) {
            String person = characterNames.get(k);
            if (isMainCharacter(person))
                System.out.println(person+":\t"+characterFrequencies.get(k));
        }

        System.out.println("\nCharacters with 10 to 15 parts");
        charactersWithNumParts(10,15);
    }
    
    public void charactersWithNumParts (int num1, int num2) {
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        for (int k = 0; k < characterNames.size(); k++) {
            String person = characterNames.get(k);
            int parts = characterFrequencies.get(k);
            if (num1 <= parts && parts <= num2)
                System.out.println(person+":\t"+parts);
        }
    }
    public int findIndexOfMax(){
        int max = characterFrequencies.get(0);
        int maxIndex = 0;
        for(int k=0; k < characterFrequencies.size(); k++){
            if (characterFrequencies.get(k) > max){
                max = characterFrequencies.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}