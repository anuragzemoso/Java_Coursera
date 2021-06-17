package com.Anurag;

import edu.duke.StorageResource;

public class Part1 {
    public StorageResource getAllGenes(String dna)
    {
        int index=0;
        StorageResource storageResource = new StorageResource();
        while(true){
            int firstIndex=dna.indexOf("atg",index);
            int lastIndex=dna.indexOf("taa",firstIndex);
            if(firstIndex==-1||lastIndex==-1)
                break;
            else {
                storageResource.add(dna.substring(firstIndex,lastIndex+3));
                index = lastIndex + 3;
            }
        }
        return storageResource;
    }
    public static void main(String[] args) {
        Part1 part1=new Part1();
        StorageResource storageResource=new StorageResource();
        storageResource=part1.getAllGenes("aatgaattggtaaatgggttaaaattgtataaa");
        for (String string:storageResource.data()) {
            System.out.println(string);
        }
    }
}
