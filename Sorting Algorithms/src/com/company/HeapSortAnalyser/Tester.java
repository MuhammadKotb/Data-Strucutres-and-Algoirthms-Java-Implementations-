package com.company.HeapSortAnalyser;






import com.company.Heap;
import com.company.Randomizer;


import java.util.ArrayList;

public class Tester {
    private ArrayList<String> firstBatch;
    private ArrayList<String> secondBatch;
    private ArrayList<String> thirdBatch;
    private ArrayList<String> fourthBatch;
    private ArrayList<String> fifthBatch;
    private Heap heap = new Heap();


    public Tester() {
        Randomizer randomizer = new Randomizer();
        this.firstBatch = randomizer.randomBatch(10);
        this.secondBatch = randomizer.randomBatch(100);
        this.thirdBatch = randomizer.randomBatch(1000);
        this.fourthBatch = randomizer.randomBatch(10000);
        this.fifthBatch = randomizer.randomBatch(100000);
    }

    public void heapSortFirstBatch() {
        this.heap.heapSort(this.firstBatch);
    }

    public void heapSortSecondBatch() {
        this.heap.heapSort(this.secondBatch);
    }

    public void heapSortThirdBatch() {
        this.heap.heapSort(this.thirdBatch);
    }

    public void heapSortFourthBatch() {
        this.heap.heapSort(this.fourthBatch);
    }

    public void heapSortFifthBatch() {
        this.heap.heapSort(this.fifthBatch);

    }


}
