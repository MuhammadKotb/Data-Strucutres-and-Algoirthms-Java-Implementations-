
import java.util.ArrayList;
import java.util.List;


public class BNode<T extends Comparable<T>> {

    private int order;
    private List<T> keys;
    private List<BNode<T>> children;
    private BNode<T> parent;
    private int minimumKeys;

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

    public int childIndex(){
        for(int i = 0; i < this.getParent().getChildren().size(); i++){
            if(this.getParent().getChildren().get(i).equals(this)) return i;
        }
        return -1;
    }
    public BNode<T> rightSibling(){
        if(this.getParent() == null) return null;
        int childIndex = childIndex();
        BNode<T> parent = this.getParent();
        if(childIndex + 1 >= this.order) return null;
        if(childIndex + 1 >= parent.getChildren().size()) return null;
        return parent.getChildren().get(childIndex + 1);
    }
    public BNode<T> leftSibling(){
        if(this.getParent() == null) return null;
        int childIndex = childIndex();
        BNode<T> parent = this.getParent();
        if(childIndex - 1 < 0) return null;
        return parent.getChildren().get(childIndex - 1);
    }
    public int getMinimumKeys(){
        if(this.parent == null) return 1;
        return this.minimumKeys;
    }
    public boolean minimumNumOfkeys(){
        return (this.getKeys().size() - 1) <  this.getMinimumKeys();
    }
    public T getIncludedKeyleftSibling(){
        int leftIndex = this.leftSibling().childIndex();
        return this.getParent().getKeys().get(leftIndex);
    }
    public T getIncludedKeyRightSibling(){
        return this.getParent().getKeys().get(this.childIndex());
    }

    public void addChild(BNode<T> child) {
        this.children.add(child);
    }

    public List<BNode<T>> getChildren() {
        return children;
    }

    public void addKey(T key) {
        this.keys.add(key);
    }

    public List<T> getKeys() {
        return keys;
    }

    public void setParent(BNode<T> parent) {
        this.parent = parent;
    }

    public BNode<T> getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    @Override
    public String toString(){
        return this.keys.toString();
    }
}