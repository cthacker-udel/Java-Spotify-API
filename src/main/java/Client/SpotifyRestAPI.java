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
import Controller.LibraryController.Show.BaseShow;
import Controller.MarketController.Market;
import Controller.PersonalizationController.baseUserTopTracksAndArtists;
import Controller.PlayerController.CurrentTrack.baseCurrentTrack;
import Controller.PlayerController.Devices.basePlayerDevice;
import Controller.PlayerController.baseUserPlayback;
import Controller.PlaylistController.Playlist;
import Controller.PlaylistController.PlaylistItems.BasePlaylistItems;
import Model.*;
import getRequests.AlbumInterface;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.*;

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

    /************************************************************************



     Album API



     *************************************************************************/

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

    /************************************************************************



     Follow API



     *************************************************************************/

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

        Call<Object> call = followInterface.checkUserFollowsPlaylist(getTokenString(client.getToken()),client.getFollow().getPlayListId(),client.getUser().convertUserIds());

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

        Call<Controller.FollowController.BaseArtist> call = followInterface.getUserFollowedArtists(getTokenString(client.getToken()),client.getUser().getType());

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

        Call<Object> call = followInterface.followUserOrArtist(getTokenString(client.getToken()),client.getUser().getType(),client.getUser().convertUserIds(),client.getUser().jsonifyUserIds());

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

        Call<Object> call = followInterface.unfollowArtistOrUser(getTokenString(client.getToken()),client.getUser().getType(),client.getUser().convertUserIds());

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

        Call<Object> call = followInterface.checkFollowingStateForArtistOrUser(getTokenString(client.getToken()),client.getUser().getType(),client.getUser().convertUserIds());

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

    public boolean saveEpisodeForUser(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/episodes/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.saveEpisodeForUser(getTokenString(client.getToken()),client.getEpisode().convertEpisodes());

        Response<Object> response = call.execute();

        return response.isSuccessful();


    }

    public boolean removeUserSavedEpisodes(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/episodes/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.removeUserEpisode(getTokenString(client.getToken()),client.getEpisode().convertEpisodes());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean checkIfUserHasSavedEpisodes(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/episodes/contains/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.checkUserHasEpisodes(getTokenString(client.getToken()),client.getEpisode().convertEpisodes());

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

        Call<BaseShow> call = libraryInterface.getUserSavedShows(getTokenString(client.getToken()));

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

        Call<Object> call = libraryInterface.saveEpisodeForUser(getTokenString(client.getToken()),client.getShow().convertShowIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean removeUserSavedShows(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/shows/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.removeUserSavedShows(getTokenString(client.getToken()),client.getShow().convertShowIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean checkUserHasSavedShows(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/shows/contains/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libraryInterface libraryInterface = retrofit.create(Model.libraryInterface.class);

        Call<Object> call = libraryInterface.checkUserHasSavedShows(getTokenString(client.getToken()),client.getShow().convertShowIds());

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

        Call<baseUserTopTracksAndArtists> call = personalizationInterface.getUserTopTracksAndArtist(getTokenString(client.getToken()),type);

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

        Call<Object> call = playerInterface.transferUsersPlayback(getTokenString(client.getToken()),client.getUser().jsonifyDeviceIds());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public basePlayerDevice getUserAvailableDevices(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/devices/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<basePlayerDevice> call = playerInterface.getCurrentUserAvailableDevices(getTokenString(client.getToken()));

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

        Call<baseCurrentTrack> call = playerInterface.getCurrentUserTrack(getTokenString(client.getToken()),client.getISOCountryCode());

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

        Call<Object> call = playerInterface.startOrResumeCurrentUserPlayback(getTokenString(client.getToken()));

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean pauseUserPlayback(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/pause/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Object> call = playerInterface.pauseUsersPlayback(getTokenString(client.getToken()));

        Response<Object> response = call.execute();

        return response.isSuccessful();


    }

    public boolean skipUserPlaybackToNextTrack(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/next/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Object> call = playerInterface.skipUserPlaybackToNextTrack(getTokenString(client.getToken()));

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean skipUserPlaybackToPreviousTrack(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/previous/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Object> call = playerInterface.skipUserPlaybackToPreviousTrack(getTokenString(client.getToken()));

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean seekToPositionInCurrentUserTrack(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/seek/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Object> call = playerInterface.seekToCurrentUserTrackPosition(getTokenString(client.getToken()),client.getPlayer().getSeekPosition());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean setRepeatModeOnUserPlayback(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/repeat/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Object> call = playerInterface.setRepeatModeOnUserPlayback(getTokenString(client.getToken()),client.getPlayer().getRepeatState());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean setVolumeUserPlayback(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/volume/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Object> call = playerInterface.setVolumeForUserPlayback(getTokenString(client.getToken()),client.getPlayer().getVolume_percent());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public boolean toggleShuffleForUserPlayback(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/shuffle/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Object> call = playerInterface.toggleShuffleForUserPlayback(getTokenString(client.getToken()),client.getPlayer().getShuffleState());

        Response<Object> response = call.execute();

        return response.isSuccessful();

    }

    public Controller.PlayerController.CurrentUserRecentTrack.BaseTrack getCurrUserRecentPlayedTracks(SpotifyClient client) throws IOException {

        String url = baseUrl + "/v1/me/player/recently-played/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerInterface playerInterface = retrofit.create(Model.playerInterface.class);

        Call<Controller.PlayerController.CurrentUserRecentTrack.BaseTrack> call = playerInterface.getCurrentUserRecentlyPlayedTracks(getTokenString(client.getToken()));

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

        Call<Object> call = playerInterface.addItemToUserQueue(getTokenString(client.getToken()),client.getPlayer().getUri());

        Response<Object> response = call.execute();

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

        Call<Controller.PlaylistController.UserPlaylists.BasePlaylist> call = playlistInterface.getListOfCurrUserPlaylists(getTokenString(client.getToken()));

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

        Call<Controller.PlaylistController.UserPlaylists.BasePlaylist> call = playlistInterface.getListOfSpecifiedUserPlaylists(getTokenString(client.getToken()),userId);

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

        Call<Controller.PlaylistController.UserPlaylists.CreatePlaylist.BasePlaylist> call = playlistInterface.createAPlaylist(getTokenString(client.getToken()),client.getUser().getTheUser().get(0),client.getPlaylist().getName());

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

        Call<Playlist> call = playlistInterface.getPlaylist(getTokenString(client.getToken()),client.getPlaylist().getPlaylistId());

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

        Call<Object> call = playlistInterface.changePlaylistDetails(getTokenString(client.getToken()),client.getPlaylist().getPlaylistId());

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

        Call<BasePlaylistItems> call = playlistInterface.getPlaylistItems(getTokenString(client.getToken()),client.getPlaylist().getPlaylistId());

        Response<BasePlaylistItems> response = call.execute();

        return response.body();

    }










}
