import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.management.ObjectName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class SearchEngine {
    List<Object[]> btreesArr;

    public SearchEngine() {
        this.btreesArr = new ArrayList<>();
    }

    public void indexWebPage(String filePath){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filePath);
            NodeList docList = doc.getElementsByTagName("doc");
            for(int i=0; i<docList.getLength(); i++){
                Node n = docList.item(i);
                Element n1 = (Element) n;
                String id =  n1.getAttribute("id");
                String passage = n.getTextContent();
                String[] words = passage.split("\\s+");
                BTree btree = new BTree(5);
                btree.insertAll(words);
                Object[] arr = new Object[2];
                arr[0] = id;
                arr[1] = btree;
                btreesArr.add(arr);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static void RecursiveVisit(File[] arr, int index, int level, List<File> allFiles)
    {
        // terminate condition
        if (index == arr.length)
            return;

        // tabs for internal levels
        for (int i = 0; i < level; i++)
            System.out.print("\t");

        // for files
        if (arr[index].isFile()){
            allFiles.add(arr[index]);
            System.out.println(arr[index].getName());
        }

            // for sub-directories
        else if (arr[index].isDirectory()) {
            System.out.println("[" + arr[index].getName()
                    + "]");

            // recursion for sub-directories
            RecursiveVisit(arr[index].listFiles(), 0,
                    level + 1, allFiles);
        }

        // recursion for main directory
        RecursiveVisit(arr, ++index, level, allFiles);
    }

    public void indexDirectory(String directoryPath){
        File maindir = new File(directoryPath);
        File arr[] = maindir.listFiles();
        List<File> allFiles = new ArrayList<>();
        RecursiveVisit(arr, 0, 0, allFiles);
        for(var file: allFiles){
            indexWebPage(file.getPath());
        }
    }

    public void deleteWebPage(String filePath){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filePath);
            NodeList docList = doc.getElementsByTagName("doc");
            for(int i=0; i<docList.getLength(); i++){
                Node n = docList.item(i);
                Element n1 = (Element) n;
                String id =  n1.getAttribute("id");
                for(var btree: this.btreesArr){
                    if(btree[0].equals(id)){
                        btreesArr.remove(btree);
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public List<ISearchResult> searchByWordWithRanking(String word){
        List<ISearchResult> srArr = new ArrayList<>();
        for(var elem: btreesArr){
            BTree btree = (BTree) elem[1];
            String id = (String) elem[0];
            int count = btree.traverseandCount(word);
            if(count > 0)
                srArr.add(new SearchResult(id, count));
        }
        return srArr;
    }

    /*public List<ISearchResult> searchByMultipleWordWithRanking(String sentence){
        List<ISearchResult> srArr;
        List<Object[]> btreesArr2 = this.btreesArr;
        String[] words = sentence.split("\\s+");
        for(int i=1; i< words.length; i++){
            String word = words[i];
            for(var elem: btreesArr2){
                String id = (String) elem[0];
                BTree btree = (BTree) elem[1];
                int count = btree.traverseandCount(words[i]);
                if(count > 0){
                    srArr.add(new SearchResult(id, count));
                }else{
                    btreesArr2.remove(elem);
                }
            }
        }
        for()
    }*/
    public static void main(String args[]){/*
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("Wikipedia Data Sample/wiki_00");
            NodeList docList = doc.getElementsByTagName("doc");
            for(int i=0; i<docList.getLength(); i++){
                Node n = docList.item(i);
                String passage = n.getTextContent();
                String[] words = passage.split("\\s+");
                BTree btree = new BTree(5);
                btree.insertAll(words);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }*/
    }
}
