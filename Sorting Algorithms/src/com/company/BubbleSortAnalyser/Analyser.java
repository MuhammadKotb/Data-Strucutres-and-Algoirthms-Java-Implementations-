package com.company.BubbleSortAnalyser;


import java.util.ArrayList;

public class Analyser {


    public static void main(String[] arg) {
        Tester tester = new Tester();

        long average = 0, sum = 0;

        System.out.println("Time For Bubbble sort First Batch With 10 Nodes: ");
        for(int i = 0; i < 10; i++){

            long start = System.currentTimeMillis();
            tester.bubbleSortFirstBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


        System.out.println("Time For Bubbble sort Second Batch With 100 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.bubbleSortSecondBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;



        System.out.println("Time For Bubbble sort Third Batch With 1000 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.bubbleSortThirdBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


        System.out.println("Time For Bubbble sort Fourth Batch With 10000 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.bubbleSortFourthBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;

        System.out.println("Time For Bubbble sort Fifth Batch With 100000 Nodes: ");
        for(int i = 0; i < 10; i++){
            long start = System.currentTimeMillis();
            tester.bubbleSortFifthBatch();
            long end = System.currentTimeMillis();
            sum = sum + (end - start);
            System.out.println((end - start) + " ms");
        }
        average = sum / 10;
        System.out.println("Averge : " + average + " ms");
        sum = 0; average = 0;


    }
}
