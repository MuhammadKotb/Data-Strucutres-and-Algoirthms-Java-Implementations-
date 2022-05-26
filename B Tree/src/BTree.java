import java.util.List;

public class BTree<T extends Comparable<T>> {
    public BNode<T> root;
    private final int order;

    public BTree(int order) {
        this.order = order;
        this.root = new BNode<>(order);
    }

    @SafeVarargs
    public final void insertAll(T... key) {
        for (T k : key) {
            insert(k);
        }
    }

    public void insert(T key) {
        BNode<T>.Key target = lookUp(key);
        if(target != null){
            target.incrCounter();
            return;
        }
        insert(key, this.root);
    }

    private void insert(T key, BNode<T> node) {

        if (node.isLeaf() ) {
            if (node.getKeys().size() == order - 1) {
                node.addKeyOrdered(key);
                split(node);
            } else {
                node.addKeyOrdered(key);
            }
        } else {
            if (node.getKeys().get(node.getKeys().size() - 1).getValue().compareTo(key) < 0) {
                insert(key, node.getChildren().get(node.getChildren().size() - 1));
            } else {
                for (BNode<T>.Key element : node.getKeys()) {
                    if (element.getValue().compareTo(key) > 0) {
                        insert(key, node.getChildren().get(node.getKeys().indexOf(element)));
                        break;
                    }
                }
            }
        }
        if( node.getKeys().size() >= order ){
            split(node);
        }
    }

    public void split(BNode<T> node) {

        // get the middle key
        int pivot = (order - 1) / 2;
        T pivotKey = node.getKeys().get(pivot).getValue();

        // init left and right nodes to split the original node into them
        BNode<T> leftNode = new BNode<>(order);
        BNode<T> rightNode = new BNode<>(order);

        // split the original node into two nodes according to the greater than the
        // middle key and the smaller than the middle key
        for (int i = 0; i < pivot; i++) {
            leftNode.addKeyOrdered(node.getKeys().get(i).getValue());
        }
        for (int i = pivot + 1; i < order; i++) {
            rightNode.addKeyOrdered(node.getKeys().get(i).getValue());
        }
        for (int i = 0; i < (int) Math.ceil((node.getChildren().size() - 1) / 2.0); i++) {
            leftNode.addChildOrdered(node.getChildren().get(i));
        }
        for (int i = (int) Math.ceil((node.getChildren().size() - 1) / 2.0); i < node.getChildren().size(); i++) {
            rightNode.addChildOrdered(node.getChildren().get(i));
        }
        for (BNode<T> child : leftNode.getChildren()) {
            child.setParent(leftNode);
        }
        for (BNode<T> child : rightNode.getChildren()) {
            child.setParent(rightNode);
        }

        // push the middle key up and modify the pointers
        if (node.getParent() == null) {
            node.getKeys().clear();
            node.addKeyOrdered(pivotKey);

            node.getChildren().clear();
            node.addChildOrdered(leftNode);
            node.addChildOrdered(rightNode);

            leftNode.setParent(node);
            rightNode.setParent(node);


        } else {
//            insert(pivotKey, node.getParent(), true);
            node.getParent().addKeyOrdered(pivotKey);

            leftNode.setParent(node.getParent());
            rightNode.setParent(node.getParent());

            node.getParent().getChildren().set(findIndex(node.getParent().getKeys(), leftNode.getKeys().get(0).getValue()),
                    leftNode);
            node.getParent().getChildren().add(findIndex(node.getParent().getKeys(), rightNode.getKeys().get(0).getValue()),
                    rightNode);


            node.setParent(null);
        }

    }

    private int findIndex(List<BNode<T>.Key> arr, T target) {
        for (int i = 0; i < arr.size(); i++) {
            if (target.compareTo(arr.get(i).getValue()) <= 0) {

                return i;
            }
        }
        return arr.size();
    }

    public void delete(T key) {
        BNode<T>.Key target = lookUp(key);
        if(target != null && target.getCounter() > 1){
            target.decrCounter();
            return;
        }
        remove(this.root, key);
    }

