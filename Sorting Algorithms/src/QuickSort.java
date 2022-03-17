import java.util.ArrayList;

public class QuickSort<T extends Comparable<T>> implements Sorter<T> {

    private void swap(ArrayList<T> elements, int firstIndex, int secondIndex){

        T temp = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, temp);
    }

    /**
     * @param unsortedElements
     * @param start
     * @param end
     * @return the index of the pivot after moving the lower elements to left and the greater elements to the right
     */
    private int partition( ArrayList<T> unsortedElements, int start, int end){

        T pivotElement = unsortedElements.get(end);

        int lower = (start - 1);

        for (int j = start; j < end; j++) {
            if (unsortedElements.get(j).compareTo(pivotElement) < 0) {
                lower++;
                swap(unsortedElements, lower, j);
            }

        }
        swap(unsortedElements, lower + 1, end);

        return (lower + 1);
    }
    public void sort(ArrayList<T> unsortedElements, int start, int end) {
        if (start < end) {


            int pivotIndex = partition(unsortedElements, start, end);

            sort(unsortedElements, start, pivotIndex - 1);

            sort(unsortedElements, pivotIndex + 1, end);
        }
    }


}
