import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class HashTableQuadraticSpaceTester {
    @Test
    public void determinedtest(){
        int hashSize = 10;
        HashTableQuadraticSpace<Integer> hashTable = new HashTableQuadraticSpace<>(hashSize);
        ArrayList<Integer> inputs = new ArrayList<>();
        Random rand = new Random();

        for(int i = 0; i < hashSize; i++) {
            int randInt = rand.nextInt() % 1000;
            inputs.add(randInt);
        }
        System.out.println(inputs);


        try{
            for (int input: inputs) {
                hashTable.insert(input);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("Values: " + hashTable.getValues());
        System.out.println(hashTable.getSize());
        System.out.println("Collisions: " + hashTable.getCollisons());
        /*Assert.assertEquals(hashSize,hashTable.getValues().size());
        hashTable.remove(54);
        Assert.assertEquals(9,hashTable.getValues().size());
        Assert.assertEquals(false,hashTable.lookUp(54));*/

    }

    

}