    private void remove(BNode<T> node, T key) {
        if (node == null)
            return;



        if (node.getKeys().contains(key)) {
            if (node.isLeaf()) {
                node.getKeys().remove(key);
            } else {
                int keyIndex = node.getKeys().indexOf(key);
                T temp = this.getInorderPred(node.getChildren().get(keyIndex));
                node.getKeys().remove(key);
                node.addKeyOrdered(temp);
                remove(node.getChildren().get(keyIndex), temp);
            }
        } else {
            if(node.isLeaf()) return;
            boolean found = false;
            for (int i = 0; i < node.getKeys().size(); i++) {
                if (key.compareTo(node.getKeys().get(i).getValue()) < 0) {
                    found = true;
                    remove(node.getChildren().get(i), key);
                    break;
                }
            }
            if (!found) {
                remove(node.getChildren().get(node.getChildren().size() - 1), key);
            }
        }
        if (node.getKeys().size() < node.getMinimumKeys()) {
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
            if (node.getParent() == null) {
                this.root = node.getChildren().get(0);
                this.root.setParent(null);
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
            newNode.addKeyOrdered(left.getKeys().get(i).getValue());
        }
        newNode.addKeyOrdered(keyBetween);
        for (int i = 0; i < node.getKeys().size(); i++) {
            newNode.addKeyOrdered(node.getKeys().get(i).getValue());
        }
        for (int i = 0; i < left.getChildren().size(); i++) {
            newNode.addChildOrdered(left.getChildren().get(i));
            left.getChildren().get(i).setParent(newNode);
        }
        for (int i = 0; i < node.getChildren().size(); i++) {
            newNode.addChildOrdered(node.getChildren().get(i));
            node.getChildren().get(i).setParent(newNode);
        }
        parent.addChildOrdered(newNode);
        newNode.setParent(parent);

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
            newNode.addKeyOrdered(node.getKeys().get(i).getValue());
        }
        newNode.addKeyOrdered(keyBetween);
        for (int i = 0; i < right.getKeys().size(); i++) {
            newNode.addKeyOrdered(right.getKeys().get(i).getValue());
        }
        for (int i = 0; i < node.getChildren().size(); i++) {
            newNode.addChildOrdered(node.getChildren().get(i));
            node.getChildren().get(i).setParent(newNode);
        }

        for (int i = 0; i < right.getChildren().size(); i++) {
            newNode.addChildOrdered(right.getChildren().get(i));
            right.getChildren().get(i).setParent(newNode);

        }

        parent.addChildOrdered(newNode);
        newNode.setParent(parent);

    }

    public void takefromLeftSibling(BNode<T> node) {
        BNode<T> parent = node.getParent();
        BNode<T> left = node.leftSibling();
        T maxP, maxSib;
        int sibsize = left.getKeys().size();
        maxSib = left.getKeys().get(sibsize - 1).getValue();
        maxP = node.getIncludedKeyleftSibling();
        int keyIndex = left.getKeys().indexOf(maxSib);
        if (!left.isLeaf()) {
            node.addChildOrdered(left.getChildren().get(keyIndex));
            left.getChildren().get(keyIndex).setParent(node);
            left.getChildren().remove(keyIndex);
        }
        parent.getKeys().remove(maxP);
        left.getKeys().remove(maxSib);
        parent.addKeyOrdered(maxSib);
        node.addKeyOrdered(maxP);

    }

    public void takefromRightSibling(BNode<T> node) {
        BNode<T> parent = node.getParent();
        BNode<T> right = node.rightSibling();
        T minP, minSib;
        minSib = right.getKeys().get(0).getValue();
        minP = node.getIncludedKeyRightSibling();
        int keyIndex = right.getKeys().indexOf(minSib);
        if (!right.isLeaf()) {
            node.addChildOrdered(right.getChildren().get(keyIndex));
            right.getChildren().get(keyIndex).setParent(node);
            right.getChildren().remove(keyIndex);
        }
        parent.getKeys().remove(minP);
        right.getKeys().remove(minSib);
        parent.addKeyOrdered(minSib);
        node.addKeyOrdered(minP);

    }

    private T getInorderPred(BNode<T> node) {
        if (node.isLeaf()) return node.getKeys().get(node.getKeys().size() - 1).getValue();
        else return getInorderPred(node.getChildren().get(node.getChildren().size() - 1));
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

    public int traverseandCount(String word){
       return traverseandCount(this.root, word,0);
    }
    private int traverseandCount(BNode<T> root, String word, int count){
        if (root != null) {
            if(root.equals(word))
                count++;
            for (BNode<T> node : root.getChildren()) {
                count += traverseandCount(node, word, 0);
            }
        }
        return count;
    }

//    public int search(String word){
//        return search(root, word);
//    }

//    private int search(BNode<T> root, String word){
//        if (root != null) {
//            for(T key: root.getKeys()){
//                if(key.equals(word))
//                    return root.keyCount;
//            }
//            for (BNode<T> node : root.getChildren()) {
//                search(node, word);
//            }
//        }
//        return 0;
//    }
    public BNode<T>.Key lookUp(T value){
        return lookUp(this.root, value);
    }
    private BNode<T>.Key lookUp(BNode<T> root,T value){
        BNode<T>.Key target = null;
        if(root != null){
            for (BNode<T>.Key key: root.getKeys() ) {
                if(key.getValue().compareTo(value) == 0){
                    return key;
                }
            }
            for (BNode<T> node : root.getChildren()) {
                target = lookUp(node, value);
                if(target != null){
                    return target;
                }
            }
        }
        return null;
    }



}
