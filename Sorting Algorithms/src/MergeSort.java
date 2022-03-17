import java.util.ArrayList;

public class MergeSort <T extends Comparable<T>> implements Sorter<T> {


    private void merge(ArrayList<T> arrayList, int start, int middle, int end){

        ArrayList<T> tempArr = new ArrayList<>();

        int index1 = start;
        int index2 = middle + 1;

        while(index1 <= middle && index2 <= end){
            if(arrayList.get(index1).compareTo(arrayList.get(index2)) <= 0){
                tempArr.add(arrayList.get(index1));
                index1++;
            }
            else{
                tempArr.add(arrayList.get(index2));
                index2++;
            }
        }
        for(int i = index2; i <= end; i++){
            tempArr.add(arrayList.get(i));
        }
        for(int i = index1; i <= middle; i++){
            tempArr.add(arrayList.get(i));
        }

        int tempIndex = 0;
        for(int i = start; i <= end; i++){
            arrayList.set(i, tempArr.get(tempIndex));
            tempIndex++;
        }
    }


    @Override
    public void sort(ArrayList<T> unsortedElements, int start, int end) {
        if(start >= end)
            return;
        int middle = (start + end) / 2;

        sort(unsortedElements, start, middle);
        sort(unsortedElements, middle + 1, end);
        merge(unsortedElements, start, middle, end);

    }
}
