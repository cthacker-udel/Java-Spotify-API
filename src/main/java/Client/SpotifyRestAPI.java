package Client;

import Controller.AlbumController.MultipleAlbums.BaseAlbum;
import Controller.AlbumController.MultipleAlbums.Tracks;
import Controller.ArtistController.Artist;
import Controller.ArtistController.ArtistAlbum;
import Controller.ArtistController.ArtistTopTrack;
import Controller.ArtistController.BaseArtist;
import Controller.BrowseController.Categories.BaseCategory;
import Controller.BrowseController.Categories.Category;
import Controller.BrowseController.Playlist.BasePlaylist;
import Controller.BrowseController.Recommendations.BaseRecommendation;
import Controller.BrowseController.Recommendations.RecommendationGenreList;
import Controller.EpisodeController.BaseEpisode;
import Controller.ItemController.BaseItem;
import Controller.LibraryController.BaseTrack;
import Controller.LibraryController.Show.BaseShow;
import Controller.MarketController.Market;
import Controller.PersonalizationController.baseUserTopTracksAndArtists;
import Controller.PlayerController.CurrentTrack.baseCurrentTrack;
import Controller.PlayerController.Devices.basePlayerDevice;
import Controller.PlayerController.baseUserPlayback;
import Controller.PlaylistController.CoverImage;
import Controller.PlaylistController.Playlist;
import Controller.PlaylistController.PlaylistItems.BasePlaylistItems;
import Controller.PlaylistController.SnapshotId;
import Controller.ShowController.MultipleShows.Show;
import Controller.TrackController.AudioAnalysis.BaseAudioAnalysis;
import Controller.TrackController.AudioFeatures.AudioFeature;
import Controller.TrackController.AudioFeatures.BaseAudioFeature;
import Controller.TrackController.MultipleTracks.Track;
import Controller.UserProfileController.CurrUser.BaseProfile;
import Controller.baseAccessTokenResponse;
import Controller.baseRefreshTokenResponse;
import Model.*;


import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;
import getRequests.Album;

import static java.lang.Thread.sleep;


/*

    Spotify Rest API Class
    Implements all Spotify Rest API Methods


 */


public class SpotifyRestAPI {

    String requestType;

    String baseUrl = "https://api.spotify.com";


    public SpotifyRestAPI(){
        super();
    }

    public SpotifyRestAPI(String requestType) {
        super();
        this.requestType = requestType;
    }

    public String getContentType(){

        return "application/json";

    }

    public String getTokenString(String token){
        return String.format(" Bearer %s",token);
    }

