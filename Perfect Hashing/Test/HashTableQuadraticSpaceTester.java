import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class HashTableQuadraticSpaceTester {
    @Test
    public void determinedtest(){

        HashTableQuadraticSpace<Integer> hashTable = new HashTableQuadraticSpace<>(10);
        ArrayList<Integer> inputs = new ArrayList<>();
        inputs.add(5);
        inputs.add(4);
        inputs.add(7);
        inputs.add(9);
        inputs.add(8);
        inputs.add(14);
        inputs.add(11);
        inputs.add(16);
        inputs.add(20);
        inputs.add(54);
        for (int input: inputs) {
            hashTable.insert(input);
        }

        System.out.println("Values: " + hashTable.getValues());
        System.out.println("Collisions: " + hashTable.getCollisons());
        Assert.assertEquals(10,hashTable.getValues().size());
        hashTable.remove(54);
        Assert.assertEquals(9,hashTable.getValues().size());
        Assert.assertEquals(false,hashTable.lookUp(54));

    }

    

}
