package com.company.MergeSortAnalyser;


public class Analyser {


    public static void main(String[] arg) {
        Tester tester = new Tester();
        long start;


        System.out.println("Time For Merge Sorting First Batch With 10 Nodes: ");
        start = System.currentTimeMillis();
        tester.mergeSortFirstBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


        System.out.println("Time For Merge Sorting Second Batch With 100 Nodes: ");
        start = System.currentTimeMillis();
        tester.mergeSortSecondBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Merge Sorting Third Batch With 1000 Nodes: ");
        start = System.currentTimeMillis();
        tester.mergeSortThirdBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Merge Sorting Fourth Batch With 10000 Nodes: ");
        start = System.currentTimeMillis();
        tester.mergeSortFourthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Merge Sorting Fifth Batch With 100000 Nodes: ");
        start = System.currentTimeMillis();
        tester.mergeSortFifthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


    }
}
