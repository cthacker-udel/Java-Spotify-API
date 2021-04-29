package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;
import java.util.HashMap;

public class Show extends SpotifyClient {

    ArrayList<String> showIds;

    private Integer limit;
    private Integer offset;
    private String market;

    public Show(){
        super();
        this.showIds = new ArrayList<String>();
    }

    public HashMap<String,Object> convertQueries(){

        HashMap<String,Object> queries = new HashMap<>();
        if(limit != null){
            queries.put("limit",this.limit);
        }
        if(offset != null){
            queries.put("offset",this.offset);
        }
        if(market != null){
            queries.put("market",this.market);
        }
        if(showIds.size() > 0){
            queries.put("ids",String.join(",",this.showIds));
        }
        return queries;
    }

    public void clearQueries(){
        this.limit = null;
        this.offset = null;
        this.market = null;
        this.showIds.clear();
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

    public String convertShowIds(){
        return String.join(",",this.showIds);
    }

    public void clearShowIds(){
        this.showIds.clear();
    }

    public void addShowId(String showId){
        this.showIds.add(showId);
    }

    public ArrayList<String> getShowIds() {
        return showIds;
    }

    public void setShowIds(ArrayList<String> showIds) {
        this.showIds = showIds;
    }
}
