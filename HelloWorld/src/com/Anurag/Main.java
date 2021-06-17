package com.Anurag;

import edu.duke.FileResource;

class HelloWorld {
    public void runHello () {
        FileResource res = new FileResource();
        for (String line : res.lines()) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        HelloWorld helloWorld=new HelloWorld();
        helloWorld.runHello();
    }
}