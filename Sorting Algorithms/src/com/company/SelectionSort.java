package com.company;

import java.util.ArrayList;

public class SelectionSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(ArrayList<T> unsortedElements, int start, int end) {
        for(int i = start; i <= end; i++){
            T min = unsortedElements.get(i);
            int minIndex = i;
            for(int j = i; j <= end; j++){
                if(unsortedElements.get(j).compareTo(min) < 0){
                    min = unsortedElements.get(j);
                    minIndex = j;
                }
            }
            T tempItem = unsortedElements.get(i);
            unsortedElements.set(i, min);
            unsortedElements.set(minIndex, tempItem);
        }
    }
}

