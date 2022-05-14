import java.util.ArrayList;

public class BNode<T extends Comparable<T>> {

    int order;
    ArrayList<T> keys;
    ArrayList<BNode<T>> children;
    BNode<T> parent;
    public BNode(int order, BNode<T> parent){
        this.order = order;
        this.parent = parent;
        this.keys = new ArrayList<>(order - 1);
        this.children = new ArrayList<>(order);
    }
    public BNode(int order){
        this.order = order;
        this.parent = null;
        this.keys = new ArrayList<>(order);
        this.children = new ArrayList<>(order);
    }

    public void addChild(BNode<T> child){
        this.children.add(child);
    }
    public ArrayList<BNode<T>> getChildren() {
        return children;
    }

    public void addKey(T key){
        this.keys.add(key);
    }

    public ArrayList<T> getKeys() {
        return keys;
    }

    public void setParent(BNode<T> parent) {
        this.parent = parent;
    }

    public BNode<T> getParent() {
        return parent;
    }

    public boolean isLeaf(){
        return this.children.isEmpty();
    }
}
