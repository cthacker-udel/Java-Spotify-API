package getRequests;


import Client.SpotifyClient;
import Client.SpotifyRestAPI;
import Controller.AlbumController.MultipleAlbums.BaseAlbum;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Album extends SpotifyClient {

    private ArrayList<String> albumIds;

    private String market;

    private Integer limit;

    private Integer offset;

    public Album(){
        super();
        this.albumIds = new ArrayList<>();
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

    public String convertAlbumIds(){
        return String.join(",",albumIds);
    }

    public void addAlbumId(String albumId){
        albumIds.add(albumId);
    }

    public ArrayList<String> getAlbumIds() {
        return albumIds;
    }

    public void setAlbumIds(ArrayList<String> albumIds) {
        this.albumIds = albumIds;
    }

}
