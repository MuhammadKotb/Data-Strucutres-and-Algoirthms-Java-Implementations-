

public class Main
{
    public static void main( String[] args )
    {
        BTree<Integer> bTree = new BTree<>(4);

        //bTree.insertAll(4, 1, 7, 8, 9, 33, 16, 99, 100, 15, 3, 0, 2);
        //bTree.insertAll(3, 0, 2, 1, 10, 12, 18, 20, 21, 25);
        bTree.insertAll(5, 3, 21, 9, 1, 13, 2, 7, 10, 12, 4);
        bTree.insert(80);
        bTree.insert(80);
        bTree.insert(9);
        bTree.insert(9);
        bTree.insert(1);
        bTree.insert(1);
        bTree.insert(80);
        bTree.insert(80);
        bTree.insert(80);
        //bTree.insertAll(13, 192, 123, 53, 439, 879, 55, 19, 369, 218, 445, 974, 312, 563, 818, 1000, 1050, 1473, 1, 2);

      /*  bTree.delete(9);
        bTree.delete(4);
        bTree.delete(12);
        bTree.delete(7);
        bTree.delete(5);

        bTree.delete(5);
        bTree.delete(13);

*/

















        bTree.traverseTree();

    }
}
