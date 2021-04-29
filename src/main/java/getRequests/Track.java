package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;
import java.util.HashMap;

public class Track extends SpotifyClient {

    ArrayList<String> trackIds;

    private String market;

    private Integer limit;

    private Integer offset;

    public Track(){
        super();
        this.trackIds = new ArrayList<>();
    }

    public HashMap<String,Object> convertQueries(){

        HashMap<String,Object> queries = new HashMap<>();
        if(market!= null){
            queries.put("market",this.market);
        }
        if(limit != null){
            queries.put("limit",this.limit);
        }
        if(offset != null){
            queries.put("offset",this.offset);
        }
        if(trackIds.size() > 0){
            queries.put("ids",String.join(",",this.trackIds));
        }
        return queries;
    }

    public void clearQueryParams(){
        this.market = null;
        this.limit = null;
        this.offset = null;
        this.trackIds.clear();
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

    public String convertTrackIds(){
        return String.join(",",this.trackIds);
    }

    public void addTrackId(String trackId){
        trackIds.add(trackId);
    }

    public void clearTrackIds(){
        this.trackIds.clear();
    }


    public ArrayList<String> getTracks() {
        return trackIds;
    }

    public void setTracks(ArrayList<String> tracks) {
        this.trackIds = tracks;
    }
}
