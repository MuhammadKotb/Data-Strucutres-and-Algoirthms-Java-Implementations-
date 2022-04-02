package com.company.HeapSortAnalyser;






import com.company.BubbleSort;
import com.company.Heap;
import com.company.Randomizer;
import com.company.Sorter;


import java.util.ArrayList;

public class Tester {
    private  ArrayList<String> firstBatch;
    private  ArrayList<String> secondBatch;
    private  ArrayList<String> thirdBatch;
    private  ArrayList<String> fourthBatch;
    private  ArrayList<String> fifthBatch;
    private Heap heap = new Heap();





    public Tester(){
        Randomizer randomizer = new Randomizer();
    }

    public void heapSortFirstBatch(){
        Randomizer randomizer = new Randomizer();
        this.firstBatch = randomizer.randomBatch(10);
        this.heap.heapSort(this.firstBatch);
    }

    public void heapSortSecondBatch(){
        Randomizer randomizer = new Randomizer();
        this.secondBatch = randomizer.randomBatch(100);
        this.heap.heapSort(this.secondBatch);
    }

    public void heapSortThirdBatch(){
        Randomizer randomizer = new Randomizer();
        this.thirdBatch = randomizer.randomBatch(1000);
        this.heap.heapSort(this.thirdBatch);
    }

    public void heapSortFourthBatch(){
        Randomizer randomizer = new Randomizer();
        this.fourthBatch = randomizer.randomBatch(10000);
        this.heap.heapSort(this.fourthBatch);

    }

    public void heapSortFifthBatch(){
        Randomizer randomizer = new Randomizer();
        this.fifthBatch = randomizer.randomBatch(100000);
        this.heap.heapSort(this.fifthBatch);

    }


}
