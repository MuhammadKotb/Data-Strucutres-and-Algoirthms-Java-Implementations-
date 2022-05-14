import java.util.ArrayList;

public class HashTableLinearSpace<T extends Comparable<T>> {
    private final ArrayList<HashTableQuadraticSpace<T>> hashTable;
    private final int size;
    private final UniversalHashing universalHashing;
    private int currSize;
    private int collisonsCtr;

    HashTableLinearSpace(int size) {
        this.hashTable = new ArrayList<>(size);
        this.size = size;
        for (int i = 0; i < size; i++) {
            this.hashTable.add(new HashTableQuadraticSpace<>(1));
        }
        this.universalHashing = new UniversalHashing(size);
        this.collisonsCtr = 0;
    }

    public void insert(T data) throws Exception {

        int hashKey = universalHashing.hashFunction(data.hashCode());
        if (currSize >= size) {
            throw new Exception("HashTable is Full");
        }
        if (this.hashTable.get(hashKey).isEmpty()) {
            this.hashTable.get(hashKey).insert(data);
            currSize++;

        } else if (this.hashTable.get(hashKey).lookUp(data).equals(data)) {
            this.hashTable.get(hashKey).insert(data);
        }
        else {
            ArrayList<T> elements = this.hashTable.get(hashKey).getValues();
            elements.add(data);
            this.hashTable.set(hashKey, new HashTableQuadraticSpace<>(elements.size()));
            for (T element : elements) {
                this.hashTable.get(hashKey).insert(element);
            }
            this.collisonsCtr++;
        }
    }

    public Boolean lookUp(T data) {
        int hashKey = universalHashing.hashFunction(data.hashCode());
        return this.hashTable.get(hashKey).lookUp(data);
    }

    public boolean remove(T data) {
        int hashKey = universalHashing.hashFunction(data.hashCode());
        return this.hashTable.get(hashKey).remove(data);
    }

    public int getCollisons() {
        for (HashTableQuadraticSpace table : hashTable) {
            collisonsCtr += table.getCollisons();
        }
        return collisonsCtr;
    }
}
