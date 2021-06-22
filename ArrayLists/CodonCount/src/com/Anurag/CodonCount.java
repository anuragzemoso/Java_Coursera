package com.Anurag;

import edu.duke.FileResource;

import java.util.HashMap;

public class CodonCount {
    private HashMap<String,Integer> DNA_Count;

    public CodonCount(){
        DNA_Count = new HashMap<String,Integer>();
    }

    public void buildCodonMap(int start, String dna){
        DNA_Count.clear();
        int totalCodons = 0; 
        int iterationNumber = 0;
        totalCodons = (dna.length()-start)/3;
        String current;
        while (iterationNumber <= totalCodons-1) {
            current = dna.substring(iterationNumber*3+start, iterationNumber*3+start+3);
            DNA_Count.put(current, DNA_Count.getOrDefault(current, 0)+1);
            iterationNumber = iterationNumber + 1;
        }
    }

    public String getMostCommonCodon() {
        int largest = 0;
        int current = 0;
        String largest_count = null;
        for (String index : DNA_Count.keySet()) {
            current = DNA_Count.get(index);
            if (largest < current) {
                largest = current;
                largest_count = index;
            }
        }
        return largest_count;
    }

    public void printCodonCounts(int start, int end) {
        int current = 0;
        for (String index : DNA_Count.keySet()) {
            current = DNA_Count.get(index);
            if (current >= start && current <= end)
                System.out.println(index+": "+current+"\t");
        }
    }
    public void test() {
        //String dna = "CGTTCAAGTTCAA";
        FileResource DNA = new FileResource();
        String dna = DNA.asString();
        int start = 1;
        int end = 5;

        buildCodonMap(0, dna);
        System.out.println("Reading frame starting with 0 results in "+DNA_Count.size()+" unique codons"+"\t");
        String the_largest_count = getMostCommonCodon();
        System.out.println("and most common codon is "+the_largest_count+" with count "+DNA_Count.get(the_largest_count)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);

        buildCodonMap(1, dna);
        System.out.println("Reading frame starting with 1 results in "+DNA_Count.size()+" unique codons"+"\t");
        the_largest_count = getMostCommonCodon();
        System.out.println("and most common codon is "+the_largest_count+" with count "+DNA_Count.get(the_largest_count)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);

        buildCodonMap(2, dna);
        System.out.println("Reading frame starting with 2 results in "+DNA_Count.size()+" unique codons"+"\t");
        the_largest_count = getMostCommonCodon();
        System.out.println("and most common codon is "+the_largest_count+" with count "+DNA_Count.get(the_largest_count)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);
    }
}
