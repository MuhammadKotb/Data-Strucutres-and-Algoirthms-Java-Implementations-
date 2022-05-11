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
        for (int i = 0; i < this.size; i++) {
            hashTable.add(null);
        }
    }
    public void insert(T data){
        int hashKey;
        hashKey = universalHashing.hashFunction(data.hashCode());
        if(hashTable.get(hashKey) == null){
            this.hashTable.set(hashKey, data);

        }else{

            ArrayList<T> elements = this.getValues();
            elements.add(data);
            universalHashing.regenerateMatrix();
            this.hashTable.clear();
            for (int i = 0; i < this.size; i++) {
                hashTable.add(null);
            }
            for (T element: elements ) {
                this.insert(element);
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
            this.hashTable.set(hashKey, null);
            return true;
        }else return false;

    }

    public int getCollisons() {
        return collisonsCtr;
    }

    public boolean isEmpty(){
        for (T entry: hashTable) {
            if(entry != null){
                return false;
            }
        }
        return true;
    }

    public ArrayList<T> getValues() {
        ArrayList<T> elements = new ArrayList<>();
        for (T element: hashTable) {
            if(element != null){
                elements.add(element);
            }
        }
        return elements;
    }

}
