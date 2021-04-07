package Model;

import Controller.LibraryController.BaseAlbum;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface libraryInterface {

    @GET("https://api.spotify.com/v1/me/albums")
    Call<BaseAlbum> getUserSavedAlbums(@Header("Authorization") String auth);


}
