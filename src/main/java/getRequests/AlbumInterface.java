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

public interface AlbumInterface {

    ArrayList<String> albumIds = new ArrayList<>();

    public void addAlbumId(String albumId);

    public ArrayList<String> getAlbumIds();

    public void setAlbumIds(ArrayList<String> albumIds);

}
