import java.util.ArrayList;
import java.lang.ProcessBuilder;
public class Main {


    public static void main(String[] args){
        Heap<Integer> heap = new Heap<>();


        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(8);
        arrayList.add(1);
        arrayList.add(14);
        arrayList.add(10);
        arrayList.add(5);
        arrayList.add(78);
        arrayList.add(12);
        arrayList.add(100);
        arrayList.add(-23);
        arrayList.add(544);
        arrayList.add(0);
        arrayList.add(44);


        System.out.println(heap.HeapSort(arrayList));



    }
}
