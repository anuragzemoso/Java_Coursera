package com.Anurag;

public class Part3 {
    public String findGene(String dna){
        int firstIndex=dna.indexOf("atg");
        if(firstIndex==-1)
            return "";
        else{
            int indexTAA=findStopCodon(dna,firstIndex,"taa");
            int indexTAG=findStopCodon(dna,firstIndex,"tag");
            int indexTGA=findStopCodon(dna,firstIndex,"tga");
            int endIndex=Math.min(indexTGA,Math.min(indexTAG,indexTAA));
            if(endIndex==dna.length())
                return "";
            return dna.substring(firstIndex, endIndex + 3);
        }
    }
    public int findStopCodon(String dna,int startIndex,String stopCodon)
    {
        int index= dna.indexOf(stopCodon,startIndex);
        if ((index-startIndex)%3==0)
            return index;
        else
            return dna.length();
    }
    public int countGenes(String dna)
    {
        int index=0,count=0;
        while(true) {
            int firstIndex = dna.indexOf("atg", index);
            int lastIndex = dna.indexOf("taa", firstIndex);
            if (firstIndex == -1 || lastIndex == -1)
                break;
            else
                count++;
            index = lastIndex + 3;
        }
        return count;
    }
    public void testCountGenes()
    {
        System.out.println(countGenes("atgggtttataaatgaaggttaaaaggttatgaatggtagtaaa"));
        System.out.println(countGenes("atgtaagatgccctaagt"));
    }

    public static void main(String[] args) {
        Part3 part3=new Part3();
        part3.testCountGenes();
    }
}
