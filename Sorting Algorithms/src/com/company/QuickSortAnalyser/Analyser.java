package com.company.QuickSortAnalyser;


public class Analyser {


    public static void main(String[] arg) {
        Tester tester = new Tester();
        long start;


        System.out.println("Time For Quick Sorting First Batch With 10 Nodes: ");
        start = System.currentTimeMillis();
        tester.quickSortFirstBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


        System.out.println("Time For Quick Sorting Second Batch With 100 Nodes: ");
        start = System.currentTimeMillis();
        tester.quickSortSecondBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Quick Sorting Third Batch With 1000 Nodes: ");
        start = System.currentTimeMillis();
        tester.quickSortThirdBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Quick Sorting Fourth Batch With 10000 Nodes: ");
        start = System.currentTimeMillis();
        tester.quickSortFourthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Quick Sorting Fifth Batch With 100000 Nodes: ");
        start = System.currentTimeMillis();
        tester.quickSortFifthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


    }
}
