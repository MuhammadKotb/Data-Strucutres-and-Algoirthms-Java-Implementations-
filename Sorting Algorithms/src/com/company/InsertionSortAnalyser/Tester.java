package com.company.InsertionSortAnalyser;



import com.company.BubbleSort;
import com.company.InsertionSort;
import com.company.Randomizer;
import com.company.Sorter;

import java.util.ArrayList;

public class Tester {
    private  ArrayList<String> firstBatch;
    private  ArrayList<String> secondBatch;
    private  ArrayList<String> thirdBatch;
    private  ArrayList<String> fourthBatch;
    private  ArrayList<String> fifthBatch;
    private Sorter InsertionSort = new InsertionSort();





    public Tester(){
        Randomizer randomizer = new Randomizer();
    }

    public void insertionSortFirstBatch(){
        Randomizer randomizer = new Randomizer();
        this.firstBatch = randomizer.randomBatch(10);
        this.InsertionSort.sort(this.firstBatch,0, this.firstBatch.size()-1);
    }

    public void insertionSortSecondBatch(){
        Randomizer randomizer = new Randomizer();
        this.secondBatch = randomizer.randomBatch(100);
        this.InsertionSort.sort(this.secondBatch,0, this.secondBatch.size()-1);
    }

    public void insertionSortThirdBatch(){
        Randomizer randomizer = new Randomizer();
        this.thirdBatch = randomizer.randomBatch(1000);
        this.InsertionSort.sort(this.thirdBatch,0, this.thirdBatch.size()-1);
    }

    public void insertionSortFourthBatch(){
        Randomizer randomizer = new Randomizer();
        this.fourthBatch = randomizer.randomBatch(10000);
        this.InsertionSort.sort(this.fourthBatch,0, this.fourthBatch.size()-1);

    }

    public void insertionSortFifthBatch(){
        Randomizer randomizer = new Randomizer();
        this.fifthBatch = randomizer.randomBatch(100000);
        this.InsertionSort.sort(this.fifthBatch,0, this.fifthBatch.size()-1);

    }


}
