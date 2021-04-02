package Model;

import Controller.AlbumController.MultipleAlbums.BaseAlbum;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface browseInterface {

    @GET("https://api.spotify.com/v1/browse/new-releases")
    Call<BaseAlbum> getNewReleases(@Header("Authorization") String authorization);

}
