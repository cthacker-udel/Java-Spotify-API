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
import Controller.LibraryController.BaseTrack;
import Model.*;
import getRequests.AlbumInterface;

import getRequests.Episode;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

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

    public String getContentType(){

        return "application/json";

    }

    public String getTokenString(String token){
        return String.format(" Bearer %s",token);
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

    Album methods

     */

    public BaseAlbum getMultipleAlbums(SpotifyClient client, Album album) throws IOException {
        String commaSeparatedIds = String.join(",",album.getAlbumIds());

        String url = "https://api.spotify.com/v1/albums/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Model.albumInterface albumInterface = retrofit.create(Model.albumInterface.class);

        Call<BaseAlbum> call = albumInterface.getMultipleAlbums(getTokenString(client.getToken()),commaSeparatedIds);

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

    /*

    Artist Methods

     */

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

    /*

    Browse methods

     */

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

    /*

    Episodes Methods

     */

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

    public Controller.EpisodeController.Episode getSingleEpisode(SpotifyClient client,String episodeId) throws IOException{

        String url = baseUrl + String.format("/v1/episodes/%s/",episodeId);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        episodeInterface episodeInterface = retrofit.create(Model.episodeInterface.class);

        Call<Controller.EpisodeController.Episode> call = episodeInterface.getSingleEpisode(getTokenString(client.getToken()),episodeId);

        Response<Controller.EpisodeController.Episode> response = call.execute();

        return response.body();

    }

    /*

    Follow Methods

     */

    public boolean followAPlaylist(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/playlists/%s/followers",client.getFollow().getPlayListId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        followInterface followInterface = retrofit.create(Model.followInterface.class);

        Call<Object> call = followInterface.followAPlaylist(getTokenString(client.getToken()),client.getContentType(),client.getFollow().getPlayListId());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean unfollowPlaylist(SpotifyClient client) throws IOException{

        String url = baseUrl + String.format("/v1/playlists/%s/followers/",client.getFollow().getPlayListId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        followInterface followInterface = retrofit.create(Model.followInterface.class);

        Call<Object> call = followInterface.unfollowPlaylist(getTokenString(client.getToken()),getContentType(),client.getFollow().getPlayListId());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }


    public boolean checkUsersFollowPlaylist(SpotifyClient client) throws IOException {

        String url = baseUrl + String.format("/v1/playlists/%s/followers/contains/",client.getFollow().getPlayListId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        followInterface followInterface = retrofit.create(Model.followInterface.class);

        Call<Object> call = followInterface.checkUserFollowsPlaylist(getTokenString(client.getToken()),client.getFollow().getPlayListId(),client.getUserIds().convertUserIds());

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

        Call<Controller.FollowController.BaseArtist> call = followInterface.getUserFollowedArtists(getTokenString(client.getToken()),client.getUserIds().getType());

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

        Call<Object> call = followInterface.followUserOrArtist(getTokenString(client.getToken()),client.getUserIds().getType(),client.getUserIds().convertUserIds(),client.getUserIds().jsonifyUserIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();
    }

    public boolean unfollowArtistOrUser(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/following/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        followInterface followInterface = retrofit.create(Model.followInterface.class);

        Call<Object> call = followInterface.unfollowArtistOrUser(getTokenString(client.getToken()),client.getUserIds().getType(),client.getUserIds().convertUserIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean getFollwingStateOfUserOrArtist(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/following/contains/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        followInterface followInterface = retrofit.create(Model.followInterface.class);

        Call<Object> call = followInterface.checkFollowingStateForArtistOrUser(getTokenString(client.getToken()),client.getUserIds().getType(),client.getUserIds().convertUserIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();


    }

    /*

    Library API

     */

    public Controller.LibraryController.BaseAlbum getUserSavedAlbums(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/albums/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Controller.LibraryController.BaseAlbum> call = libraryInterface.getUserSavedAlbums(getTokenString(client.getToken()));

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

        Call<Object> call = libraryInterface.saveAlbumsForCurrentUser(getTokenString(client.getToken()),client.getAlbum().convertAlbumIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();


    }

    public boolean removeAlbumsCurrUser(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/albums/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.removeAlbumsForCurrentUser(getTokenString(client.getToken()),client.getAlbum().convertAlbumIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();


    }

    public boolean checkOneOrMoreUserSavedAlbums(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/albums/contains/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.checkUserAlbums(getTokenString(client.getToken()),client.getAlbum().convertAlbumIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();
    }

    public BaseTrack getUserSavedTracks(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/tracks/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<BaseTrack> call = libraryInterface.getUserSavedTracks(getTokenString(client.getToken()));

        Response<BaseTrack> response = call.execute();

        return response.body();
    }

    public boolean saveTracksForUser(SpotifyClient client) throws IOException {

        String url = baseUrl = "/v1/me/tracks/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.saveTracksToUser(getTokenString(client.getToken()),client.getTrackIds().convertTrackIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean removeUserSavedTracks(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/tracks/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.deleteUserTracks(getTokenString(client.getToken()),client.getTrackIds().convertTrackIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean checkUserHasTracks(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/tracks/contains/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.checkUserHasOneOrMoreSavedTracks(getTokenString(client.getToken()),client.getTrackIds().convertTrackIds());

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

        Call<Controller.LibraryController.Episode.BaseEpisode> call = libraryInterface.getUserSavedEpisodes(getTokenString(client.getToken()));

        Response<Controller.LibraryController.Episode.BaseEpisode> response = call.execute();

        return response.body();

    }





}
