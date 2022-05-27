package com.kotb;


import java.util.List;

import com.kotb.BNode.Key;

public class BTree<K extends Comparable<K>, V> implements IBTree<K, V> {

    public BNode<K, V> root;
    private final int order;

    public BTree(int order) {
        this.order = order;
        this.root = new BNode<>(order);
    }

    

    @Override
    public void insert(K key, V value) {
        BNode<K, V>.Key target = lookUp(key);
        if(target != null){
            target.incrCounter();
            return;
        }
        insert(key, this.root, value);
    }

    private void insert(K key, BNode<K, V> node, V value) {

        if (node.isLeaf() ) {
            if (node.getListOfKeys().size() == order - 1) {
                node.addKeyOrderedPair(key, value);
                split(node);
            } else {
                node.addKeyOrderedPair(key, value);
            }
        } else {
            if (node.getListOfKeys().get(node.getListOfKeys().size() - 1).getKeyValue().compareTo(key) < 0) {
                insert(key, node.getChildrenNodes().get(node.getChildrenNodes().size() - 1), value);
            } else {
                for (BNode<K, V>.Key element : node.getListOfKeys()) {
                    if (element.getKeyValue().compareTo(key) > 0) {
                        insert(key, node.getChildrenNodes().get(node.getListOfKeys().indexOf(element)), value);
                        break;
                    }
                }
            }
        }
        if( node.getListOfKeys().size() >= order ){
            split(node);
        }
    }

    public void split(BNode<K, V> node) {

        // get the middle key
        int pivot = (order - 1) / 2;
        BNode<K, V>.Key pivotKey = node.getListOfKeys().get(pivot);

        // init left and right nodes to split the original node into them
        BNode<K, V> leftNode = new BNode<>(order);
        BNode<K, V> rightNode = new BNode<>(order);

        // split the original node into two nodes according to the greater than the
        // middle key and the smaller than the middle key
        for (int i = 0; i < pivot; i++) {
            leftNode.addKeyOrdered(node.getListOfKeys().get(i));
        }
        for (int i = pivot + 1; i < order; i++) {
            rightNode.addKeyOrdered(node.getListOfKeys().get(i));
        }
        for (int i = 0; i < (int) Math.ceil((node.getChildrenNodes().size() - 1) / 2.0); i++) {
            leftNode.addChildOrdered(node.getChildrenNodes().get(i));
        }
        for (int i = (int) Math.ceil((node.getChildrenNodes().size() - 1) / 2.0); i < node.getChildrenNodes().size(); i++) {
            rightNode.addChildOrdered(node.getChildrenNodes().get(i));
        }
        for (BNode<K, V> child : leftNode.getChildrenNodes()) {
            child.setParent(leftNode);
        }
        for (BNode<K, V> child : rightNode.getChildrenNodes()) {
            child.setParent(rightNode);
        }

        // push the middle key up and modify the pointers
        if (node.getParent() == null) {
            node.getListOfKeys().clear();
            node.addKeyOrdered(pivotKey);

            node.getChildrenNodes().clear();
            node.addChildOrdered(leftNode);
            node.addChildOrdered(rightNode);

            leftNode.setParent(node);
            rightNode.setParent(node);


        } else {
//            insert(pivotKey, node.getParent(), true);
            node.getParent().addKeyOrdered(pivotKey);

            leftNode.setParent(node.getParent());
            rightNode.setParent(node.getParent());

            node.getParent().getChildrenNodes().set(findIndex(node.getParent().getListOfKeys(), leftNode.getListOfKeys().get(0).getKeyValue()),
                    leftNode);
            node.getParent().getChildrenNodes().add(findIndex(node.getParent().getListOfKeys(), rightNode.getListOfKeys().get(0).getKeyValue()),
                    rightNode);


            node.setParent(null);
        }

    }

    private int findIndex(List<BNode<K, V>.Key> arr, K target) {
        for (int i = 0; i < arr.size(); i++) {
            if (target.compareTo(arr.get(i).getKeyValue()) <= 0) {
                return i;
            }
        }
        return arr.size();
    }

    
    @Override
    public boolean delete(K key) {
        boolean ret = remove(this.root, key);
        this.traverse(root);
        return ret;
    }

