import java.util.Random;

public class UniversalHashing {
    private final int b;
    private final int u;
    private int[][] randomMatrix;

    public UniversalHashing(int size) {
        b = (int) (Math.log(size) / Math.log(2));
        u = 32;
        randomMatrix = generateMatrix(b, u);
    }

    public void regenerateMatrix() {
        randomMatrix = generateMatrix(b, u);
    }

    private int[][] generateMatrix(int b, int u) {
        Random random = new Random();
        int[][] randomMatrix = new int[b][u];
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < u; j++) {
                randomMatrix[i][j] = random.nextInt(2);
            }
        }
        return randomMatrix;
    }

    private int[] getKeyVector(int key) {
        int[] keyVector = new int[32];
        String binaryKey = Integer.toBinaryString(key);
        for (int i = 0; i < 32 - binaryKey.length(); i++) {
            keyVector[i] = 0;
        }
        for (int i = 0; i < binaryKey.length(); i++) {
            keyVector[i + 32 - binaryKey.length()] = Character.getNumericValue(binaryKey.charAt(i));

        }
        return keyVector;
    }

    public int hashFunction(int key) {
        int result = 0;
        int[] hx = new int[this.b];
        int[] keyVector = getKeyVector(key);
        for (int i = 0; i < this.b; i++) {
            hx[i] = 0;
            for (int j = 0; j < this.u; j++) {
                hx[i] += (this.randomMatrix[i][j] * keyVector[j]) % 2;
            }
            hx[i] %= 2;
        }
        for (int k = 0; k < b; k++) {
            result += hx[k] * (Math.pow(2, b - 1 - k));
        }
        return Math.abs(result);
    }
}
