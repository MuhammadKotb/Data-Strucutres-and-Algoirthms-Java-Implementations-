import java.util.ArrayList;

public interface Sorter<T extends Comparable<T>> {
    void sort(ArrayList<T> unsortedElements, int start, int end);
}
