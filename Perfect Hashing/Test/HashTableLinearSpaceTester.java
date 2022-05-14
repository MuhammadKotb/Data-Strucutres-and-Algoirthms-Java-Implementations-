import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HashTableLinearSpaceTester {
    @Test
    public void determinedtest(){

        HashTableLinearSpace<Integer> hashTable = new HashTableLinearSpace<>(10);
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

        try{
            for (int input: inputs) {
                hashTable.insert(input);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Collisions: " + hashTable.getCollisons());
        Assert.assertEquals(true,hashTable.lookUp(5));
        Assert.assertEquals(false,hashTable.lookUp(10));
        Assert.assertEquals(true,hashTable.lookUp(9));
        Assert.assertEquals(true,hashTable.lookUp(4));
        hashTable.remove(54);
        Assert.assertEquals(false,hashTable.lookUp(54));
    }
}
