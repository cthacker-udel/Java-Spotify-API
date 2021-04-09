package Model;

import Controller.LibraryController.BaseAlbum;
import Controller.LibraryController.BaseTrack;
import Controller.LibraryController.Episode.BaseEpisode;
import Controller.LibraryController.Show.BaseShow;
import retrofit2.Call;
import retrofit2.http.*;

public interface libraryInterface {

    @GET("https://api.spotify.com/v1/me/albums")
    Call<BaseAlbum> getUserSavedAlbums(@Header("Authorization") String auth);

    @PUT("https://api.spotify.com/v1/me/albums")
    Call<Object> saveAlbumsForCurrentUser(@Header("Authorization") String auth, @Query("ids") String ids);

    @DELETE("https://api.spotify.com/v1/me/albums")
    Call<Object> removeAlbumsForCurrentUser(@Header("Authorization") String auth, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/me/albums/contains")
    Call<Object> checkUserAlbums(@Header("Authorization") String auth, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/me/tracks")
    Call<BaseTrack> getUserSavedTracks(@Header("Authorization") String auth);

    @PUT("https://api.spotify.com/v1/me/tracks")
    Call<Object> saveTracksToUser(@Header("Authorization") String auth, @Query("ids") String trackIds);

    @DELETE("https://api.spotify.com/v1/me/tracks")
    Call<Object> deleteUserTracks(@Header("Authorization") String auth, @Query("ids") String trackIds);

    @GET("https://api.spotify.com/v1/me/tracks/contains")
    Call<Object> checkUserHasOneOrMoreSavedTracks(@Header("Authorization") String auth, @Query("ids") String trackIds);

    @GET("https://api.spotify.com/v1/me/episodes")
    Call<BaseEpisode> getUserSavedEpisodes(@Header("Authorization") String auth);

    @PUT("https://api.spotify.com/v1/me/episodes")
    Call<Object> saveEpisodeForUser(@Header("Authorization") String auth, @Query("ids") String ids);

    @DELETE("https://api.spotify.com/v1/me/episodes")
    Call<Object> removeUserEpisode(@Header("Authorization") String auth, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/me/episodes/contains")
    Call<Object> checkUserHasEpisodes(@Header("Authorization") String auth, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/me/shows")
    Call<BaseShow> getUserSavedShows(@Header("Authorization") String auth);

    @PUT("https://api.spotify.com/v1/me/shows")
    Call<Object> saveShowsForUser(@Header("Authorization") String auth, @Query("ids") String ids);

    @DELETE("https://api.spotify.com/v1/me/shows")
    Call<Object> removeUserSavedShows(@Header("Authorization") String auth, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/me/shows/contains")
    Call<Object> checkUserHasSavedShows(@Header("Authorization") String auth, @Query("ids") String ids);


}
