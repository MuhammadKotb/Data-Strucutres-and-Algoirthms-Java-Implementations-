import java.util.ArrayList;


public class HashTableQuadraticSpace<T extends Comparable<T>> {
    private ArrayList<T> hashTable;
    private int size;
    private UniversalHashing universalHashing;

    HashTableQuadraticSpace(int size){
        this.hashTable = new ArrayList<T>(size*size);
        this.universalHashing = new UniversalHashing(size*size);
        this.size = size*size;

    }
    public void insert(T data){
        int hashKey;
        hashKey = universalHashing.hashFunction(data.hashCode());
        if(hashTable.get(hashKey) == null){
            this.hashTable.set(hashKey, data);

        }else{

            ArrayList<T> elements = hashTable;
            elements.add(data);
            universalHashing = new UniversalHashing(this.size);
            this.hashTable.clear();
            for (T element: elements ) {
                insert(data);
            }
        }
    }

    public Boolean lookUp(T data){
        int hashKey = universalHashing.hashFunction(data.hashCode());

        if(this.hashTable.get(hashKey) != data){
            return false;
        }else return true;
    }

    public boolean remove(T data){
        int hashKey = universalHashing.hashFunction(data.hashCode());
        if(this.hashTable.get(hashKey) == data){
            this.hashTable.remove(hashKey);
            return true;
        }else return false;

    }

    public boolean isEmpty(){
        return this.hashTable.isEmpty();
    }

    public ArrayList<T> getHashTable() {
        return hashTable;
    }
}
