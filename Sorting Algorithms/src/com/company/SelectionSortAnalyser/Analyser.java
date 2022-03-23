package com.company.SelectionSortAnalyser;


public class Analyser {


    public static void main(String[] arg) {
        Tester tester = new Tester();
        long start;


        System.out.println("Time For Selection Sorting First Batch With 10 Nodes: ");
        start = System.currentTimeMillis();
        tester.selectionSortFirstBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


        System.out.println("Time For Selection Sorting Second Batch With 100 Nodes: ");
        start = System.currentTimeMillis();
        tester.selectionSortSecondBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Selection Sorting Third Batch With 1000 Nodes: ");
        start = System.currentTimeMillis();
        tester.selectionSortThirdBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Selection Sorting Fourth Batch With 10000 Nodes: ");
        start = System.currentTimeMillis();
        tester.selectionSortFourthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Selection Sorting Fifth Batch With 100000 Nodes: ");
        start = System.currentTimeMillis();
        tester.selectionSortFifthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


    }
}
