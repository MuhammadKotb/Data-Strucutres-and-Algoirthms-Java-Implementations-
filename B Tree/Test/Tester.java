import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Tester {
    @Test
    public void insertionTest(){


        BTree<Integer, Object> bTree = new BTree<>(4);
        bTree.insert(9, "LOL");
        bTree.insert(4, "LOl2");
        bTree.insert(12, new ArrayList<>(Arrays.asList(2, 3, 6, 110)));
        bTree.insert(4, "HA5A");
        bTree.insert(7, "DEFO");
        bTree.insert(5, 1.566);
        bTree.insert(13, "AHMED");
        bTree.traverseTree();
        System.out.println("=====================");
        bTree.delete(9);
        bTree.traverseTree();
        System.out.println("=====================");
        bTree.delete(4);
        bTree.traverseTree();
        System.out.println("=====================");
        bTree.delete(12);
        bTree.traverseTree();
        System.out.println("=====================");
        bTree.delete(7);
        bTree.traverseTree();
        System.out.println("=====================");
        bTree.delete(5);
        bTree.traverseTree();
        System.out.println("=====================");
        bTree.delete(5);
        bTree.traverseTree();
        System.out.println("=====================");
        bTree.delete(13);
        bTree.traverseTree();
    }
}
