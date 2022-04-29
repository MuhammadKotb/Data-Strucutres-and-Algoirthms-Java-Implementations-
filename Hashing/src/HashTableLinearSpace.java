import java.util.ArrayList;

public class HashTableLinearSpace<T extends Comparable<T>>{
    private ArrayList<HashTableQuadraticSpace<T>> hashTable;
    private int size;
    private UniversalHashing universalHashing;
    HashTableLinearSpace(int size){
        this.hashTable = new ArrayList<>(size);
        this.size = size;
        for (int i = 0; i < size; i++) {
            this.hashTable.set(i, new HashTableQuadraticSpace<>(1));
        }
        this.universalHashing = new UniversalHashing(size);
    }

    public void insert(T data) {
        int hashKey = universalHashing.hashFunction(data.hashCode());
        if(this.hashTable.get(hashKey).isEmpty()){
            this.hashTable.get(hashKey).insert(data);

        }else{
            ArrayList<T> elements = this.hashTable.get(hashKey).getHashTable();
            elements.add(data);
            this.hashTable.set(hashKey, new HashTableQuadraticSpace<>(elements.size());
            for (T element: elements) {
                this.hashTable.get(hashKey).insert(element);
            }
        }
    }
    public Boolean lookUp(T data){
        int hashKey = universalHashing.hashFunction(data.hashCode());
        return  this.hashTable.get(hashKey).lookUp(data);
    }

    public boolean remove(T data){
        int hashKey = universalHashing.hashFunction(data.hashCode());
        return this.hashTable.get(hashKey).remove(data);

    }
}
