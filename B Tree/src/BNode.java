import java.util.ArrayList;
import java.util.List;


public class BNode<T extends Comparable<T>> {
    class Key{
        private final T value;

        private  int counter;

        public Key(T value){
            this.value = value;
            this.counter = 0;
        }
        public int getCounter() {
            return counter;
        }

        public T getValue() {
            return value;
        }

        public void incrCounter(){
            this.counter++;
        }

        public void decrCounter(){
            this.counter--;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
    }

    private final int order;
    private final List<Key> keys;
    private final List<BNode<T>> children;
    private BNode<T> parent;
    private final int minimumKeys;

    public BNode(int order, BNode<T> parent) {
        this.order = order;
        this.parent = parent;
        this.minimumKeys = ((order + 1) / 2) - 1;
        this.keys = new ArrayList<>(order - 1);
        this.children = new ArrayList<>(order);
    }

    public BNode(int order) {
        this.order = order;
        this.minimumKeys = ((order + 1) / 2) - 1;
        this.parent = null;
        this.keys = new ArrayList<>(order);
        this.children = new ArrayList<>(order);
    }

    public int childIndex() {
        for (int i = 0; i < this.getParent().getChildren().size(); i++) {
            if (this.getParent().getChildren().get(i).equals(this)) return i;
        }
        return -1;
    }

    public BNode<T> rightSibling() {
        if (this.getParent() == null) return null;
        int childIndex = childIndex();
        BNode<T> parent = this.getParent();
        if (childIndex + 1 >= this.order) return null;
        if (childIndex + 1 >= parent.getChildren().size()) return null;
        return parent.getChildren().get(childIndex + 1);
    }

    public BNode<T> leftSibling() {
        if (this.getParent() == null) return null;
        int childIndex = childIndex();
        BNode<T> parent = this.getParent();
        if (childIndex - 1 < 0) return null;
        return parent.getChildren().get(childIndex - 1);
    }

    public int getMinimumKeys() {
        if (this.parent == null) return 1;
        return this.minimumKeys;
    }

    public boolean minimumNumOfkeys() {
        return (this.getKeys().size() - 1) < this.getMinimumKeys();
    }

    public T getIncludedKeyleftSibling() {
        int leftIndex = this.leftSibling().childIndex();
        return this.getParent().getKeys().get(leftIndex).getValue();
    }

    public T getIncludedKeyRightSibling() {
        return this.getParent().getKeys().get(this.childIndex()).getValue();
    }

    public void addChildOrdered(BNode<T> child) {
        for (int i = 0; i < this.children.size(); i++) {
            if (this.children.get(i).getKeys().get(0).getValue().compareTo(child.getKeys().get(0).getValue()) > 0) {
                this.children.add(i, child);
                return;
            }
        }
        this.children.add(child);
    }

    public List<BNode<T>> getChildren() {
        return children;
    }

    public void addKeyOrdered(T keyValue) {
        for (int i = 0; i < this.keys.size(); i++) {
            if (this.keys.get(i).getValue().compareTo(keyValue) > 0) {
                this.keys.add(i, new Key(keyValue));
                return;
            }
        }
        this.keys.add(new Key(keyValue));
    }

    public List<Key> getKeys() {
        return keys;
    }

    public BNode<T> getParent() {
        return parent;
    }

    public void setParent(BNode<T> parent) {
        this.parent = parent;
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    @Override
    public String toString() {
        return this.keys.toString();
    }
}