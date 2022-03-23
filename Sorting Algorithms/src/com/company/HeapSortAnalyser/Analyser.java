package com.company.HeapSortAnalyser;


public class Analyser {


    public static void main(String[] arg) {
        Tester tester = new Tester();
        long start;


        System.out.println("Time For Heap Sorting First Batch With 10 Nodes: ");
        start = System.currentTimeMillis();
        tester.heapSortFirstBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


        System.out.println("Time For Heap Sorting Second Batch With 100 Nodes: ");
        start = System.currentTimeMillis();
        tester.heapSortSecondBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Heap Sorting Third Batch With 1000 Nodes: ");
        start = System.currentTimeMillis();
        tester.heapSortThirdBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Heap Sorting Fourth Batch With 10000 Nodes: ");
        start = System.currentTimeMillis();
        tester.heapSortFourthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Heap Sorting Fifth Batch With 100000 Nodes: ");
        start = System.currentTimeMillis();
        tester.heapSortFifthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


    }
}
