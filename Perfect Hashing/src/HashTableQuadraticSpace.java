import java.util.ArrayList;


public class HashTableQuadraticSpace<T extends Comparable<T>> {
    private final ArrayList<T> hashTable;
    private final int size;
    private final int hashSize;
    private int currSize = 0;
    private final UniversalHashing universalHashing;
    private int collisonsCtr;

    HashTableQuadraticSpace(int size) {
        this.hashTable = new ArrayList<T>(size * size);
        this.universalHashing = new UniversalHashing(size * size);
        this.size = size * size;
        this.hashSize = size;
        this.collisonsCtr = 0;
        for (int i = 0; i < this.size; i++) {
            hashTable.add(null);
        }
    }

    public void insert(T data) throws Exception {
        int hashKey;
        hashKey = universalHashing.hashFunction(data.hashCode());
        if(currSize >= this.hashSize){
            throw new Exception("HashTable Is Full");
        }
        if (hashTable.get(hashKey) == null) {
            this.hashTable.set(hashKey, data);
            currSize++;
        }
        else if(hashTable.get(hashKey).equals(data)){
            this.hashTable.set(hashKey, data);
        }
        else {

            ArrayList<T> elements = this.getValues();
            elements.add(data);
            universalHashing.regenerateMatrix();
            this.hashTable.clear();
            currSize = 0;
            for (int i = 0; i < this.size; i++) {
                hashTable.add(null);
            }
            for (T element : elements) {
                insert(element);
            }
            collisonsCtr++;
        }
    }

    public Boolean lookUp(T data) {
        int hashKey = universalHashing.hashFunction(data.hashCode());
        return this.hashTable.get(hashKey) == data;
    }

    public boolean remove(T data) {
        int hashKey = universalHashing.hashFunction(data.hashCode());
        if (this.hashTable.get(hashKey) == data) {
            this.hashTable.set(hashKey, null);
            currSize--;
            return true;
        } else return false;

    }

    public int getCollisons() {
        return collisonsCtr;
    }

    public boolean isEmpty() {
        for (T entry : hashTable) {
            if (entry != null) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<T> getValues() {
        ArrayList<T> elements = new ArrayList<>();
        for (T element : hashTable) {
            if (element != null) {
                elements.add(element);
            }
        }
        return elements;
    }

    public int getCurrSize() {
        return currSize;
    }
    public void setCurrSize(int currSize){
        this.currSize = hashSize;
    }
    public int getSize(){
        return this.size;
    }
}
