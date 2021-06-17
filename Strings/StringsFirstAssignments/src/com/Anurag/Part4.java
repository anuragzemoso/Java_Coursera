package com.Anurag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Part4 {
    public void findWebLinks() throws IOException {
        String item;
        URL url = new URL("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
        while ((item = read.readLine()) != null) {
            System.out.println(item);
            String itemLower = item.toLowerCase();
            int pos = itemLower.indexOf("youtube.com");
            if (pos != -1) {
                int beg = item.lastIndexOf("\"",pos);
                int end = item.indexOf("\"", pos+1);
                System.out.println(item.substring(beg+1,end));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Part4 part4=new Part4();
        part4.findWebLinks();
    }
}
