package Client;


import Controller.AlbumController.MultipleAlbums.BaseAlbum;
import getRequests.Album;
import getRequests.Artist;

import java.io.IOException;
import java.util.List;

public class SpotifyClient extends SpotifyRestAPI{

    private String secretKey;
    private String apiKey;
    private String token;
    private Album album;
    private Artist artists;
    private String ISOCountryCode;

    public SpotifyClient(){
        super();
        this.secretKey = "defaultSecretKey";
        this.apiKey = "defaultApiKey";
    }

    public SpotifyClient(String apiKey, String secretKey) throws IOException {
        super();
        this.secretKey = secretKey;
        this.apiKey = apiKey;
        implicitGrantTokenRequest();
        this.album = new Album();
        this.artists = new Artist();
    }

    public SpotifyClient(String apiKey, String secretKey, String token){
        super();
        this.secretKey = secretKey;
        this.apiKey = apiKey;
        this.token = token;
        this.album = new Album();
        this.artists = new Artist();
    }

    public String getISOCountryCode() {
        return ISOCountryCode;
    }

    public void setISOCountryCode(String ISOCountryCode) {
        this.ISOCountryCode = ISOCountryCode;
    }

    public Artist getArtists() {
        return artists;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setArtists(Artist artists) {
        this.artists = artists;
    }

    public void clearAlbums(){
        this.album.getAlbumIds().clear();
    }

    public void clearArtists(){
        this.artists.getArtistsIDs().clear();
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

    public void implicitGrantTokenRequest() throws IOException {
        String theToken = super.baseAuth(this);
        this.setToken(theToken);
    }

    public BaseAlbum getMultipleAlbums(Album album) throws IOException {
        return super.getMultipleAlbums(this,album);
    }

}
