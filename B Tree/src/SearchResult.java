package com.kotb;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;

public class SearchResult implements ISearchResult{
    private String Id;
    private int rank;

    public SearchResult(String id, int rank) {
        Id = id;
        this.rank = rank;
    }

    public String getId(){
        return Id;
    }
    public void setId(String id){
        this.Id = id;
    }
    /**
     * Return the frequency of the word in the given document.
     * @return
     */
    public int getRank(){
        return rank;
    }
    public void setRank(int rank){
        this.rank = rank;
    }

}
