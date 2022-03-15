package RBAnalyser;

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

    public String[] randomBatch(int batchSize){
        String[] batch = new String[batchSize];
        for (int i = 0; i < batchSize; i++) {
            batch[i] = this.randomise();
        }
        return batch;
    }
}
