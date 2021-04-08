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

    public Album(){
        super();
        this.albumIds = new ArrayList<>();
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
