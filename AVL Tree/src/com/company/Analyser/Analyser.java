package com.company.Analyser;




public class Analyser {


    public static void main(String[] arg) {
        Tester tester = new Tester();
        long start;


        System.out.println("Time For AVL Insertion First Batch With 10 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionAVLFirstBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


        System.out.println("Time For AVL Insertion Second Batch With 100 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionAVLSecondBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For AVL Insertion Third Batch With 1000 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionAVLThirdBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For AVL Insertion Fourth Batch With 10000 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionAVLFourthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For AVL Insertion Fifth Batch With 100000 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionAVLFifthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For AVL Deletion First Batch With 10 Nodes: ");
        start = System.currentTimeMillis();
        tester.deletionAVLFirstBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


        System.out.println("Time For AVL Deletion Second Batch With 100 Nodes: ");
        start = System.currentTimeMillis();
        tester.deletionAVLSecondBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For AVL Deletion Third Batch With 1000 Nodes: ");
        start = System.currentTimeMillis();
        tester.deletionAVLThirdBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For AVL Deletion Fourth Batch With 10000 Nodes: ");
        start = System.currentTimeMillis();
        tester.deletionAVLFourthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For AVL Deletion Fifth Batch With 100000 Nodes: ");
        start = System.currentTimeMillis();
        tester.deletionAVLFifthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}
