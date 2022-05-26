
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
                //System.out.println("id: " + id);
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
                    if(btree[0].equals(id))
                        btreesArr.remove(btree);
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

    public List<SearchResult> searchByWordWithRanking(String word){
        List<SearchResult> srArr = new ArrayList<>();
        for(var elem: btreesArr){
            //System.out.println("Inside search");
            BTree btree = (BTree) elem[1];
            String id = (String) elem[0];
            try {
                BNode<String>.Key key = btree.lookUp(word);
                if(key != null && key.getCounter() > 0)
                    srArr.add(new SearchResult(id, key.getCounter()));
            }catch(Exception e){
                System.out.println("Error in lookup");
            }
        }
        return srArr;
    }


    private ISearchResult isPresent(List<ISearchResult> srArr, String id){
        for(ISearchResult elem: srArr){
            if(elem.getId() == id)
                return elem;
        }
        return null;
    }
    public List<ISearchResult> searchByMultipleWordWithRanking(String sentence){
        List<ISearchResult> srArr = new ArrayList<>();
        List<Object[]> btreesArr2 = this.btreesArr;
        String[] words = sentence.split("\\s+");
        for(int i=1; i< words.length; i++){
            String word = words[i];
            for(var elem: btreesArr2){
                String id = (String) elem[0];
                BTree btree = (BTree) elem[1];
                BNode<String>.Key key = btree.lookUp(words[i]);
                if(key == null)
                    btreesArr2.remove(elem);
                else{
                    var searchResult = (SearchResult) isPresent(srArr, id);
                    if(searchResult == null)
                        srArr.add(new SearchResult(id, key.getCounter()));
                    else{
                        searchResult.setRank(Math.min(searchResult.getRank(), key.getCounter()));
                    }
                }
            }
        }
        return srArr;
    }
    static class tmp{
        public String name;
        public int age;

        public tmp(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String args[]){
        SearchEngine se = new SearchEngine();
        se.indexWebPage("Wikipedia Data Sample/wiki_00");
        List<SearchResult> arr = se.searchByWordWithRanking("He");
        for(var elem: arr){
            System.out.println("id: "+elem.getId() +" rank: "+elem.getRank());
        }
    }
}

