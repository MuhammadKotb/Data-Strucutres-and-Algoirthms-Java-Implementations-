package com.company.QuickSortAnalyser;





import com.company.MergeSort;
import com.company.QuickSort;
import com.company.Randomizer;
import com.company.Sorter;

import java.util.ArrayList;

public class Tester {
    private  ArrayList<String> firstBatch;
    private  ArrayList<String> secondBatch;
    private  ArrayList<String> thirdBatch;
    private  ArrayList<String> fourthBatch;
    private  ArrayList<String> fifthBatch;
    private Sorter QuickSort = new QuickSort();





    public Tester(){
        Randomizer randomizer = new Randomizer();
    }

    public void quickSortFirstBatch(){
        Randomizer randomizer = new Randomizer();
        this.firstBatch = randomizer.randomBatch(10);
        this.QuickSort.sort(this.firstBatch,0, this.firstBatch.size()-1);
    }

    public void quickSortSecondBatch(){
        Randomizer randomizer = new Randomizer();
        this.secondBatch = randomizer.randomBatch(100);
        this.QuickSort.sort(this.secondBatch,0, this.secondBatch.size()-1);
    }

    public void quickSortThirdBatch(){
        Randomizer randomizer = new Randomizer();
        this.thirdBatch = randomizer.randomBatch(1000);
        this.QuickSort.sort(this.thirdBatch,0, this.thirdBatch.size()-1);
    }

    public void quickSortFourthBatch(){
        Randomizer randomizer = new Randomizer();
        this.fourthBatch = randomizer.randomBatch(10000);
        this.QuickSort.sort(this.fourthBatch,0, this.fourthBatch.size()-1);

    }

    public void quickSortFifthBatch(){
        Randomizer randomizer = new Randomizer();
        this.fifthBatch = randomizer.randomBatch(100000);
        this.QuickSort.sort(this.fifthBatch,0, this.fifthBatch.size()-1);

    }


}
