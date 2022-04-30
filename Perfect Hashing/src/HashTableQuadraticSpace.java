import java.util.ArrayList;


public class HashTableQuadraticSpace<T extends Comparable<T>> {
    private ArrayList<T> hashTable;
    private int size;
    private UniversalHashing universalHashing;
    private int collisonsCtr;

    HashTableQuadraticSpace(int size){
        this.hashTable = new ArrayList<T>(size*size);
        this.universalHashing = new UniversalHashing(size*size);
        this.size = size*size;
        this.collisonsCtr = 0;

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
            collisonsCtr++;
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

    public int getCollisons() {
        return collisonsCtr;
    }

    public boolean isEmpty(){
        return this.hashTable.isEmpty();
    }

    public ArrayList<T> getVaules() {
        return hashTable;
    }

}
