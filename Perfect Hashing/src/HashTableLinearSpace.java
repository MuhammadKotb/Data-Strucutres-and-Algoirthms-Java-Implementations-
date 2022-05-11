import java.util.ArrayList;

public class HashTableLinearSpace<T extends Comparable<T>>{
    private ArrayList<HashTableQuadraticSpace<T>> hashTable;
    private int size;
    private UniversalHashing universalHashing;
    private int collisonsCtr;

    HashTableLinearSpace(int size){
        this.hashTable = new ArrayList<>(size);
        this.size = size;
        for (int i = 0; i < size; i++) {
            this.hashTable.add( new HashTableQuadraticSpace<>(1));
        }
        this.universalHashing = new UniversalHashing(size);
        this.collisonsCtr = 0;
    }

    public void insert(T data) {
        int hashKey = universalHashing.hashFunction(data.hashCode());
        if(this.hashTable.get(hashKey).isEmpty()){
            this.hashTable.get(hashKey).insert(data);

        }else{
            ArrayList<T> elements = this.hashTable.get(hashKey).getValues();
            elements.add(data);
            this.hashTable.set(hashKey, new HashTableQuadraticSpace<>(elements.size()));
            for (T element: elements) {
                this.hashTable.get(hashKey).insert(element);
            }
            this.collisonsCtr++;
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

    public int getCollisons() {
        for (HashTableQuadraticSpace table:hashTable) {
            collisonsCtr += table.getCollisons();
        }
        return collisonsCtr;
    }
}
