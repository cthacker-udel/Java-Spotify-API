package Model;

import Controller.AlbumController.MultipleAlbums.BaseAlbum;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.util.List;

public interface albumInterface {

    @GET("https:api.spotify.com/v1/albums")
    Call<BaseAlbum> getMultipleAlbums(@Header("Authorization") String Bearer_token, @Query("ids") String ids);

}
