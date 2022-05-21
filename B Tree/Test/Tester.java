import org.junit.Test;

public class Tester {
    @Test
    public void insertionTest(){


        BTree<Integer> bTree = new BTree<>(4);
        bTree.insertAll(5,3,21,9,1,13,2,7,10,12,4,8);
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
