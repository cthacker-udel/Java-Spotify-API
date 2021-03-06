package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;
import java.util.HashMap;

public class Episode extends SpotifyClient {

    ArrayList<String> episodes;
    private String market;
    private Integer limit;
    private Integer offset;

    public Episode(){
        super();
        this.episodes = new ArrayList<>();
    }

    public void addEpisode(String episode){
        this.episodes.add(episode);
    }

    public String convertEpisodes(){

        return String.join(",",this.episodes);

    }

    public HashMap<String,Object> convertQueries(){
        HashMap<String,Object> queries = new HashMap<>();
        if(this.episodes != null){
            queries.put("ids",this.convertEpisodes());
        }
        if(this.market != null){
            queries.put("market",this.market);
        }
        return queries;
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

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public ArrayList<String> getEpisodes() {
        return this.episodes;
    }

    public void setEpisodes(ArrayList<String> episodes) {
        this.episodes = episodes;
    }

    public void clearEpisodes(){
        this.episodes.clear();
    }
}
