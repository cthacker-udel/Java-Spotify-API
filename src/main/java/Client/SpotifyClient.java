package Client;


import Controller.AlbumController.MultipleAlbums.BaseAlbum;
import getRequests.Album;

import java.io.IOException;
import java.util.List;

public class SpotifyClient extends SpotifyRestAPI{

    private String secretKey;
    private String apiKey;
    private String token;
    private Album album;

    public SpotifyClient(){
        super();
        this.secretKey = "defaultSecretKey";
        this.apiKey = "defaultApiKey";
    }

    public SpotifyClient(String apiKey, String secretKey){
        super();
        this.secretKey = secretKey;
        this.apiKey = apiKey;
    }

    public SpotifyClient(String apiKey, String secretKey, String token, Album album){
        super();
        this.secretKey = secretKey;
        this.apiKey = apiKey;
        this.token  = token;
        this.album = album;
    }

    public SpotifyClient(String apiKey, String secretKey, String token){
        super();
        this.secretKey = secretKey;
        this.apiKey = apiKey;
        this.token = token;
    }

    public Album getAlbum() {
        return album;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return this.token;
    }

    public String implicitGrantTokenRequest() throws IOException {
        String theToken = super.baseAuth(this);
        this.setToken(theToken);
        return theToken;
    }

    public BaseAlbum getMultipleAlbums(Album album) throws IOException {
        return super.getMultipleAlbums(this,album);
    }

}
