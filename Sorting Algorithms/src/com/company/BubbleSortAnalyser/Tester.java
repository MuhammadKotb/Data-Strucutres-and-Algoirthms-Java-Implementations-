package com.company.BubbleSortAnalyser;



import com.company.BubbleSort;
import com.company.Randomizer;
import com.company.Sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Tester {
    private  ArrayList<String> firstBatch;
    private  ArrayList<String> secondBatch;
    private  ArrayList<String> thirdBatch;
    private  ArrayList<String> fourthBatch;
    private  ArrayList<String> fifthBatch;
    private Sorter bubbleSorter = new BubbleSort();





    public Tester(){
        Randomizer randomizer = new Randomizer();
        this.firstBatch = randomizer.randomBatch(10);
        this.secondBatch = randomizer.randomBatch(100);
        this.thirdBatch = randomizer.randomBatch(1000);
        this.fourthBatch = randomizer.randomBatch(10000);
        this.fifthBatch = randomizer.randomBatch(100000);
    }

    public void bubbleSortFirstBatch(){
        this.bubbleSorter.sort(this.firstBatch,0, this.firstBatch.size()-1);
    }

    public void bubbleSortSecondBatch(){
        this.bubbleSorter.sort(this.secondBatch,0, this.secondBatch.size()-1);
    }

    public void bubbleSortThirdBatch(){
        this.bubbleSorter.sort(this.thirdBatch,0, this.thirdBatch.size()-1);
    }

    public void bubbleSortFourthBatch(){
        this.bubbleSorter.sort(this.fourthBatch,0, this.fourthBatch.size()-1);

    }

    public void bubbleSortFifthBatch(){
        this.bubbleSorter.sort(this.fifthBatch,0, this.fifthBatch.size()-1);

    }


}
