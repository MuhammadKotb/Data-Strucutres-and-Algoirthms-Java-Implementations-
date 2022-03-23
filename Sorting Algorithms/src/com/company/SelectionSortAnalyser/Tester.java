package com.company.SelectionSortAnalyser;






import com.company.Randomizer;
import com.company.SelectionSort;
import com.company.Sorter;

import java.util.ArrayList;

public class Tester {
    private ArrayList<String> firstBatch;
    private ArrayList<String> secondBatch;
    private ArrayList<String> thirdBatch;
    private ArrayList<String> fourthBatch;
    private ArrayList<String> fifthBatch;
    private Sorter selectionSorter = new SelectionSort();


    public Tester() {
        Randomizer randomizer = new Randomizer();
        this.firstBatch = randomizer.randomBatch(10);
        this.secondBatch = randomizer.randomBatch(100);
        this.thirdBatch = randomizer.randomBatch(1000);
        this.fourthBatch = randomizer.randomBatch(10000);
        this.fifthBatch = randomizer.randomBatch(100000);
    }

    public void selectionSortFirstBatch() {
        this.selectionSorter.sort(this.firstBatch, 0, this.firstBatch.size() - 1);
    }

    public void selectionSortSecondBatch() {
        this.selectionSorter.sort(this.secondBatch, 0, this.secondBatch.size() - 1);
    }

    public void selectionSortThirdBatch() {
        this.selectionSorter.sort(this.thirdBatch, 0, this.thirdBatch.size() - 1);
    }

    public void selectionSortFourthBatch() {
        this.selectionSorter.sort(this.fourthBatch, 0, this.fourthBatch.size() - 1);
    }

    public void selectionSortFifthBatch() {
        this.selectionSorter.sort(this.fifthBatch, 0, this.fifthBatch.size() - 1);

    }


}
