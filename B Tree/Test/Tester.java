import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class Tester {
    @Test
    public void insertionTest(){

        ArrayList<Integer> data = new ArrayList<>();
        BTree<Integer> bTree = new BTree<>(4);
//        Random rand = new Random();
//        for (int i = 0; i < size; i++) {
//            data.add(rand.nextInt());
//        }
        data.add(5);
        data.add(3);
        data.add(21);
        data.add(9);
        data.add(1);
        data.add(13);
        data.add(2);
        data.add(7);
        data.add(10);
        data.add(12);
        data.add(4);
        data.add(8);
        for (int i = 0; i < data.size(); i++) {
            System.out.println(i);
            bTree.insert(data.get(i));
        }


    }
}
