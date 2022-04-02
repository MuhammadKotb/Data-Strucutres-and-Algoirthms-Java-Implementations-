package com.company.MergeSortAnalyser;



public class Analyser {


    public static void main(String[] arg) {
        Tester tester = new Tester();

        long average = 0, sum = 0;

        System.out.println("Time For Merge sort First Batch With 10 Nodes: ");
        for(int i = 0; i < 10; i++){

            long start = System.currentTimeMillis();
            tester.mergeSortFirstBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


        System.out.println("Time For Merge sort Second Batch With 100 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.mergeSortSecondBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;



        System.out.println("Time For Merge sort Third Batch With 1000 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.mergeSortThirdBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


        System.out.println("Time For Merge sort Fourth Batch With 10000 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.mergeSortFourthBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;

        System.out.println("Time For Merge sort Fifth Batch With 100000 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.mergeSortFifthBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


    }
}
