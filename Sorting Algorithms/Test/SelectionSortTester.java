import com.company.SelectionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;


public class SelectionSortTester {
    @Test
    public void test(){

        SelectionSort<Integer> sorter = new SelectionSort<>();
        ArrayList<Integer> unsortedElements = new ArrayList<Integer>();
        ArrayList<Integer> MockupUnsortedElements = new ArrayList<Integer>();
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        try{
            for(int i = 0; i <= 100000; i++) {
                int randInt = rand.nextInt() % 1000000;
                unsortedElements.add(randInt);
                MockupUnsortedElements.add(randInt);
            }
            sorter.sort(MockupUnsortedElements,0,100000);
            unsortedElements.sort((x, y) -> Integer.compare(x, y));

            Assertions.assertEquals(unsortedElements.toString(),MockupUnsortedElements.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
