package com.company;

import java.util.ArrayList;

public class BubbleSort <T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(ArrayList<T> unsortedElements, int start, int end) {
        for(int i = start; i <= end; i++){
            for(int j = start; j < end; j++){
                if(unsortedElements.get(j).compareTo(unsortedElements.get(j + 1)) > 0){
                    T temp = unsortedElements.get(j + 1);
                    unsortedElements.set(j + 1, unsortedElements.get(j));
                    unsortedElements.set(j, temp);
                }
            }
        }
    }
}
