

import java.util.List;


import java.util.Collections;
import java.util.Comparator;

public class BTree<T extends Comparable<T>> {
    public BNode<T> root;
    private int order;

    public BTree(int order) {
        this.order = order;
        this.root = new BNode<T>(order);
    }

    public void insertAll(T... key) {
        for (T k : key) {
            insert(k, this.root, false);
        }
    }

    public void insert(T key) {
        insert(key, this.root, false);
    }

    private void insert(T key, BNode<T> node, boolean recursive) {


        if (node.isLeaf() || recursive) {
            if (node.getKeys().size() == order - 1) {
                node.addKey(key);
                split(node);
            } else {
                node.addKey(key);
            }
        } else {
            if (node.getKeys().get(node.getKeys().size() - 1).compareTo(key) < 0) {
                insert(key, node.getChildren().get(node.getChildren().size() - 1), false);
            } else {
                for (T element : node.getKeys()) {
                    if (element.compareTo(key) > 0) {
                        insert(key, node.getChildren().get(node.getKeys().indexOf(element)), false);
                        break;
                    }
                }
            }
        }
    }

    public void split(BNode<T> node) {

        // get the middle key
        int pivot = (order - 1) / 2;
        T pivotKey = node.getKeys().get(pivot);

        // init left and right nodes to split the original node into them
        BNode<T> leftNode = new BNode<>(order);
        BNode<T> rightNode = new BNode<>(order);

        // split the original node into two nodes according to the greater than the
        // middle key and the smaller than the middle key
        for (int i = 0; i < pivot; i++) {
            leftNode.addKey(node.getKeys().get(i));
        }
        for (int i = pivot + 1; i < order; i++) {
            rightNode.addKey(node.getKeys().get(i));
        }
        for (int i = 0; i < (int) ((node.getChildren().size() - 1) / 2.0); i++) {
            leftNode.addChild(node.getChildren().get(i));
        }
        for (int i = (int) ((node.getChildren().size() - 1) / 2.0); i < node.getChildren().size(); i++) {
            rightNode.addChild(node.getChildren().get(i));
        }

        // push the middle key up and modify the pointers
        if (node.getParent() == null) {
            node.getKeys().clear();
            node.addKey(pivotKey);

            node.getChildren().clear();
            node.addChild(leftNode);
            node.addChild(rightNode);

            leftNode.setParent(node);
            rightNode.setParent(node);

            for (BNode<T> child : leftNode.getChildren()) {
                child.setParent(leftNode);
            }
            for (BNode<T> child : rightNode.getChildren()) {

                child.setParent(rightNode);
            }
        } else {
            insert(pivotKey, node.getParent(), true);

            leftNode.setParent(node.getParent());
            rightNode.setParent(node.getParent());

            node.getParent().getChildren().set(findIndex(node.getParent().getKeys(), leftNode.getKeys().get(0)),
                    leftNode);
            node.getParent().getChildren().add(findIndex(node.getParent().getKeys(), rightNode.getKeys().get(0)),
                    rightNode);


            node.setParent(null);
        }

    }

    private int findIndex(List<T> arr, T target) {
        for (int i = 0; i < arr.size(); i++) {
            if (target.compareTo(arr.get(i)) < 0) {

                return i;
            }
        }
        return arr.size();
    }

    public void delete(T key) {
        remove(this.root, key);
    }

    private void remove(BNode<T> node, T key) {
        if (node == null)
            return;

        if(node.getKeys().contains(key)){
            if (node.isLeaf()) {
                if (node.getKeys().contains(key)) {
                    node.getKeys().remove(key);
                }
            }
            else{
                int keyIndex = node.getKeys().indexOf(key);
                T temp = this.getInorderPred(node.getChildren().get(keyIndex));
                node.getKeys().remove(key);
                node.addKey(temp);
                remove(node.getChildren().get(keyIndex), temp);
            }
        }
        else{
            boolean found = false;
            for (int i = 0; i < node.getKeys().size(); i++) {
                if (key.compareTo(node.getKeys().get(i)) < 0) {
                    found = true;
                    remove(node.getChildren().get(i), key);
                    break;
                }
            }
            if (!found) {
                remove(node.getChildren().get(node.getChildren().size() - 1), key);
            }
        }
        if (node.getKeys().size() < ((int) Math.ceil(this.order / 2) - 1)) {
            BNode<T> left = node.leftSibling();
            BNode<T> right = node.rightSibling();
            if (left != null && !left.minimumNumOfkeys())
                takefromLeftSibling(node);
            else if (right != null && !right.minimumNumOfkeys())
                takefromRightSibling(node);
            else if (left != null && left.minimumNumOfkeys())
                mergeLeft(node);
            else if (right != null && right.minimumNumOfkeys())
                mergeRight(node);
            if(node.getParent() == null){
                this.root = node.getChildren().get(0);
            }
        }
    }

