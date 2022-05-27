package com.kotb;

public interface IBTree <K extends Comparable<K>, V> {

    public int getMinimumDegree();
    public void insert(K key, V value);
    public V search(K Key);
    public boolean delete(K key);

    


    
}
