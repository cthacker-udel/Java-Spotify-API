package Model;

import Controller.PlaylistController.UserPlaylists.BasePlaylist;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface playlistInterface {

    @GET("https://api.spotify.com/v1/me/playlists")
    Call<BasePlaylist> getListOfCurrUserPlaylists(@Header("Authorization") String auth);

    @GET("https://api.spotify.com/v1/users/{userId}/playlists")
    Call<BasePlaylist> getListOfSpecifiedUserPlaylists(@Header("Authorization") String auth, @Path("userId") String userId);

}
