package Client;


import getRequests.*;

import java.io.IOException;

public class SpotifyClient extends SpotifyRestAPI{

    /*

    Instance attributes

     */

    /**

     private String secretKey - Api interface secret key

     */

    private String secretKey;

    /**

    private String apiKey - Api interface api key

     */

    private String apiKey;

    /**

    private String token - Api interface token

     */

    private String token;

    /**

    private Album album - Api interface Album object

     */

    private Album album;

    /**

    private Artist artists - Api interface Artist Object

     */

    private Artist artists;

    /**

    private String ISOCountryCode - Api interface ISO Country Code (US,EU)

     */

    private String ISOCountryCode;

    /**

    private Seed seed - Api interface Seed object

     */

    private Seed seed;

    /**

    private Episode episodes - Api interface Episode object

     */

    private Episode episodes;

    /**

    private Follow follow - Api interface Follow object

     */

    private Follow follow;

    /**

    private User userIds - Api interface User object

     */

    private User userIds;

    /**

    private Track trackIds - Api interface Track object

     */

    private Track trackIds;

    /**

    private Show show - Api interface Show object

     */

    private Show show;

    /**

    private Player player - Api interface Player object

     */

    private Player player;

    /**

    private Playlist playlist - Api interface Playlist object

     */

    private Playlist playlist;

    /**

    private Search search - Api interface Search object

     */

    private Search search;

    /**

    private SpotifyLogin login - Spotify Login credentials used for logging in and acquiring access token to utilize REST API methods

     */

    private SpotifyLogin login;

    /**

    private Category category - Api interface Category object

     */

    private Category category;

    /**

    private Personalization personalization - Api interface Personalization object

     */

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
