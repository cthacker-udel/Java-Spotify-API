package getRequests;

import Client.SpotifyClient;

import java.io.IOException;
import java.util.ArrayList;

public class Artist extends SpotifyClient {

    private ArrayList<String> artists;

    private ArrayList<String> includeGroups;

    private String market;

    private Integer limit;

    private Integer offset;

    public Artist() {
        super();
        this.artists = new ArrayList<>();
        this.includeGroups = new ArrayList<>();
    }

    public String convertIncludeGroups(){
        return String.join(",",this.includeGroups);
    }

    public ArrayList<String> getIncludeGroups() {
        return includeGroups;
    }

    public void setIncludeGroups(ArrayList<String> includeGroups) {
        this.includeGroups = includeGroups;
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

    public void addArtistId(String id){
        this.artists.add(id);
    }

    public ArrayList<String> getArtistsIDs(){
        return this.artists;
    }

    public void setArtistsIds(ArrayList<String> newArtistsIds){
        this.artists = newArtistsIds;
    }

}
