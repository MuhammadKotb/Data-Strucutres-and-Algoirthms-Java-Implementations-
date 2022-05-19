import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class Tester {
    @Test
    public void insertionTest(){
        Integer size = 20;
        ArrayList<Integer> data = new ArrayList<>();
        BTree<Integer> bTree = new BTree<>(3);
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            data.add(rand.nextInt());
        }
        for (int i = 0; i < size; i++) {
            System.out.println(i);
            bTree.insert(data.get(i));
        }


    }
}
