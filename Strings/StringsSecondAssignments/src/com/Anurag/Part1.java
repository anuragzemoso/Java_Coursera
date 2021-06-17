package com.Anurag;

public class Part1 {
    public int findStopCodon(String dna,int startIndex,String stopCodon)
    {
        int index= dna.indexOf(stopCodon,startIndex);
        if ((index-startIndex)%3==0)
            return index;
        else
            return dna.length();
    }
    public void testFindStopCodon(){
        System.out.println(findStopCodon("ctcgtaagggcgtctggcccgtctctatgcctcgatgagccgagcacgtagg",3,"aag"));
        System.out.println(findStopCodon("ctcgtaagggcgtctggcccgtcttatgcctgatgagccgagcacgtagg",7,"atg"));
        System.out.println(findStopCodon("ctcgtaagggcgtctggcccgtcttatgcctgatgagccgagcacgtagg",11,"ctc"));
        System.out.println(findStopCodon("atgccctaa",0,"taa"));
    }
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
    public void testFindGene() {
        System.out.println(findGene("attagtagg"));
        System.out.println(findGene("aatgggtaga"));
        System.out.println(findGene("aaatttgggtaaa"));
        System.out.println(findGene("aatgaatgggtaaa"));

    }
    public void printAllGenes(String dna)
    {
        int index=0;
        while(true){
            int firstIndex=dna.indexOf("atg",index);
            int lastIndex=dna.indexOf("taa",firstIndex);
            if(firstIndex==-1||lastIndex==-1)
                break;
            else
                System.out.println(dna.substring(firstIndex,lastIndex+3));
            index=lastIndex+3;
        }
    }
    public static void main(String[] args) {
        Part1 part1=new Part1();
        part1.testFindStopCodon();
        part1.testFindGene();
        part1.printAllGenes("aatgaattggtaaatgggttaaaattgtataaa");
    }
}
