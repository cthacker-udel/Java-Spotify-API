package Client;


import getRequests.*;

import java.io.IOException;

public class SpotifyClient extends SpotifyRestAPI{

    private String secretKey;
    private String apiKey;
    private String token;
    private Album album;
    private Artist artists;
    private String ISOCountryCode;
    private Seed seed;
    private Episode episodes;
    private Follow follow;
    private User userIds;
    private Track trackIds;
    private Show show;
    private Player player;
    private Playlist playlist;
    private Search search;
    private SpotifyLogin login;
    private Category category;
    private Personalization personalization;

    public SpotifyClient(){
        super();
        this.apiKey = "defaultapikey";
        this.secretKey = "defaultsecretkey";
    }

    public SpotifyClient(String apiKey, String secretKey) throws IOException {
        super();
        this.secretKey = secretKey;
        this.apiKey = apiKey;
        implicitGrantTokenRequest();
        this.album = new Album();
        this.artists = new Artist();
        this.seed = new Seed();
        this.episodes = new Episode();
        this.follow = new Follow();
        this.userIds = new User();
        this.trackIds = new Track();
        this.show = new Show();
        this.player = new Player();
        this.playlist = new Playlist();
        this.search = new Search();
        this.login = new SpotifyLogin();
        this.category = new Category();
        this.personalization = new Personalization();
    }

    public SpotifyClient(String apiKey, String secretKey, String token){
        super();
        this.secretKey = secretKey;
        this.apiKey = apiKey;
        this.token = token;
        this.album = new Album();
        this.artists = new Artist();
        this.seed = new Seed();
        this.episodes = new Episode();
        this.follow = new Follow();
        this.userIds = new User();
        this.trackIds = new Track();
        this.show = new Show();
        this.player = new Player();
        this.playlist = new Playlist();
        this.search = new Search();
        this.login = new SpotifyLogin();
        this.category = new Category();
        this.personalization = new Personalization();
    }

    public Personalization getPersonalization() {
        return personalization;
    }

    public void setPersonalization(Personalization personalization) {
        this.personalization = personalization;
    }

    public SpotifyLogin getLogin() {
        return login;
    }

    public void setLogin(SpotifyLogin login) {
        this.login = login;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search items) {
        this.search = items;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public User getUser() {
        return userIds;
    }

    public void setUserIds(User userIds) {
        this.userIds = userIds;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Track getTrackIds() {
        return trackIds;
    }

    public void setTrackIds(Track trackIds) {
        this.trackIds = trackIds;
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

    public Seed getSeed() {
        return seed;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
    }

    public Episode getEpisode() {
        return episodes;
    }

    public void setEpisodes(Episode episodes) {
        this.episodes = episodes;
    }

    public Follow getFollow() {
        return follow;
    }

    public void setFollow(Follow follow) {
        this.follow = follow;
    }
}
