package Model;

import Controller.PlaylistController.currUserPlaylists.BasePlaylist;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface playlistInterface {

    @GET("https://api.spotify.com/v1/me/playlists")
    Call<BasePlaylist> getListOfCurrUserPlaylists(@Header("Authorization") String auth);

}
