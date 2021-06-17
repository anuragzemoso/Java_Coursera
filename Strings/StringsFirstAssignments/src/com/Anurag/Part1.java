package com.Anurag;

public class Part1 {
    public String findSimpleGene(String dna)
    {
        dna=dna.toUpperCase();
        int index1=dna.indexOf("ATG");
        if(index1==-1)
            return "";
        else
        {
            int index2=dna.indexOf("TAA",index1+1);
            if(index2==-1)
                return "";
            else{
                String subString=dna.substring(index1,index2+3);
                if(subString.length()%3==0)
                    return subString;
            }
        }
        return dna;
    }

    public void testSimpleGene(){
        System.out.println(findSimpleGene("attagtagg"));
        System.out.println(findSimpleGene("aatgggtaga"));
        System.out.println(findSimpleGene("aaatttgggtaa"));
        System.out.println(findSimpleGene("aatgaatggtaa"));
        System.out.println(findSimpleGene("aatgaattggtaa"));
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testSimpleGene();
    }
}
