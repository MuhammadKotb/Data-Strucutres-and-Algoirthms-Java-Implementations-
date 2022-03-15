

import RB.RBTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Dictionary {
    private int size = 0;
    private RBTree tree;

    public Dictionary() {
        this.tree = new RBTree();
    }


    public void load(String dictionaryPath) throws FileNotFoundException {

        File file = new File(dictionaryPath);
        Scanner converter = new Scanner(file);
        while (converter.hasNextLine()){
            String data = converter.nextLine().toLowerCase();
            this.tree.insert(this.tree.getRoot(), data);
            this.size++;
        }
        converter.close();
    }

    public void printSize(){
        System.out.println("The size of dictionary = " + this.size );
    }

    public void insert(String word){

        this.tree.insert(this.tree.getRoot(), word);
        this.size++;
    }

    public void lookUp(String word)  {
        if( this.tree.contains(word) ){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
    public void delete(String word) {
        if (this.tree.contains(word)) {
            this.tree.delete(this.tree.getRoot(), word);
            this.size--;
        } else {
            System.out.println(word + " wasn't existed in the dictionary to be deleted");
        }
    }
    public void clear(){
        this.tree.clear();
    }
    public void isEmpty(){
        if(this.tree.isEmpty()){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
    public void batchLookUp(String queriesPath ) throws IOException {
        File file = new File(queriesPath);
        Scanner converter = new Scanner(file);
        long count = Files.lines(Path.of(queriesPath)).count();
        System.out.println("The total number of words = "+ count);
        while (converter.hasNextLine()){
            String data = converter.nextLine().toLowerCase();
            System.out.print(data + " " );
            this.lookUp(data);

        }
        converter.close();
    }

    public void batchDeletions(String deletionsPath)throws FileNotFoundException {
        File file = new File(deletionsPath);
        Scanner converter = new Scanner(file);
        while (converter.hasNextLine()){
            String data = converter.nextLine().toLowerCase();
            this.delete(data);
        }
        converter.close();
    }

}

