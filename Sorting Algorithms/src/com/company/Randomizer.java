package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Randomizer {
    private String space = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789";

    private String randomise(){
        StringBuilder string = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            string.append(this.space.charAt(random.nextInt(this.space.length())));
        }
        return string.toString();

    }

    public ArrayList<String> randomBatch(int batchSize){
        ArrayList<String> batch = new ArrayList<>(batchSize);
        for (int i = 0; i < batchSize; i++) {
            batch.add(this.randomise());
        }
        return batch;
    }
}