    public String getRefreshTokenString(String clientId, String clientSecret){
        byte[] clientIdEncoded = Base64.getEncoder().encode(clientId.getBytes(StandardCharsets.UTF_8));
        byte[] clientSecretEncoded = Base64.getEncoder().encode(clientSecret.getBytes(StandardCharsets.UTF_8));
        return String.format(" Basic %s:%s",new String(clientIdEncoded,StandardCharsets.UTF_8),new String(clientSecretEncoded,StandardCharsets.UTF_8));
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

    Authorization Method - Access User Profile - Generate Access Token Code to generate Refresh Token and AccessToken

     */


    public String requestAuthCodeFlowCode(SpotifyClient client) throws IOException, InterruptedException {

        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://accounts.spotify.com/authorize").newBuilder();

        urlBuilder.addQueryParameter("client_id",client.getApiKey());
        urlBuilder.addQueryParameter("response_type","code");
        urlBuilder.addQueryParameter("redirect_uri",client.getLogin().getRedirectUri());
        urlBuilder.addQueryParameter("scope",client.getLogin().convertScopes());

        WebDriverManager.chromedriver().setup();
        WebDriver browser = null;
        try {
            browser = new ChromeDriver();
        }
        catch(Exception ignored){
            try{
                WebDriverManager.firefoxdriver().setup();
                browser = new FirefoxDriver();
            }
            catch(Exception ignored1){
                try{
                    WebDriverManager.edgedriver().setup();
                    browser = new EdgeDriver();
                }
                catch(Exception ignored2){
                    try{
                        WebDriverManager.iedriver().setup();
                        browser = new InternetExplorerDriver();
                    }
                    catch(Exception ignored3){
                        try{
                            WebDriverManager.operadriver().setup();
                            browser = new OperaDriver();
                        }
                        catch(Exception ignored4){
                            try{
                                browser = new SafariDriver();
                            }
                            catch(Exception ignored5){

                            }
                        }
                    }
                }
            }
        }

        CharSequence email = client.getLogin().getEmailOrUsername();
        CharSequence password = client.getLogin().getPassword();

        browser.get(URLDecoder.decode(urlBuilder.build().url().toString(),StandardCharsets.UTF_8));
        browser.findElement(By.id("login-username")).sendKeys(email);
        browser.findElement(By.id("login-password")).sendKeys(password);
        browser.findElement(By.id("login-button")).click();
        sleep(10000);
        try {
            WebElement authAccept = browser.findElement(By.id("auth-accept"));
            if (authAccept != null) {
                authAccept.click();
            }
        }
        catch(Exception ignored){

        }

        sleep(1);
        while(!browser.getCurrentUrl().contains("code=")){
            continue;
        }

        String newUrl = browser.getCurrentUrl();
        String code = newUrl.split("code=")[1];

        client.getLogin().setAuthCode(code);

        return code;
    }

    /*


    Authorization - Generate Access Token And Refresh Token


     */


    public baseAccessTokenResponse generateAccessTokenAndRefreshToken(SpotifyClient client) throws IOException {

        String url = "https://accounts.spotify.com/api/token/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        authorizationInterface authorizationInterface = retrofit.create(Model.authorizationInterface.class);

        Call<baseAccessTokenResponse> call = authorizationInterface.getAccessTokenAndRefreshToken("authorization_code",client.getLogin().getAuthCode(),client.getLogin().getRedirectUri(),client.getApiKey(),client.getSecretKey());

        Response<baseAccessTokenResponse> response = call.execute();

        client.getLogin().setAccessToken(response.body().getAccessToken());

        client.getLogin().setRefreshToken(response.body().getRefreshToken());

        return response.body();

    }

    /*


        Authorization - Refresh Access Token


     */

    public baseRefreshTokenResponse refreshAccessToken(SpotifyClient client) throws IOException {

        String url = "https://accounts.spotify.com/api/token/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        authorizationInterface authorizationInterface = retrofit.create(Model.authorizationInterface.class);

        Call<baseRefreshTokenResponse> call = authorizationInterface.refreshAccessToken(client.getRefreshTokenString(client.getApiKey(),client.getSecretKey()),"refresh_token",client.getLogin().getRefreshToken());

        Response<baseRefreshTokenResponse> response = call.execute();

        return response.body();

    }

    /*

        Authorization - Getters for Access Token and Refresh Token

     */

    public String getAccessToken(SpotifyClient client) throws IOException {

        return client.getLogin().getAccessToken();

    }

    public String getRefreshToken(SpotifyClient client){

        return client.getLogin().getRefreshToken();

    }

    /************************************************************************



     Album API



     *************************************************************************/

    public BaseAlbum getMultipleAlbums(SpotifyClient client) throws IOException {

        String url = "https://api.spotify.com/v1/albums/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Model.albumInterface albumInterface = retrofit.create(Model.albumInterface.class);

        Call<BaseAlbum> call = albumInterface.getMultipleAlbums(getTokenString(client.getToken()),client.getAlbum().convertAlbumIds());

        Response<BaseAlbum> response = call.execute();

        return response.body();
    }

    public BaseAlbum getMultipleAlbumsMarket(SpotifyClient client) throws IOException {

        String url = "https://api.spotify.com/v1/albums/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Model.albumInterface albumInterface = retrofit.create(Model.albumInterface.class);

        Call<BaseAlbum> call = albumInterface.getMultipleAlbumsMarket(getTokenString(client.getToken()),client.getAlbum().convertAlbumIds(), client.getAlbum().getMarket());

        Response<BaseAlbum> response = call.execute();

        return response.body();
    }


    public Controller.AlbumController.MultipleAlbums.Album getSingleAlbum(SpotifyClient client, Album album) throws IOException {

        String url = String.format("https://api.spotify.com/v1/albums/%s/",album.getAlbumIds().get(0));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        albumInterface albumInterface = retrofit.create(Model.albumInterface.class);

        Call<Controller.AlbumController.MultipleAlbums.Album> call = albumInterface.getSingleAlbum(getTokenString(client.getToken()),album.getAlbumIds().get(0));

        Response<Controller.AlbumController.MultipleAlbums.Album> response = call.execute();

        return response.body();

    }

    public Tracks getAlbumsTracks(SpotifyClient client, String id) throws IOException {
        String url = baseUrl + String.format("/artist%s/",id);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        albumInterface albumInterface = retrofit.create(Model.albumInterface.class);

        Call<Tracks> call = albumInterface.getAlbumTracks(getTokenString(client.getToken()),id);

        Response<Tracks> response = call.execute();

        return response.body();

    }

    /************************************************************************



     Artist API



     *************************************************************************/

    public BaseArtist getMultipleArtists(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/artists/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String ids = String.join(",",client.getArtists().getArtistsIDs());

        artistInterface artistInterface = retrofit.create(Model.artistInterface.class);

        Call<BaseArtist> call = artistInterface.getArtists(getTokenString(client.getToken()),ids);

        Response<BaseArtist> response = call.execute();

        return response.body();

    }

    public Artist getSingleArtist(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/artists/%s/",client.getArtists().getArtistsIDs().get(0));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        artistInterface artistInterface = retrofit.create(Model.artistInterface.class);

        Call<Artist> call = artistInterface.getSingleArtist(getTokenString(client.getToken()),client.getArtists().getArtistsIDs().get(0));

        Response<Artist> response = call.execute();

        return response.body();
    }

    public ArtistTopTrack getArtistsTopTrack(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/artists/{id}/top-tracks/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        artistInterface artistInterface = retrofit.create(artistInterface.class);

        Call<ArtistTopTrack> call = artistInterface.getArtistTopTracks(getTokenString(client.getToken()),client.getArtists().getArtistsIDs().get(0),client.getISOCountryCode());

        Response<ArtistTopTrack> response = call.execute();

        return response.body();
    }

    public BaseArtist getRelatedArtists(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/artists/%s/related-artists/",client.getArtists().getArtistsIDs().get(0));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        artistInterface artistInterface = retrofit.create(artistInterface.class);

        Call<BaseArtist> call = artistInterface.getRelatedArtists(getTokenString(client.getToken()),client.getArtists().getArtistsIDs().get(0));

        Response<BaseArtist> response = call.execute();

        return response.body();

    }

    public ArtistAlbum getArtistAlbums(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/artists/%s/albums/",client.getArtists().getArtistsIDs().get(0));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        artistInterface artistInterface = retrofit.create(artistInterface.class);

        Call<ArtistAlbum> call = artistInterface.getArtistsAlbums(getTokenString(client.getToken()),client.getArtists().getArtistsIDs().get(0));

        Response<ArtistAlbum> response = call.execute();

        return response.body();

    }

    /************************************************************************



     Browse API



     *************************************************************************/

    public Controller.BrowseController.Album.BaseAlbum getAllNewReleases(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/browse/new-releases/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        browseInterface browseInterface = retrofit.create(browseInterface.class);

        Call<Controller.BrowseController.Album.BaseAlbum> call = browseInterface.getNewReleases(getTokenString(client.getToken()));

        Response<Controller.BrowseController.Album.BaseAlbum> response = call.execute();

        return response.body();

    }

    public BasePlaylist getAllFeaturedPlaylists(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/browse/featured-playlists/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        browseInterface browseInterface = retrofit.create(Model.browseInterface.class);

        Call<BasePlaylist> call = browseInterface.getFeaturedPlaylists(getTokenString(client.getToken()));

        Response<BasePlaylist> response = call.execute();

        return response.body();
    }

    public BaseCategory getAllCategories(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/browse/featured-playlists/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        browseInterface browseInterface = retrofit.create(Model.browseInterface.class);

        Call<BaseCategory> call = browseInterface.getCategories(getTokenString(client.getToken()));

        Response<BaseCategory> response = call.execute();

        return response.body();

    }

    public Category getSingleCategory(SpotifyClient client, String categoryId) throws IOException{

        String url = baseUrl + String.format("/v1/browse/categories/%s/",categoryId);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        browseInterface browseInterface = retrofit.create(Model.browseInterface.class);

        Call<Category> call = browseInterface.getSingleCategory(getTokenString(client.getToken()),categoryId);

        Response<Category> response = call.execute();

        return response.body();

    }

    public BasePlaylist getCategoriesPlaylists(SpotifyClient client, String categoryId) throws IOException {

        String url = baseUrl + String.format("/v1/browse/categories/%s/playlists/",categoryId);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        browseInterface browseInterface = retrofit.create(Model.browseInterface.class);

        Call<BasePlaylist> call = browseInterface.getCategoriesPlaylists(getTokenString(client.getToken()),categoryId);

        Response<BasePlaylist> response = call.execute();

        return response.body();
    }

    public BaseRecommendation getRecommendations(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/recommendations/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        browseInterface browseInterface = retrofit.create(Model.browseInterface.class);

        Call<BaseRecommendation> call = browseInterface.getRecommendations(getTokenString(client.getToken()),client.getSeed().convertSeedArtists(),client.getSeed().convertSeedGenres(),client.getSeed().convertSeedTracks());

        Response<BaseRecommendation> response = call.execute();

        return response.body();
    }

    public RecommendationGenreList getRecommendationGenres(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/recommendations/available-genre-seeds/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        browseInterface browseInterface = retrofit.create(Model.browseInterface.class);

        Call<RecommendationGenreList> call = browseInterface.getSeedGenres(getTokenString(client.getToken()));

        Response<RecommendationGenreList> response = call.execute();

        return response.body();

    }

    /************************************************************************



     Episodes API



     *************************************************************************/

    public BaseEpisode getMultipleEpisodes(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/episodes/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        episodeInterface episodeInterface = retrofit.create(Model.episodeInterface.class);

        Call<BaseEpisode> call = episodeInterface.getEpisodes(getTokenString(client.getToken()),client.getEpisode().convertEpisodes());

        Response<BaseEpisode> response = call.execute();

        return response.body();

    }

    public Controller.EpisodeController.Episode getSingleEpisode(SpotifyClient client) throws IOException{

        String url = baseUrl + String.format("/v1/episodes/%s/",client.getEpisode().getEpisodes().get(0));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        episodeInterface episodeInterface = retrofit.create(Model.episodeInterface.class);

        Call<Controller.EpisodeController.Episode> call = episodeInterface.getSingleEpisode(getTokenString(client.getToken()),client.getEpisode().getEpisodes().get(0),"US");

        Response<Controller.EpisodeController.Episode> response = call.execute();

        return response.body();

    }

    /************************************************************************



     Follow API



     *************************************************************************/

    public boolean followAPlaylist(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/playlists/%s/followers/",client.getFollow().getPlayListId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        followInterface followInterface = retrofit.create(Model.followInterface.class);

        Call<Void> call = followInterface.followAPlaylist(getTokenString(client.getAccessToken(client)),client.getContentType(),client.getFollow().getPlayListId());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean unfollowPlaylist(SpotifyClient client) throws IOException{

        String url = baseUrl + String.format("/v1/playlists/%s/followers/",client.getFollow().getPlayListId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        followInterface followInterface = retrofit.create(Model.followInterface.class);

        Call<Void> call = followInterface.unfollowPlaylist(getTokenString(client.getAccessToken(client)),getContentType(),client.getFollow().getPlayListId());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }


    public boolean checkUsersFollowPlaylist(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/playlists/%s/followers/contains/",client.getFollow().getPlayListId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        followInterface followInterface = retrofit.create(Model.followInterface.class);

        Call<Object> call = followInterface.checkUserFollowsPlaylist(getTokenString(client.getAccessToken(client)),client.getFollow().getPlayListId(),client.getUser().convertUserIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public Controller.FollowController.BaseArtist getUsersArtistsFollowed(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/following/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        followInterface followInterface = retrofit.create(Model.followInterface.class);

        Call<Controller.FollowController.BaseArtist> call = followInterface.getUserFollowedArtists(getTokenString(client.getAccessToken(client)),client.getUser().getType());

        Response<Controller.FollowController.BaseArtist> response = call.execute();

        return response.body();

    }

    public boolean followArtistOrUser(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/following/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        followInterface followInterface = retrofit.create(Model.followInterface.class);

        Call<Void> call = followInterface.followUserOrArtist(getTokenString(client.getAccessToken(client)),client.getUser().getType(),client.getUser().convertUserIds(),client.getUser().jsonifyUserIds());

        Response<Void> response = call.execute();

        return response.isSuccessful();
    }

    public boolean unfollowArtistOrUser(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/following/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        followInterface followInterface = retrofit.create(Model.followInterface.class);

        Call<Void> call = followInterface.unfollowArtistOrUser(getTokenString(client.getAccessToken(client)),client.getUser().getType(),client.getUser().convertUserIds());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean getFollwingStateOfUserOrArtist(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/following/contains/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        followInterface followInterface = retrofit.create(Model.followInterface.class);

        Call<Object> call = followInterface.checkFollowingStateForArtistOrUser(getTokenString(client.getAccessToken(client)),client.getUser().getType(),client.getUser().convertUserIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();


    }

    /************************************************************************



    Library API



     *************************************************************************/

    public Controller.LibraryController.BaseAlbum getUserSavedAlbums(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/albums/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Controller.LibraryController.BaseAlbum> call = libraryInterface.getUserSavedAlbums(getTokenString(client.getLogin().getAccessToken()));

        Response<Controller.LibraryController.BaseAlbum> response = call.execute();

        return response.body();

    }

    public boolean saveAlbumsCurrUser(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/albums/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Void> call = libraryInterface.saveAlbumsForCurrentUser(getTokenString(client.getLogin().getAccessToken()),client.getAlbum().convertAlbumIds());

        Response<Void> response = call.execute();

        return response.isSuccessful();


    }

    public boolean removeAlbumsCurrUser(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/albums/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Void> call = libraryInterface.removeAlbumsForCurrentUser(getTokenString(client.getLogin().getAccessToken()),client.getAlbum().convertAlbumIds());

        Response<Void> response = call.execute();

        return response.isSuccessful();


    }

    public boolean checkUserSavedAlbums(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/albums/contains/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Void> call = libraryInterface.checkUserAlbums(getTokenString(client.getLogin().getAccessToken()),client.getAlbum().convertAlbumIds());

        Response<Void> response = call.execute();

        return response.isSuccessful();
    }

    public BaseTrack getUserSavedTracks(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/tracks/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<BaseTrack> call = libraryInterface.getUserSavedTracks(getTokenString(client.getLogin().getAccessToken()));

        Response<BaseTrack> response = call.execute();

        return response.body();
    }

    public boolean saveTracksForUser(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/tracks/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Void> call = libraryInterface.saveTracksToUser(getTokenString(client.getLogin().getAccessToken()),client.getTrackIds().convertTrackIds());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean removeUserSavedTracks(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/tracks/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Void> call = libraryInterface.deleteUserTracks(getTokenString(client.getLogin().getAccessToken()),client.getTrackIds().convertTrackIds());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean checkUserHasTracks(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/tracks/contains/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.checkUserHasOneOrMoreSavedTracks(getTokenString(client.getLogin().getAccessToken()),client.getTrackIds().convertTrackIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public Controller.LibraryController.Episode.BaseEpisode getUserSavedEpisodes(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/tracks/contains/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Controller.LibraryController.Episode.BaseEpisode> call = libraryInterface.getUserSavedEpisodes(getTokenString(client.getLogin().getAccessToken()));

        Response<Controller.LibraryController.Episode.BaseEpisode> response = call.execute();

        return response.body();

    }

    public boolean saveEpisodeForUser(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/episodes/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Void> call = libraryInterface.saveEpisodeForUser(getTokenString(client.getLogin().getAccessToken()),client.getEpisode().convertEpisodes());

        Response<Void> response = call.execute();

        return response.isSuccessful();


    }

    public boolean removeUserSavedEpisodes(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/episodes/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Void> call = libraryInterface.removeUserEpisode(getTokenString(client.getLogin().getAccessToken()),client.getEpisode().convertEpisodes());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean checkIfUserHasSavedEpisodes(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/episodes/contains/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.checkUserHasEpisodes(getTokenString(client.getLogin().getAccessToken()),client.getEpisode().convertEpisodes());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public BaseShow getUserSavedShows(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/shows/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<BaseShow> call = libraryInterface.getUserSavedShows(getTokenString(client.getLogin().getAccessToken()));

        Response<BaseShow> response = call.execute();

        return response.body();

    }

    public boolean saveShowsForCurrentUser(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/shows/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Void> call = libraryInterface.saveShowsForUser(getTokenString(client.getLogin().getAccessToken()),client.getShow().convertShowIds());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean removeUserSavedShows(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/shows/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Void> call = libraryInterface.removeUserSavedShows(getTokenString(client.getLogin().getAccessToken()),client.getShow().convertShowIds());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean checkUserHasSavedShows(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/shows/contains/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.checkUserHasSavedShows(getTokenString(client.getLogin().getAccessToken()),client.getShow().convertShowIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }


    /************************************************************************



     Markets API



     *************************************************************************/


    public List<String> getAvailableMarkets(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/markets/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(Model.marketInterface.class);

        Call<Market> call = marketInterface.getAvailableMarkets(getTokenString(client.getToken()));

        Response<Market> response = call.execute();

        assert response.body() != null;
        return response.body().getMarkets();

    }


    /************************************************************************



     Personalization API



     *************************************************************************/


    public baseUserTopTracksAndArtists getUserTopTracksAndArtists(SpotifyClient client, String type) throws IOException {

        String url = baseUrl + String.format("/v1/me/top/%s/",type);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        personalizationInterface personalizationInterface = retrofit.create(Model.personalizationInterface.class);

        Call<baseUserTopTracksAndArtists> call = personalizationInterface.getUserTopTracksAndArtist(getTokenString(client.getLogin().getAccessToken()),type);

        Response<baseUserTopTracksAndArtists> response = call.execute();

        return response.body();

    }

    /************************************************************************



     Player API



     *************************************************************************/

    public baseUserPlayback getInfoCurrentUserPlayback(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<baseUserPlayback> call = playerInterface.getCurrentUserPlayback(getTokenString(client.getToken()));

        Response<baseUserPlayback> response = call.execute();

        return response.body();

    }

    public boolean transferUserPlaybackToNewDevice(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Void> call = playerInterface.transferUsersPlayback(getTokenString(client.getLogin().getAccessToken()),client.getUser().jsonifyDeviceIds());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public basePlayerDevice getUserAvailableDevices(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/devices/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<basePlayerDevice> call = playerInterface.getCurrentUserAvailableDevices(getTokenString(client.getLogin().getAccessToken()));

        Response<basePlayerDevice> response = call.execute();

        return response.body();

    }

    public baseCurrentTrack getUserCurrentPlayingTrack(SpotifyClient client) throws IOException {
        String url = baseUrl + "/v1/me/player/currently-playing/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<baseCurrentTrack> call = playerInterface.getCurrentUserTrack(getTokenString(client.getLogin().getAccessToken()),client.getISOCountryCode());

        Response<baseCurrentTrack> response = call.execute();

        return response.body();
    }

    public boolean startOrResumeAUsersPlayback(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/play/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Void> call = playerInterface.startOrResumeCurrentUserPlayback(getTokenString(client.getLogin().getAccessToken()));

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean pauseUserPlayback(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/pause/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Void> call = playerInterface.pauseUsersPlayback(getTokenString(client.getLogin().getAccessToken()));

        Response<Void> response = call.execute();

        return response.isSuccessful();


    }

    public boolean skipUserPlaybackToNextTrack(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/next/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Void> call = playerInterface.skipUserPlaybackToNextTrack(getTokenString(client.getLogin().getAccessToken()));

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean skipUserPlaybackToPreviousTrack(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/previous/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Void> call = playerInterface.skipUserPlaybackToPreviousTrack(getTokenString(client.getLogin().getAccessToken()));

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean seekToPositionInCurrentUserTrack(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/seek/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Void> call = playerInterface.seekToCurrentUserTrackPosition(getTokenString(client.getLogin().getAccessToken()),client.getPlayer().getSeekPosition());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean setRepeatModeOnUserPlayback(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/repeat/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Void> call = playerInterface.setRepeatModeOnUserPlayback(getTokenString(client.getLogin().getAccessToken()),client.getPlayer().getRepeatState());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean setVolumeUserPlayback(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/volume/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Void> call = playerInterface.setVolumeForUserPlayback(getTokenString(client.getLogin().getAccessToken()),client.getPlayer().getVolume_percent());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public boolean toggleShuffleForUserPlayback(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/shuffle/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Void> call = playerInterface.toggleShuffleForUserPlayback(getTokenString(client.getLogin().getAccessToken()),client.getPlayer().getShuffleState());

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public Controller.PlayerController.CurrentUserRecentTrack.BaseTrack getCurrUserRecentPlayedTracks(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/recently-played/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Controller.PlayerController.CurrentUserRecentTrack.BaseTrack> call = playerInterface.getCurrentUserRecentlyPlayedTracks(getTokenString(client.getLogin().getAccessToken()));

        Response<Controller.PlayerController.CurrentUserRecentTrack.BaseTrack> response = call.execute();

        return response.body();
    }

    public boolean addItemtoQueue(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/queue/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Void> call = playerInterface.addItemToUserQueue(getTokenString(client.getLogin().getAccessToken()),client.getPlayer().getUri());

        Response<Void> response = call.execute();

        return response.isSuccessful();


    }


    /************************************************************************



     Playlists API



     *************************************************************************/

    public Controller.PlaylistController.UserPlaylists.BasePlaylist getListCurrUserPlaylists(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/playlists/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playlistInterface playlistInterface = retrofit.create(Model.playlistInterface.class);

        Call<Controller.PlaylistController.UserPlaylists.BasePlaylist> call = playlistInterface.getListOfCurrUserPlaylists(getTokenString(client.getLogin().getAccessToken()));

        Response<Controller.PlaylistController.UserPlaylists.BasePlaylist> response = call.execute();

        return response.body();

    }

    public Controller.PlaylistController.UserPlaylists.BasePlaylist getListUserPlaylists(SpotifyClient client) throws IOException {

        String userId = client.getUser().getTheUser().get(0);

        String url = baseUrl + String.format("/v1/users/%s/playlists/",userId);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playlistInterface playlistInterface = retrofit.create(Model.playlistInterface.class);

        Call<Controller.PlaylistController.UserPlaylists.BasePlaylist> call = playlistInterface.getListOfSpecifiedUserPlaylists(getTokenString(client.getLogin().getAccessToken()),userId);

        Response<Controller.PlaylistController.UserPlaylists.BasePlaylist> response = call.execute();

        return response.body();

    }

    public Controller.PlaylistController.UserPlaylists.CreatePlaylist.BasePlaylist createAPlaylist(SpotifyClient client) throws IOException {

        String userId = client.getUser().getTheUser().get(0);

        String url = baseUrl + String.format("v1/users/%s/playlists/",userId);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playlistInterface playlistInterface = retrofit.create(Model.playlistInterface.class);

        Call<Controller.PlaylistController.UserPlaylists.CreatePlaylist.BasePlaylist> call = playlistInterface.createAPlaylist(getTokenString(client.getLogin().getAccessToken()),client.getUser().getTheUser().get(0),client.getPlaylist().getName());

        Response<Controller.PlaylistController.UserPlaylists.CreatePlaylist.BasePlaylist> response = call.execute();

        return response.body();

    }

    public Playlist getAPlaylist(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/playlists/%s/",client.getPlaylist().getPlaylistId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playlistInterface playlistInterface = retrofit.create(Model.playlistInterface.class);

        Call<Playlist> call = playlistInterface.getPlaylist(getTokenString(client.getLogin().getAccessToken()),client.getPlaylist().getPlaylistId());

        Response<Playlist> response = call.execute();

        return response.body();


    }

    public boolean changePlaylistDetails(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/playlists/%s/",client.getPlaylist().getPlaylistId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playlistInterface playlistInterface = retrofit.create(Model.playlistInterface.class);

        Call<Object> call = playlistInterface.changePlaylistDetails(getTokenString(client.getLogin().getAccessToken()),client.getPlaylist().getPlaylistId());

        Response<Object> response = call.execute();

        return response.isSuccessful();
    }

    public BasePlaylistItems getPlaylistItems(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/playlists/%s/tracks/",client.getPlaylist().getPlaylistId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playlistInterface playlistInterface = retrofit.create(Model.playlistInterface.class);

        Call<BasePlaylistItems> call = playlistInterface.getPlaylistItems(getTokenString(client.getLogin().getAccessToken()),client.getPlaylist().getPlaylistId());

        Response<BasePlaylistItems> response = call.execute();

        return response.body();

    }

    public SnapshotId addItemsToPlaylist(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/playlists/%s/tracks/",client.getPlaylist().getPlaylistId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playlistInterface playlistInterface = retrofit.create(Model.playlistInterface.class);

        Call<SnapshotId> call = playlistInterface.addItemsToPlaylist(getTokenString(client.getLogin().getAccessToken()),client.getPlaylist().getPlaylistId());

        Response<SnapshotId> response = call.execute();

        return response.body();

    }

    public SnapshotId reorderOrReplacePlaylistItems(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/playlists/%s/tracks/",client.getPlaylist().getPlaylistId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playlistInterface playlistInterface = retrofit.create(Model.playlistInterface.class);

        Call<SnapshotId> call = playlistInterface.reorderOrReplacePlaylistsItems(getTokenString(client.getLogin().getAccessToken()),client.getPlaylist().getPlaylistId());

        Response<SnapshotId> response = call.execute();

        return response.body();

    }

    public SnapshotId removePlaylistItems(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/playlists/%s/tracks/",client.getPlaylist().getPlaylistId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playlistInterface playlistInterface = retrofit.create(Model.playlistInterface.class);

        Call<SnapshotId> call = playlistInterface.removeItemsFromPlaylist(getTokenString(client.getLogin().getAccessToken()),client.getPlaylist().getPlaylistId(),client.getTrackIds().convertTrackIds());

        Response<SnapshotId> response = call.execute();

        return response.body();

    }

    public CoverImage getPlaylistCoverImage(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/playlists/%s/images/",client.getPlaylist().getPlaylistId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playlistInterface playlistInterface = retrofit.create(Model.playlistInterface.class);

        Call<CoverImage> call = playlistInterface.getPlaylistCoverImage(getTokenString(client.getLogin().getAccessToken()),client.getPlaylist().getPlaylistId());

        Response<CoverImage> response = call.execute();

        return response.body();

    }

    public boolean uploadCustomPlaylistImage(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/playlists/%s/images/",client.getPlaylist().getPlaylistId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playlistInterface playlistInterface = retrofit.create(Model.playlistInterface.class);

        Call<Object> call = playlistInterface.uploadPlaylistCoverImage(getTokenString(client.getLogin().getAccessToken()),client.getContentType(),client.getPlaylist().getPlaylistId());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    /************************************************************************



     Search API



     *************************************************************************/

    public BaseItem searchForItem(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/search/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        searchInterface searchInterface = retrofit.create(Model.searchInterface.class);

        Call<BaseItem> call = searchInterface.searchForAnItem(getTokenString(client.getToken()),client.getItem().getQueryType(),client.getItem().convertItemTypes());

        Response<BaseItem> response = call.execute();

        return response.body();

    }


    /************************************************************************



     Shows API



     *************************************************************************/


    public Controller.ShowController.MultipleShows.BaseShow getMultipleShows(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/shows/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        showInterface showInterface = retrofit.create(Model.showInterface.class);

        Call<Controller.ShowController.MultipleShows.BaseShow> call = showInterface.getMultipleShows(getTokenString(client.getToken()),client.getShow().convertShowIds());

        Response<Controller.ShowController.MultipleShows.BaseShow> response = call.execute();

        return response.body();

    }

    public Show getSpecificShow(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/shows/%s/",client.getShow().getShowIds().get(0));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        showInterface showInterface = retrofit.create(Model.showInterface.class);

        Call<Show> call = showInterface.getASpecificShow(getTokenString(client.getToken()),client.getShow().getShowIds().get(0));

        Response<Show> response = call.execute();

        return response.body();

    }

    public Controller.ShowController.BaseEpisode getShowsEpisodes(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/shows/%s/episodes/",client.getShow().getShowIds().get(0));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        showInterface showInterface = retrofit.create(Model.showInterface.class);

        Call<Controller.ShowController.BaseEpisode> call = showInterface.getAShowsEpisodes(getTokenString(client.getToken()),client.getShow().getShowIds().get(0));

        Response<Controller.ShowController.BaseEpisode> response = call.execute();

        return response.body();

    }


    /************************************************************************



     Tracks API



     *************************************************************************/


    public Controller.TrackController.MultipleTracks.BaseTrack getMultipleTracks(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/tracks/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        trackInterface trackInterface = retrofit.create(Model.trackInterface.class);

        Call<Controller.TrackController.MultipleTracks.BaseTrack> call = trackInterface.getMultipleTracks(getTokenString(client.getToken()),client.getTrackIds().convertTrackIds());

        Response<Controller.TrackController.MultipleTracks.BaseTrack> response = call.execute();

        return response.body();

    }

    public Track getTrack(SpotifyClient client) throws IOException {

        String trackId = client.getTrackIds().getTracks().get(0);

        String url = baseUrl + String.format("/v1/tracks/%s/",trackId);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        trackInterface trackInterface = retrofit.create(Model.trackInterface.class);

        Call<Track> call = trackInterface.getATrack(getTokenString(client.getToken()),trackId);

        Response<Track> response = call.execute();

        return response.body();

    }

    public BaseAudioFeature getAudioFeaturesForSeveralTracks(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/audio-features/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        trackInterface trackInterface = retrofit.create(Model.trackInterface.class);

        Call<BaseAudioFeature> call = trackInterface.getAudioFeaturesMultipleTracks(getTokenString(client.getToken()),client.getTrackIds().convertTrackIds());

        Response<BaseAudioFeature> response = call.execute();

        return response.body();

    }

    public AudioFeature getTrackAudioFeature(SpotifyClient client) throws IOException {

        String trackId = client.getTrackIds().getTracks().get(0);

        String url = baseUrl + String.format("/v1/audio-features/%s/",trackId);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        trackInterface trackInterface = retrofit.create(Model.trackInterface.class);

        Call<AudioFeature> call = trackInterface.getTrackAudioFeatures(getTokenString(client.getToken()),trackId);

        Response<AudioFeature> response = call.execute();

        return response.body();

    }

    public BaseAudioAnalysis getTrackAudioAnalysis(SpotifyClient client) throws IOException {

        String trackId = client.getTrackIds().getTracks().get(0);

        String url = baseUrl + String.format("/v1/audio-analysis/%s/",trackId);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        trackInterface trackInterface = retrofit.create(Model.trackInterface.class);

        Call<BaseAudioAnalysis> call = trackInterface.getTrackAudioAnalysis(getTokenString(client.getToken()),trackId);

        Response<BaseAudioAnalysis> response = call.execute();

        return response.body();

    }

    /************************************************************************



     Users Profile API



     *************************************************************************/

    public BaseProfile getCurrUserProfile(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userprofileInterface userprofileInterface = retrofit.create(Model.userprofileInterface.class);

        Call<BaseProfile> call = userprofileInterface.getCurrentUserProfile(getTokenString(client.getLogin().getAccessToken()));

        Response<BaseProfile> response = call.execute();

        return response.body();
    }

    public Controller.UserProfileController.BaseProfile getUserProfile(SpotifyClient client) throws IOException {

        String userId = client.getUser().getTheUser().get(0);

        String url = baseUrl + String.format("/v1/users/%s/",userId);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userprofileInterface userprofileInterface = retrofit.create(Model.userprofileInterface.class);

        Call<Controller.UserProfileController.BaseProfile> call = userprofileInterface.getSpecificUserProfile(getTokenString(client.getToken()),userId);

        Response<Controller.UserProfileController.BaseProfile> response = call.execute();

        return response.body();

    }










}
