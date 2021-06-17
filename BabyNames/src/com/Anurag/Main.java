package com.Anurag;


import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

class BabyBirthsAssignment {
    public void totalBirths(FileResource fileParser) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int boys=0,girls=0;
        for (CSVRecord rec : fileParser.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                boys++;
                totalBoys += numBorn;
            }
            else {
                girls++;
                totalGirls += numBorn;
            }
        }
        System.out.println("Total births = " + totalBirths);
        System.out.println("Female girls = " + totalGirls);
        System.out.println("Male boys = " + totalBoys);
        System.out.println("Girls Names:"+girls);
        System.out.println("Boys Names:"+boys);
    }
    public int getRank(int year,String name,String gender){
        FileResource fileResource=new FileResource("src/com/Anurag/us_babynames_by_year/yob"+year+".csv");
        int rank=0;
        for (CSVRecord csvRecord:fileResource.getCSVParser(false)) {
            if(csvRecord.get(1).equals(gender)){
                rank++;
                if(csvRecord.get(0).equals((name)))
                    return rank;}
        }
        return -1;
    }
    public String getName(int year,int rank,String gender){
        FileResource fileResource=new FileResource("src/com/Anurag/us_babynames_by_year/yob"+year+".csv");
        String name="NO NAME";
        int count=0;
        for(CSVRecord csvRecord:fileResource.getCSVParser(false)){
            if(csvRecord.get(1).equals(gender))
                count++;
            if(count==rank){
                name=csvRecord.get(0);
                break;} }
        return name;
    }
    public void whatIsNameInYear(String name,int year,int newYear,String gender){
        int rank=getRank(year,name,gender);
        String newName=getName(newYear,rank,gender);
        if(gender.equals("F"))
            System.out.println(name+" born in "+year+" would be "+newName+" if she was born in "+newYear+".");
        else
            System.out.println(name+" born in "+year+" would be "+newName+" if he was born in "+newYear+".");
    }
    public int yearOfHighestRank(String name,String gender){
        DirectoryResource directoryResource=new DirectoryResource();
        int maxYear=-1,maxRank=Integer.MAX_VALUE,rank;
        for (File file : directoryResource.selectedFiles())
        {
            String yearName=file.getName().substring(3,7);
            int year=Integer.parseInt(yearName);
            FileResource fileResource=new FileResource(file);
            fileResource.getCSVParser();
            rank=getRank(year,name,gender);
            //System.out.println(rank+" "+name);
            if(rank<maxRank&&rank>0) {
                maxRank=rank;
                maxYear = year;
            }
        }
        return maxYear;
    }
    public double getAverageRank(String name,String gender){
        DirectoryResource directoryResource=new DirectoryResource();
        double avgRank=-1,rankSum=0;
        int rank,count=0;
        for (File file : directoryResource.selectedFiles())
        {
            String yearName=file.getName().substring(3,7);
            int year=Integer.parseInt(yearName);
            FileResource fileResource=new FileResource(file);
            fileResource.getCSVParser();
            rank=getRank(year,name,gender);
            if(rank==-1)
                continue;
            count++;
            rankSum=rankSum+rank;
        }
        //System.out.println(count);
        if(count>0)
            avgRank=rankSum/count;
        return avgRank;
    }
    public int getTotalBirthsRankedHigher(int year,String name,String gender){
        int rank=getRank(year,name,gender),count=1;
        FileResource fileResource=new FileResource("src/com/Anurag/us_babynames_by_year/yob"+year+".csv");
        int rankSum=0;
        for (CSVRecord csvRecord:fileResource.getCSVParser(false)) {
            if(count==rank)
                break;
            if(csvRecord.get(1).equals(gender)){
                rankSum=rankSum+Integer.parseInt(csvRecord.get(2));
                count++;}
        }
        return rankSum;
    }
    public static void main(String[] args) {
        BabyBirthsAssignment babyBirthsAssignment=new BabyBirthsAssignment();
        FileResource fileResource=new FileResource("src/com/Anurag/us_babynames_by_year/yob1990.csv");
        babyBirthsAssignment.totalBirths(fileResource);
        System.out.println(babyBirthsAssignment.getRank(1971,"Frank","M"));
        System.out.println(babyBirthsAssignment.getName(1982,450,"M"));
        babyBirthsAssignment.whatIsNameInYear("Owen",1974,2014,"M");
        System.out.println(babyBirthsAssignment.yearOfHighestRank("Mich","M"));
        System.out.println(babyBirthsAssignment.getAverageRank("Robert","M"));
        System.out.println(babyBirthsAssignment.getTotalBirthsRankedHigher(1990,"Emily","F"));
    }
}
