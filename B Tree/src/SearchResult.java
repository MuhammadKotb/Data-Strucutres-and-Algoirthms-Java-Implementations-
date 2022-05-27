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