    private boolean remove(BNode<K, V> node, K key) {
        boolean removed = false;
        if (node == null)
            return false;
        BNode<K, V>.Key target = lookUp(key);
        if(target != null && target.getCounter() > 1){
            target.decrCounter();
            removed = true;
        }
        if (node.getKeyValues().contains(key)) {
            if (node.isLeaf()) {
                node.removeKeyFromNode(key);
                removed = true;
            } else {
                int keyIndex = node.getKeyValueIndex(key);
                BNode<K, V>.Key temp = this.getInorderPred(node.getChildrenNodes().get(keyIndex));
                node.removeKeyFromNode(key);
                node.addKeyOrdered(temp);
                removed = remove(node.getChildrenNodes().get(keyIndex), temp.getKeyValue());
            }
        } else {
            if(node.isLeaf()) return false;
            boolean found = false;
            for (int i = 0; i < node.getListOfKeys().size(); i++) {
                if (key.compareTo(node.getListOfKeys().get(i).getKeyValue()) < 0) {
                    found = true;
                    removed = remove(node.getChildrenNodes().get(i), key);
                    break;
                }
            }
            if (!found) {
                removed = remove(node.getChildrenNodes().get(node.getChildrenNodes().size() - 1), key);
            }
        }
        if (node.getListOfKeys().size() < node.getMinimumKeys()) {
            BNode<K, V> left = node.leftSibling();
            BNode<K, V> right = node.rightSibling();
            if (left != null && !left.minimumNumOfkeys())
                takefromLeftSibling(node);
            else if (right != null && !right.minimumNumOfkeys())
                takefromRightSibling(node);
            else if (left != null && left.minimumNumOfkeys())
                mergeLeft(node);
            else if (right != null && right.minimumNumOfkeys())
                mergeRight(node);
            if (node.getParent() == null) {
                this.root = node.getChildrenNodes().get(0);
                this.root.setParent(null);
            }
        }
        return removed;
    }

    private void mergeLeft(BNode<K, V> node) {
        BNode<K, V> left = node.leftSibling();
        BNode<K, V> parent = node.getParent();
        BNode<K, V>.Key keyBetween = node.getIncludedKeyleftSibling();
        parent.getChildrenNodes().remove(left);
        parent.getChildrenNodes().remove(node);

        parent.getListOfKeys().remove(keyBetween);
        BNode<K, V> newNode = new BNode<>(order);

        for (int i = 0; i < left.getListOfKeys().size(); i++) {
            newNode.addKeyOrdered(left.getListOfKeys().get(i));
        }
        newNode.addKeyOrdered(keyBetween);
        for (int i = 0; i < node.getListOfKeys().size(); i++) {
            newNode.addKeyOrdered(node.getListOfKeys().get(i));
        }
        for (int i = 0; i < left.getChildrenNodes().size(); i++) {
            newNode.addChildOrdered(left.getChildrenNodes().get(i));
            left.getChildrenNodes().get(i).setParent(newNode);
        }
        for (int i = 0; i < node.getChildrenNodes().size(); i++) {
            newNode.addChildOrdered(node.getChildrenNodes().get(i));
            node.getChildrenNodes().get(i).setParent(newNode);
        }
        parent.addChildOrdered(newNode);
        newNode.setParent(parent);

    }

    private void mergeRight(BNode<K, V> node) {
        BNode<K, V> right = node.rightSibling();
        BNode<K, V> parent = node.getParent();
        BNode<K, V>.Key keyBetween = node.getIncludedKeyRightSibling();
        parent.getChildrenNodes().remove(right);
        parent.getChildrenNodes().remove(node);

        parent.getListOfKeys().remove(keyBetween);
        BNode<K, V> newNode = new BNode<>(order);

        for (int i = 0; i < node.getListOfKeys().size(); i++) {
            newNode.addKeyOrdered(node.getListOfKeys().get(i));
        }
        newNode.addKeyOrdered(keyBetween);
        for (int i = 0; i < right.getListOfKeys().size(); i++) {
            newNode.addKeyOrdered(right.getListOfKeys().get(i));
        }
        for (int i = 0; i < node.getChildrenNodes().size(); i++) {
            newNode.addChildOrdered(node.getChildrenNodes().get(i));
            node.getChildrenNodes().get(i).setParent(newNode);
        }

        for (int i = 0; i < right.getChildrenNodes().size(); i++) {
            newNode.addChildOrdered(right.getChildrenNodes().get(i));
            right.getChildrenNodes().get(i).setParent(newNode);

        }

        parent.addChildOrdered(newNode);
        newNode.setParent(parent);

    }

