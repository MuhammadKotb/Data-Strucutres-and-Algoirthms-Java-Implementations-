package com.kotb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.validation.ValidatorHandler;


public class BNode<K extends Comparable<K>, V> implements IBTreeNode<K, V> {


    public class Key  {
        private final V value;
        private K key;

        private  int counter;

        
        public Key(K key, V value){
            this.key = key;
            this.value = value;
            this.counter = 1;
        }
        public K getKeyValue(){
            return this.key;
        }
        public int getCounter() {
            return counter;
        }

        public V getValue() {
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
            return " Key: " + this.getKeyValue().toString() + ", Value :  "  + this.getValue() + ", Count: " + this.counter;
        }
        @Override
        public boolean equals(Object key){
            if(key == null) return false;
            if(key.getClass() != this.getClass()) return false;
            Key keyTemp = (Key)key;;
            K keyValue = keyTemp.getKeyValue();
            return this.key.equals(keyValue);
            
        }
        @Override
        public int hashCode(){
            return this.value.hashCode();
        }

    }

    private int order;
    private List<Key> keys;
    private List<BNode<K, V>> children;
    private BNode<K, V> parent;
    private final int minimumKeys;
    private boolean isLeaf;

    public BNode(int order, BNode<K, V> parent) {
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
        for (int i = 0; i < this.getParent().getChildrenNodes().size(); i++) {
            if (this.getParent().getChildrenNodes().get(i).equals(this)) return i;
        }
        return -1;
    }

    public BNode<K, V> rightSibling() {
        if (this.getParent() == null) return null;
        int childIndex = childIndex();
        BNode<K, V> parent = this.getParent();
        if (childIndex + 1 >= this.order) return null;
        if (childIndex + 1 >= parent.getChildrenNodes().size()) return null;
        return parent.getChildrenNodes().get(childIndex + 1);
    }

    public BNode<K, V> leftSibling() {
        if (this.getParent() == null) return null;
        int childIndex = childIndex();
        BNode<K, V> parent = this.getParent();
        if (childIndex - 1 < 0) return null;
        return parent.getChildrenNodes().get(childIndex - 1);
    }

    public int getMinimumKeys() {
        if (this.parent == null) return 1;
        return this.minimumKeys;
    }

    public boolean minimumNumOfkeys() {
        return (this.getListOfKeys().size() - 1) < this.getMinimumKeys();
    }

    public Key getIncludedKeyleftSibling() {
        int leftIndex = this.leftSibling().childIndex();
        return this.getParent().getListOfKeys().get(leftIndex);
    }

    public Key getIncludedKeyRightSibling() {
        return this.getParent().getListOfKeys().get(this.childIndex());
    }

    public void addChildOrdered(BNode<K, V> child) {
        for (int i = 0; i < this.children.size(); i++) {
            if (this.children.get(i).getListOfKeys().get(0).getKeyValue().compareTo(child.getListOfKeys().get(0).getKeyValue()) > 0) {
                this.children.add(i, child);
                return;
            }
        }
        this.children.add(child);
    }

    public List<BNode<K, V>> getChildrenNodes() {
        return children;
    }

    public void addKeyOrderedPair(K keyValue, V value) {
        for (int i = 0; i < this.keys.size(); i++) {
            if (this.keys.get(i).getKeyValue().compareTo(keyValue) > 0) {
                this.keys.add(i, new Key(keyValue, value));
                return;
            }
        }
        this.keys.add(new Key(keyValue, value));
    }

    public void addKeyOrdered(Key key) {
        for (int i = 0; i < this.keys.size(); i++) {
            if (this.keys.get(i).getKeyValue().compareTo(key.getKeyValue()) > 0) {
                this.keys.add(i, key);
                return;
            }
        }
        this.keys.add(key);
    }
    public List<K> getKeyValues(){
        return this.keys.stream().map(k -> k.getKeyValue()).toList();
    }
    public int getKeyValueIndex(K key){
        return this.keys.stream().map(k -> k.getKeyValue()).toList().indexOf(key);
    }
    public void removeKeyFromNode(K key){
        for(BNode<K, V>.Key k : this.getListOfKeys()){
            if(key.equals(k.getKeyValue())){ this.getListOfKeys().remove(k); break;};
            
        }
    }

    public List<Key> getListOfKeys() {
        return keys;
    }

    public BNode<K, V> getParent() {
        return parent;
    }

    public void setParent(BNode<K, V> parent) {
        this.parent = parent;
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    @Override
    public String toString() {
        return this.keys.toString();
    }

    @Override
    public int getNumOfKeys() {
        return this.keys.size();
    }

    @Override
    public void setNumOfKeys() {
        
        
    }

    @Override
    public void setLeaft(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    @Override
    public List<K> getKeys() {
        return this.getKeyValues();
    }

    @Override
    public void setKeys(List<K> keys) {
        this.keys = new ArrayList<>();
        for(K k : keys){
            this.keys.add(new Key(k, null));
        }
    }

    @Override
    public List<V> getValues() {
        return this.keys.stream().map(k -> k.getValue()).toList();
    }

    @Override
    public void setValues(List<V> values) {
        for(V v : values){

        }        
    }

    @Override
    public List<IBTreeNode<K, V>> getChildren() {

        return null;
    }

    @Override
    public void setChildren(List<IBTreeNode<K, V>> children) {
        
        
    }
}