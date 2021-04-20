package Model;

import Controller.AlbumController.MultipleAlbums.Album;
import Controller.AlbumController.MultipleAlbums.BaseAlbum;
import Controller.AlbumController.MultipleAlbums.Tracks;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface albumInterface {

    @GET("https://api.spotify.com/v1/albums")
    Call<BaseAlbum> getMultipleAlbums(@Header("Authorization") String Bearer_token, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/albums")
    Call<BaseAlbum> getMultipleAlbumsMarket(@Header("Authorization") String Bearer_token, @Query("ids") String ids, @Query("market") String marketISO);

    @GET("https://api.spotify.com/v1/albums/{id}")
    Call<Album> getSingleAlbum(@Header("Authorization") String bearer_token, @Path("id") String id);

    @GET("https://api.spotify.com/v1/albums/{id}/tracks")
    Call<Tracks> getAlbumTracks(@Header("Authorization") String bearer_token, @Path("id") String id);

}
