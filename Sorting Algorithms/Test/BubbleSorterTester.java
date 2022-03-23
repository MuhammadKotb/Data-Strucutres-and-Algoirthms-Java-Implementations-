

import com.company.BubbleSort;
import org.junit.*;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Random;


public class BubbleSorterTester {

    @Test
    public void test(){

        BubbleSort<Integer> sorter = new BubbleSort<>();
        ArrayList<Integer> unsortedElements = new ArrayList<>();
        ArrayList<Integer> MockupUnsortedElements = new ArrayList<>();
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
