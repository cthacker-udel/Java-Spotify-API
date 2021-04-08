package Model;

import Controller.LibraryController.BaseAlbum;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface libraryInterface {

    @GET("https://api.spotify.com/v1/me/albums")
    Call<BaseAlbum> getUserSavedAlbums(@Header("Authorization") String auth);

    @PUT("https://api.spotify.com/v1/me/albums")
    Call<Object> saveAlbumsForCurrentUser(@Header("Authorization") String auth, @Query("ids") String ids);


}
