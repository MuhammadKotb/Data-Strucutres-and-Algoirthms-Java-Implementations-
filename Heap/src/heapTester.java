import org.junit.*;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;



public class heapTester{






    @Test
    public void testHeapIntegerInsert(){

        Heap<Integer> heap = new Heap<>();
        PriorityQueue<Integer> javaHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        try{
            for(int i = 0; i < 10000; i++){
                int randInt = rand.nextInt() % 1000000;
                heap.insert(randInt);
                javaHeap.add(randInt);
            }
            Assert.assertEquals(heap.toString(), javaHeap.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testHeapIntegerDeleteMin(){
        Heap<Integer> heap = new Heap<>();
        PriorityQueue<Integer> javaHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for(int i = 0; i < 10000; i++){
            int randInt = rand.nextInt() % 1000000;
            heap.insert(randInt);
            javaHeap.add(randInt);
        }
        for(int i = 0; i < 7000; i++){
            javaHeap.remove();
            heap.deleteMin();
        }
        Assert.assertEquals(heap.toString(), javaHeap.toString());

    }

    @Test
    public void testHeapSort(){

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayListHeap = new ArrayList<>();
        Heap<Integer> heapBuild = new Heap<>();
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        try{
            for(int i = 0; i < 10000; i++){
                int randInt = rand.nextInt() % 1000000;
                arrayList.add(randInt);
            }
            arrayList.sort((x, y) -> Integer.compare(y, x));
            arrayListHeap = heapBuild.HeapSort(arrayList);
            Assert.assertEquals(arrayListHeap.toString(), arrayList.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }




}
