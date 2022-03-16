import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class quickSortTester {
    @Test
    public void test(){

        quickSort<Integer> sorter = new quickSort();
        ArrayList<Integer> unsortedElements = new ArrayList<Integer>();
        ArrayList<Integer> MockupUnsortedElements = new ArrayList<Integer>();
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        try{
            for(int i = 0; i <= 10000; i++) {
                int randInt = rand.nextInt() % 1000000;
                unsortedElements.add(randInt);
                MockupUnsortedElements.add(randInt);
            }
            sorter.sort(MockupUnsortedElements,0,10000);
            unsortedElements.sort((x, y) -> Integer.compare(x, y));

            Assertions.assertEquals(unsortedElements.toString(),MockupUnsortedElements.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
