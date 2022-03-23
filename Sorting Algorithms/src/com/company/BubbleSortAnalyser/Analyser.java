package com.company.BubbleSortAnalyser;


public class Analyser {


    public static void main(String[] arg) {
        Tester tester = new Tester();
        long start;


        System.out.println("Time For Bubble Sorting First Batch With 10 Nodes: ");
        start = System.currentTimeMillis();
        tester.bubbleSortFirstBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


        System.out.println("Time For Bubble Sorting Second Batch With 100 Nodes: ");
        start = System.currentTimeMillis();
        tester.bubbleSortSecondBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Bubble Sorting Third Batch With 1000 Nodes: ");
        start = System.currentTimeMillis();
        tester.bubbleSortThirdBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Bubble Sorting Fourth Batch With 10000 Nodes: ");
        start = System.currentTimeMillis();
        tester.bubbleSortFourthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Bubble Sorting Fifth Batch With 100000 Nodes: ");
        start = System.currentTimeMillis();
        tester.bubbleSortFifthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


    }
}