    private void takefromLeftSibling(BNode<K, V> node) {
        BNode<K, V> parent = node.getParent();
        BNode<K, V> left = node.leftSibling();
        BNode<K, V>.Key maxP, maxSib;
        int sibsize = left.getListOfKeys().size();
        maxSib = left.getListOfKeys().get(sibsize - 1);
        maxP = node.getIncludedKeyleftSibling();
        int keyIndex = left.getListOfKeys().indexOf(maxSib);
        if (!left.isLeaf()) {
            node.addChildOrdered(left.getChildrenNodes().get(keyIndex));
            left.getChildrenNodes().get(keyIndex).setParent(node);
            left.getChildrenNodes().remove(keyIndex);
        }
        parent.getListOfKeys().remove(maxP);
        left.getListOfKeys().remove(maxSib);
        parent.addKeyOrdered(maxSib);
        node.addKeyOrdered(maxP);

    }

    private void takefromRightSibling(BNode<K, V> node) {
        BNode<K, V> parent = node.getParent();
        BNode<K, V> right = node.rightSibling();
        BNode<K, V>.Key minP, minSib;
        minSib = right.getListOfKeys().get(0);
        minP = node.getIncludedKeyRightSibling();
        int keyIndex = right.getListOfKeys().indexOf(minSib);
        if (!right.isLeaf()) {
            node.addChildOrdered(right.getChildrenNodes().get(keyIndex));
            right.getChildrenNodes().get(keyIndex).setParent(node);
            right.getChildrenNodes().remove(keyIndex);
        }
        parent.getListOfKeys().remove(minP);
        right.getListOfKeys().remove(minSib);
        parent.addKeyOrdered(minSib);
        node.addKeyOrdered(minP);

    }

    private BNode<K, V>.Key getInorderPred(BNode<K, V> node) {
        if (node.isLeaf()) return node.getListOfKeys().get(node.getListOfKeys().size() - 1);
        else return getInorderPred(node.getChildrenNodes().get(node.getChildrenNodes().size() - 1));
    }

    public void traverseTree() {
        this.traverse(this.root);
    }

    private void traverse(BNode<K, V> root) {
        if (root != null) {
            System.out.println(root + " " + root.getChildrenNodes().size());
            for (BNode<K, V> node : root.getChildrenNodes()) {
                traverse(node);
            }

        }
    }


    public BNode<K, V>.Key lookUp(K key){
        return lookUp(this.root, key);
    }
    private BNode<K, V>.Key lookUp(BNode<K, V> root, K key){
        BNode<K, V>.Key target = null;
        if(root != null){
            List<BNode<K, V>.Key> keys = root.getListOfKeys();
            for (BNode<K, V>.Key keytemp : keys) {
                if(keytemp.getKeyValue().compareTo(key) == 0){
                    return keytemp;
                }
            }
            if (! root.isLeaf() && keys.get(keys.size() - 1).getKeyValue().compareTo(key) < 0) {
                target = lookUp(root.getChildrenNodes().get(root.getChildrenNodes().size() - 1), key);
                return target;
            } else if(! root.isLeaf()) {
                for (BNode<K, V>.Key element : keys) {
                    if (element.getKeyValue().compareTo(key) > 0) {
                        target = lookUp(root.getChildrenNodes().get(keys.indexOf(element)), key);
                        return target;

                    }
                }
            }
        }
        return null;
    }

    @Override
    public int getMinimumDegree() {
        return ((order + 1) / 2);
    }

    @Override
    public V search(K key) {
        BNode<K, V>.Key keyTemp = this.lookUp(key);
        return keyTemp.getValue();
    }



}
