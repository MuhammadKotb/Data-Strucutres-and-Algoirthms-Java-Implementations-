package com.company.InsertionSortAnalyser;




public class Analyser {


    public static void main(String[] arg) {
        Tester tester = new Tester();
        long start;


        System.out.println("Time For Insertion Sorting First Batch With 10 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionSortFirstBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


        System.out.println("Time For Insertion Sorting Second Batch With 100 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionSortSecondBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Insertion Sorting Third Batch With 1000 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionSortThirdBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Insertion Sorting Fourth Batch With 10000 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionSortFourthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Insertion Sorting Fifth Batch With 100000 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionSortFifthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


    }
}
