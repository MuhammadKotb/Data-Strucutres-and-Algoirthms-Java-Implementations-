import java.util.ArrayList;
import java.util.Collections;

public class BTree<T extends Comparable<T>> {
    private BNode<T> root;
    private int order;

    public BTree(int order) {
        this.order = order;
        this.root = new BNode<T>(order);
    }


    public void insert(T key){
        insert(key, this.root, false);
    }

    private void insert(T key, BNode<T> node, boolean recursive) {

        if (node.isLeaf() || recursive) {
            if (node.getKeys().size() == order - 1) {
                node.getKeys().add(key);
                Collections.sort(node.getKeys());
                split(node);
            } else {
                node.getKeys().add(key);
                Collections.sort(node.getKeys());
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

        // split the original node into two nodes according to the greater than the middle key and the smaller than the middle key
        for (int i = 0; i < pivot; i++) {
            leftNode.getKeys().add(node.getKeys().get(i));
        }
        for (int i = pivot + 1; i < order ; i++) {
            rightNode.getKeys().add(node.getKeys().get(i));
        }
        for (int i = 0; i < (int) Math.ceil((node.getChildren().size() - 1) / 2.0); i++) {
            leftNode.getChildren().add(node.getChildren().get(i));
        }
        for (int i = (int) Math.ceil((node.getChildren().size() - 1) / 2.0); i < node.getChildren().size(); i++) {
            rightNode.getChildren().add(node.getChildren().get(i));
        }

        // push the middle key up and modify the pointers
        if (node.getParent() == null) {
            node.getKeys().clear();
            node.getKeys().add(pivotKey);

            node.getChildren().clear();
            node.getChildren().add(leftNode);
            node.getChildren().add(rightNode);

            leftNode.setParent(node);
            rightNode.setParent(node);
        } else {
            insert(pivotKey, node.getParent(), true);
            
            leftNode.setParent(node.getParent());
            rightNode.setParent(node.getParent());

            node.getParent().getChildren().set(findIndex(node.getParent().getKeys(), leftNode.getKeys().get(0)), leftNode);
            node.getParent().getChildren().add(findIndex(node.getParent().getKeys(), rightNode.getKeys().get(0)), rightNode);

            node.setParent(null);
        }

    }

    private int findIndex(ArrayList<T> arr, T target){
        for (int i = 0; i < arr.size(); i++)
        {
            if(target.compareTo(arr.get(i)) < 0)
            {
                return i;
            }
        }
        return arr.size();
    }

}
