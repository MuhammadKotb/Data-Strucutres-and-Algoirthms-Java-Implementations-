package com.company;

import java.util.ArrayList;

public class InsertionSort<T extends Comparable<T>> implements Sorter<T> {



    @Override
    public void sort(ArrayList<T> unsortedElements, int start, int end) {

        int arrIndex = 0;

        for(int i = start + 1; i <= end; i++){
            T tempElement = unsortedElements.get(i);


            for(int j = i - 1; j >= 0; j--){

                if(tempElement.compareTo(unsortedElements.get(j)) >= 0){
                    unsortedElements.add(j + 1, tempElement);
                    unsortedElements.remove(i + 1);
                    break;
                }
                if(j == 0){
                    unsortedElements.add(j, tempElement);
                    unsortedElements.remove(i + 1);
                }

            }
            arrIndex++;
        }
    }
}
