package Client;

import Controller.AlbumController.MultipleAlbums.BaseAlbum;
import getRequests.AlbumInterface;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import getRequests.Album;

public class SpotifyRestAPI implements AlbumInterface {

    String requestType;

    String baseUrl = "https://api.spotify.com";


    public SpotifyRestAPI(){
        super();
    }

    public SpotifyRestAPI(String requestType) {
        super();
        this.requestType = requestType;
    }

    public String getTokenString(String token){
        return String.format("Bearer %s",token);
    }


    public void makeRequest(String requestType){

        if(requestType.toLowerCase(Locale.ENGLISH).equals("get")){
            // make get request
        }
        else if(requestType.toLowerCase(Locale.ENGLISH).equals("post")){
            // make post request
        }
        else if(requestType.toLowerCase(Locale.ENGLISH).equals("put")){
            // make put request
        }
        else{
            // make delete request
        }

    }

    /*

    Authorization Method <--- generates token that expires

     */

    public String baseAuth(SpotifyClient client) throws IOException {
        String accountsUrl = "https://accounts.spotify.com/api/token/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(accountsUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Model.authorizationInterface authorizationInterface = retrofit.create(Model.authorizationInterface.class);

        Call<Controller.baseAuthResponse> implicitGrantCall = authorizationInterface.implicitGrant(client.getApiKey(),client.getSecretKey(),"client_credentials");

        Response<Controller.baseAuthResponse> implicitGrantResponse = implicitGrantCall.execute();

        client.setToken(implicitGrantResponse.body().getToken());

        return implicitGrantResponse.body().getToken();
    }
    /*

    Add multiple albums method

     */

    public BaseAlbum getMultipleAlbums(SpotifyClient client, Album album) throws IOException {
        String commaSeparatedIds = album.getAlbumIds().stream().collect(Collectors.joining(","));

        String url = "https://api.spotify.com/v1/albums/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Model.albumInterface albumInterface = retrofit.create(Model.albumInterface.class);

        Call<BaseAlbum> call = albumInterface.getMultipleAlbums(client.getToken(),commaSeparatedIds);

        Response<BaseAlbum> response = call.execute();

        return response.body();
    }

    @Override
    public void addAlbumId(String albumId) {
        albumIds.add(albumId);
    }

    @Override
    public ArrayList<String> getAlbumIds() {
        return albumIds;
    }

    @Override
    public void setAlbumIds(ArrayList<String> newAlbumIds) {
        albumIds.clear();
        albumIds.addAll(newAlbumIds);
    }

    public void clearAlbumIds(){
        albumIds.clear();
    }
}
