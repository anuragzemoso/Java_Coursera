package com.Anurag;

public class Part2 {
    public float cgRatio(String dna)
    {
        float cgRatio;
        int count=0;
        for(int i=0;i<dna.length();i++)
        {
            if(dna.charAt(i)=='C' || dna.charAt(i)=='G')
                count++;
        }
        cgRatio=(float)count/dna.length();
        return cgRatio;
    }
    public int countCTG(String dna)
    {
        int count=0,index=0;
        while(true){
            index=dna.indexOf("CTG",index);
            if(index==-1)
                break;
            count++;
            index=index+3;
            if(index>=dna.length())
                break;
        }
        return count;
    }
    public static void main(String[] args) {
        Part2 part2=new Part2();
        System.out.println("cgRation:"+part2.cgRatio("ATGCCATAG"));
        System.out.println("CTG Count:"+part2.countCTG("ACTGGGCTGGACTG"));
    }
}
