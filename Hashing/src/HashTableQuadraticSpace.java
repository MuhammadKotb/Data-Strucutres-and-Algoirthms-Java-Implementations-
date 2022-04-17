import java.util.ArrayList;
import java.util.Random;



public class HashTableQuadraticSpace<T extends Comparable<T>> {
    private ArrayList<T> hashTable;
    HashTableQuadraticSpace(int size){
        this.hashTable = new ArrayList<T>(size);

    }
    public int hashFunction(T data, int bound){
        Random random = new Random();
        int r = random.nextInt(bound);
        return ((data.hashCode() + r) % bound) % bound/2;
    }
    public void insert(T data){
        int hashKey;
        do {
            hashKey = hashFunction(data,this.hashTable.size()^2);
        }while (this.hashTable.get(hashKey) != null);
        this.hashTable.set(hashKey, data);
    }

    public Boolean lookUp(T data){
        int hashKey, i = 0;
        do {
            hashKey = hashFunction(data,this.hashTable.size()^2);
            i++;
        }while (this.hashTable.get(hashKey) != data && i < (this.hashTable.size()^2));
        if(this.hashTable.get(hashKey) != data){
            return false;
        }else return true;
    }
    public void remove(T data){
        int hashKey, i = 0;
        do {
            hashKey = hashFunction(data,this.hashTable.size()^2);
            i++;
        }while (this.hashTable.get(hashKey) != data && i < (this.hashTable.size()^2));
        if(this.hashTable.get(hashKey) == data){
            this.hashTable.remove(hashKey);
        }

    }
}