    private void mergeLeft(BNode<T> node) {
        BNode<T> left = node.leftSibling();
        BNode<T> parent = node.getParent();
        T keyBetween = node.getIncludedKeyleftSibling();
        parent.getChildren().remove(left);
        parent.getChildren().remove(node);

        parent.getKeys().remove(keyBetween);
        BNode<T> newNode = new BNode<>(order);

        for (int i = 0; i < left.getKeys().size(); i++) {
            newNode.addKey(left.getKeys().get(i));
        }
        newNode.addKey(keyBetween);
        for (int i = 0; i < node.getKeys().size(); i++) {
            newNode.addKey(node.getKeys().get(i));
        }
        for (int i = 0; i < left.getChildren().size(); i++) {
            newNode.addChild(left.getChildren().get(i));
            left.getChildren().get(i).setParent(newNode);
        }
        for (int i = 0; i < node.getChildren().size(); i++) {
            newNode.addChild(node.getChildren().get(i));
            node.getChildren().get(i).setParent(newNode);
        }
        parent.addChild(newNode);
        newNode.setParent(parent);
        this.sortChildren(parent.getChildren());

    }

    private void mergeRight(BNode<T> node) {
        BNode<T> right = node.rightSibling();
        BNode<T> parent = node.getParent();
        T keyBetween = node.getIncludedKeyRightSibling();
        parent.getChildren().remove(right);
        parent.getChildren().remove(node);

        parent.getKeys().remove(keyBetween);
        BNode<T> newNode = new BNode<>(order);

        for (int i = 0; i < node.getKeys().size(); i++) {
            newNode.addKey(node.getKeys().get(i));
        }
        newNode.addKey(keyBetween);
        for (int i = 0; i < right.getKeys().size(); i++) {
            newNode.addKey(right.getKeys().get(i));
        }
        for (int i = 0; i < node.getChildren().size(); i++) {
            newNode.addChild(node.getChildren().get(i));
            node.getChildren().get(i).setParent(newNode);
        }

        for (int i = 0; i < right.getChildren().size(); i++) {
            newNode.addChild(right.getChildren().get(i));
            right.getChildren().get(i).setParent(newNode);

        }

        parent.addChild(newNode);
        newNode.setParent(parent);
        this.sortChildren(parent.getChildren());

    }

    public void takefromLeftSibling(BNode<T> node) {
        BNode<T> parent = node.getParent();
        BNode<T> left = node.leftSibling();
        T maxP, maxSib;
        int sibsize = left.getKeys().size();
        maxSib = left.getKeys().get(sibsize - 1);
        maxP = node.getIncludedKeyleftSibling();
        int keyIndex = left.getKeys().indexOf(maxSib);
        if (!left.isLeaf()) {
            node.addChild(left.getChildren().get(keyIndex));
            left.getChildren().get(keyIndex).setParent(node);
            left.getChildren().remove(keyIndex);
        }
        parent.getKeys().remove(maxP);
        left.getKeys().remove(maxSib);
        parent.addKey(maxSib);
        node.addKey(maxP);
    }

    public void takefromRightSibling(BNode<T> node) {
        BNode<T> parent = node.getParent();
        BNode<T> right = node.rightSibling();
        T minP, minSib;
        minSib = right.getKeys().get(0);
        minP = node.getIncludedKeyRightSibling();
        int keyIndex = right.getKeys().indexOf(minSib);
        if (!right.isLeaf()) {
            node.addChild(right.getChildren().get(keyIndex));
            right.getChildren().get(keyIndex).setParent(node);
            right.getChildren().remove(keyIndex);
        }
        parent.getKeys().remove(minP);
        right.getKeys().remove(minSib);
        parent.addKey(minSib);
        node.addKey(minP);

    }

    private T getInorderPred(BNode<T> node){
        if(node.isLeaf()) return node.getKeys().get(node.getKeys().size() - 1);
        else return getInorderPred(node.getChildren().get(node.getChildren().size() - 1));
    }
    private T getInorderSucc(BNode<T> node){
        if(node.isLeaf()) return node.getKeys().get(0);
        else return getInorderSucc(node.getChildren().get(0));
    }

    public void traverseTree() {
        this.traverse(this.root);
    }

    private void traverse(BNode<T> root) {
        if (root != null) {
            System.out.println(root + " " + root.getChildren().size());
            for (BNode<T> node : root.getChildren()) {
                traverse(node);
            }

        }
    }

    private void sortChildren(List<BNode<T>> children) {
        Comparator<BNode<T>> comparator = new Comparator<BNode<T>>() {
            @Override
            public int compare(BNode<T> o1, BNode<T> o2) {
                return o1.getKeys().get(0).compareTo(o2.getKeys().get(0));
            }
        };
        Collections.sort(children, comparator);

    }

}
