package com.company.MergeSortAnalyser;




import com.company.InsertionSort;
import com.company.MergeSort;
import com.company.Randomizer;
import com.company.Sorter;

import java.util.ArrayList;

public class Tester {
    private  ArrayList<String> firstBatch;
    private  ArrayList<String> secondBatch;
    private  ArrayList<String> thirdBatch;
    private  ArrayList<String> fourthBatch;
    private  ArrayList<String> fifthBatch;
    private Sorter MergeSort = new MergeSort();





    public Tester(){
        Randomizer randomizer = new Randomizer();
    }

    public void mergeSortFirstBatch(){
        Randomizer randomizer = new Randomizer();
        this.firstBatch = randomizer.randomBatch(10);
        this.MergeSort.sort(this.firstBatch,0, this.firstBatch.size()-1);
    }

    public void mergeSortSecondBatch(){
        Randomizer randomizer = new Randomizer();
        this.secondBatch = randomizer.randomBatch(100);
        this.MergeSort.sort(this.secondBatch,0, this.secondBatch.size()-1);
    }

    public void mergeSortThirdBatch(){
        Randomizer randomizer = new Randomizer();
        this.thirdBatch = randomizer.randomBatch(1000);
        this.MergeSort.sort(this.thirdBatch,0, this.thirdBatch.size()-1);
    }

    public void mergeSortFourthBatch(){
        Randomizer randomizer = new Randomizer();
        this.fourthBatch = randomizer.randomBatch(10000);
        this.MergeSort.sort(this.fourthBatch,0, this.fourthBatch.size()-1);

    }

    public void mergeSortFifthBatch(){
        Randomizer randomizer = new Randomizer();
        this.fifthBatch = randomizer.randomBatch(100000);
        this.MergeSort.sort(this.fifthBatch,0, this.fifthBatch.size()-1);

    }



}
