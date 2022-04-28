import java.util.Random;

public class UniversalHashing {
    

    private static int[][] generateMatrix(int b, int u){
        Random random = new Random();
        int[][] randomMatrix = new int[b][u];
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < u; j++) {
                randomMatrix[i][j] = random.nextInt(2);
            }

        }
        return randomMatrix;
    }

    private static int[] getKeyVector(int key){
        int[] keyVector = new int[32];
        for (int i = 0; i < 32; i++) {
            keyVector[i] = key % 2;
            key /= 2;
        }
        return keyVector;
    }

    public static int HashFunction(int key, int size){
        int b = (int)(Math.log(size) / Math.log(2));
        int u = 32, result = 0;
        int[] hx = new int[b];
        int[][] randomMatrix = generateMatrix(b, u);
        int[] keyVector = getKeyVector(key);
        for (int i = 0; i < b; i++) {
            hx[i] = 0;
            for (int j = 0; j < u; j++) {
                hx[i] += (randomMatrix[i][j] * keyVector[j] ) % 2;
            }
            hx[i] %= 2;
        }
        for (int k = 0; k < b; k++) {
            result += hx[k]*(Math.pow(2,k));
        }
        return result;
    }
}
