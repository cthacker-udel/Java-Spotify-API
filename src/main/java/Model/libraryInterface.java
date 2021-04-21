package Model;

import Controller.LibraryController.BaseAlbum;
import Controller.LibraryController.BaseTrack;
import Controller.LibraryController.Episode.BaseEpisode;
import Controller.LibraryController.Show.BaseShow;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;

public interface libraryInterface {

    @GET("https://api.spotify.com/v1/me/albums")
    Call<BaseAlbum> getUserSavedAlbums(@Header("Authorization") String auth, @QueryMap HashMap<String,Object> queries);

    @PUT("https://api.spotify.com/v1/me/albums")
    Call<Void> saveAlbumsForCurrentUser(@Header("Authorization") String auth, @Query("ids") String ids);

    @DELETE("https://api.spotify.com/v1/me/albums")
    Call<Void> removeAlbumsForCurrentUser(@Header("Authorization") String auth, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/me/albums/contains")
    Call<Void> checkUserAlbums(@Header("Authorization") String auth, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/me/tracks")
    Call<BaseTrack> getUserSavedTracks(@Header("Authorization") String auth, @QueryMap HashMap<String,Object> queries);

    @PUT("https://api.spotify.com/v1/me/tracks")
    Call<Void> saveTracksToUser(@Header("Authorization") String auth, @Query("ids") String trackIds);

    @DELETE("https://api.spotify.com/v1/me/tracks")
    Call<Void> deleteUserTracks(@Header("Authorization") String auth, @Query("ids") String trackIds);

    @GET("https://api.spotify.com/v1/me/tracks/contains")
    Call<Object> checkUserHasOneOrMoreSavedTracks(@Header("Authorization") String auth, @Query("ids") String trackIds);

    @GET("https://api.spotify.com/v1/me/episodes")
    Call<BaseEpisode> getUserSavedEpisodes(@Header("Authorization") String auth, @QueryMap HashMap<String,Object> queries);

    @PUT("https://api.spotify.com/v1/me/episodes")
    Call<Void> saveEpisodeForUser(@Header("Authorization") String auth, @Query("ids") String ids);

    @DELETE("https://api.spotify.com/v1/me/episodes")
    Call<Void> removeUserEpisode(@Header("Authorization") String auth, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/me/episodes/contains")
    Call<Object> checkUserHasEpisodes(@Header("Authorization") String auth, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/me/shows")
    Call<BaseShow> getUserSavedShows(@Header("Authorization") String auth, @QueryMap HashMap<String,Object> queries);

    @PUT("https://api.spotify.com/v1/me/shows")
    Call<Void> saveShowsForUser(@Header("Authorization") String auth, @Query("ids") String ids);

    @DELETE("https://api.spotify.com/v1/me/shows")
    Call<Void> removeUserSavedShows(@Header("Authorization") String auth, @Query("ids") String ids, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/me/shows/contains")
    Call<Object> checkUserHasSavedShows(@Header("Authorization") String auth, @Query("ids") String ids);


}
