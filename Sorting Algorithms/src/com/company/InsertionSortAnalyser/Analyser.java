package com.company.InsertionSortAnalyser;



public class Analyser {


    public static void main(String[] arg) {
        Tester tester = new Tester();
        long average = 0, sum = 0;

        System.out.println("Time For Insertion sort First Batch With 10 Nodes: ");
        for(int i = 0; i < 10; i++){

            long start = System.currentTimeMillis();
            tester.insertionSortFirstBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


        System.out.println("Time For Insertion sort Second Batch With 100 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.insertionSortSecondBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;



        System.out.println("Time For Insertion sort Third Batch With 1000 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.insertionSortThirdBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


        System.out.println("Time For Insertion sort Fourth Batch With 10000 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.insertionSortFourthBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


        System.out.println("Time For Insertion sort Fifth Batch With 100000 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.insertionSortFifthBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


    }
}
