import java.util.ArrayList;


public class HashTableQuadraticSpace<T extends Comparable<T>> {
    private ArrayList<T> hashTable;
    private int size;
    HashTableQuadraticSpace(int size){
        this.hashTable = new ArrayList<T>(size*size);
        this.size = size*size;

    }
    public void insert(T data){
        int hashKey;
        do {
            hashKey = UniversalHashing.hashFunction(data.hashCode(),this.size);
        }while (this.hashTable.get(hashKey) != null);
        this.hashTable.set(hashKey, data);
    }

    public Boolean lookUp(T data){
        int hashKey, i = 0;
        do {
            hashKey = UniversalHashing.hashFunction(data.hashCode(),this.hashTable.size()^2);
            i++;
        }while (this.hashTable.get(hashKey) != data && i < (this.hashTable.size()^2));
        if(this.hashTable.get(hashKey) != data){
            return false;
        }else return true;
    }
    public void remove(T data){
        int hashKey, i = 0;
        do {
            hashKey = UniversalHashing.hashFunction(data.hashCode(),this.size);
            i++;
        }while (this.hashTable.get(hashKey) != data && i < (this.size));
        if(this.hashTable.get(hashKey) == data){
            this.hashTable.remove(hashKey);
        }

    }
}
