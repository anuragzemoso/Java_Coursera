package com.Anurag;

public class Part2 {
    public int howMany(String stringa,String stringb) {
        int count = 0, index = 0;
        while (true) {
            int firstIndex = stringb.indexOf(stringa, index);
            if (firstIndex == -1)
                break;
            count++;
            index = firstIndex + stringa.length();
            if (index >= stringb.length())
                break;
        }
        return count;
    }
    public void testHowMany(){
        System.out.println(howMany("GAA","ATGAACGAATTGAATC"));
        System.out.println(howMany("AA","ATAAAA"));
        System.out.println(howMany("A","AAAA"));
    }

    public static void main(String[] args) {
        Part2 part2=new Part2();
        part2.testHowMany();
    }
}
