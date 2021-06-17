package com.Anurag;

public class Part3 {
    public boolean twoOccurences(String stringa, String stringb)
    {
        int index=stringb.indexOf(stringa);
        int second_index=stringb.indexOf(stringa,index+1);
        return second_index != -1;
    }
    public String lastPart(String stringa, String stringb)
    {
        int index=stringb.lastIndexOf(stringa);
        if(index==-1)
            return stringb;
        else
            return stringb.substring(index);
    }
    public void  testing()
    {
        System.out.println("Stringa:by Stringb:A story by Abby--"+twoOccurences("by", "A story by Abby Long"));
        System.out.println("Stringa:a Stringb:banana--"+twoOccurences("a","banana"));
        System.out.println("Stringa:atg Stringb: ctgtatgta--"+twoOccurences("atg","ctgtatgta"));
        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("zoo","forest"));
    }
    public static void main(String[] args) {
        Part3 part3=new Part3();
        part3.testing();
    }
}
