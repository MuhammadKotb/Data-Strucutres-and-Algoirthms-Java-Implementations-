

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main( String[] args )
    {
        IBTree<Integer, Object> btree = new BTree<>(4);

        btree.insert(5, "LOL");
        btree.insert(2, "LOl2");
        btree.insert(21, new ArrayList<>(Arrays.asList(2, 3, 6, 110)));
        btree.insert(9, "HA5A");
        btree.insert(1, "DEFO");
        btree.insert(13, 1.566);
        btree.insert(77, "AHMED");



        btree.delete(77);
        System.out.println("=======================================================");
        btree.delete(9);
        System.out.println("=======================================================");
        btree.delete(5);        




        











    }
}
