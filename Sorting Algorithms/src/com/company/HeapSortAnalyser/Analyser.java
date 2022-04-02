package com.company.HeapSortAnalyser;



public class Analyser {


    public static void main(String[] arg) {
        Tester tester = new Tester();
        long average = 0, sum = 0;

        System.out.println("Time For Heapsort First Batch With 10 Nodes: ");
        for(int i = 0; i < 10; i++){

            long start = System.currentTimeMillis();
            tester.heapSortFirstBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


        System.out.println("Time For Heapsort Second Batch With 100 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.heapSortSecondBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;



        System.out.println("Time For Heapsort Third Batch With 1000 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.heapSortThirdBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


        System.out.println("Time For Heapsort Fourth Batch With 10000 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.heapSortFourthBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


        System.out.println("Time For Heapsort Fifth Batch With 100000 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.heapSortFifthBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


    }
}
