package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;
import java.util.HashMap;

public class Search extends SpotifyClient {

    private ArrayList<String> queryKeywords;
    private ArrayList<String> itemTypes;
    private String market;
    private Integer limit;
    private Integer offset;
    private String include_external;

    public Search(){
        super();
        this.queryKeywords = new ArrayList<>();
        this.itemTypes = new ArrayList<>();
    }

    public HashMap<String,Object> convertQueryParams(){
        HashMap<String,Object> queries = new HashMap<>();
        if(this.itemTypes.size() > 0){
            queries.put("q",String.join(" ",this.queryKeywords));
        }
        if (this.itemTypes.size() > 0) {
            queries.put("type",String.join(",",this.itemTypes));
        }
        if(this.market != null){
            queries.put("market",this.market);
        }
        if(this.limit != null){
            queries.put("limit",this.limit);
        }
        if(this.offset != null){
            queries.put("offset",this.offset);
        }
        if(this.include_external != null){
            queries.put("include_external",this.include_external);
        }
        return queries;
    }

    public void clearQueryParams(){

        this.queryKeywords.clear();
        this.itemTypes.clear();
        this.market = null;
        this.limit = null;
        this.offset = null;
        this.include_external = null;

    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getInclude_external() {
        return include_external;
    }

    public void setInclude_external(String include_external) {
        this.include_external = include_external;
    }

    public ArrayList<String> getQueryKeywords() {
        return queryKeywords;
    }

    public void setQueryKeywords(ArrayList<String> queryKeywords) {
        this.queryKeywords = queryKeywords;
    }

    public ArrayList<String> getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(ArrayList<String> itemTypes) {
        this.itemTypes = itemTypes;
    }
}
