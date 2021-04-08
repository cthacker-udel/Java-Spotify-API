package Model;

import Controller.LibraryController.BaseAlbum;
import Controller.LibraryController.BaseTrack;
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


}
