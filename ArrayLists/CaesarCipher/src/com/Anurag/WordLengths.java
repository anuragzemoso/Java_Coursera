package com.Anurag;

import edu.duke.FileResource;

public class WordLengths {

    public void countWordLengths(FileResource Resource, int[] counts) {
        for (String word : Resource.words()){
            int Wordlength = word.length();
            for (int i=0; i<word.length();i++){
                char currChar = word.charAt(i);
                if ((i==0) || (i==word.length()-1)){
                    if (!Character.isLetter(currChar)) Wordlength--;
                }
            }
            counts[Wordlength]++;
            System.out.println(" Words of length "+ Wordlength +" "+ word);
        }
    }

    public int indexOfMax (int[] values) {
        if (values.length == 0)
            return -1;

        int maxIdx = 0;
        for (int k = 0; k < values.length; k++)
            if (values[k] > values[maxIdx])
                maxIdx = k;
        return maxIdx;
    }

    public void testCountWordLengths(){
        FileResource Resource = new FileResource();
        int [] counts = new int[31];
        countWordLengths(Resource,counts);
        indexOfMax(counts);
    }
}
