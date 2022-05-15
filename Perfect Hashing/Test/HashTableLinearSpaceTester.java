import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class HashTableLinearSpaceTester {
    @Test
    public void determinedtest(){

        int hashSize = 10;
        Random rand = new Random();
        HashTableLinearSpace<Integer> hashTable = new HashTableLinearSpace<>(hashSize);
        ArrayList<Integer> inputs = new ArrayList<>();
        for(int i = 0; i < hashSize; i++) {
            int randInt = rand.nextInt() % 1000;
            inputs.add(randInt);
        }

        try{
            for (int input: inputs) {
                hashTable.insert(input);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Collisions: " + hashTable.getCollisons());
        System.out.println(hashTable.getSize());

    }
}
