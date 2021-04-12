package Model;

import Controller.PlaylistController.UserPlaylists.BasePlaylist;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface playlistInterface {

    @GET("https://api.spotify.com/v1/me/playlists")
    Call<BasePlaylist> getListOfCurrUserPlaylists(@Header("Authorization") String auth);

    @GET("https://api.spotify.com/v1/users/{userId}/playlists")
    Call<BasePlaylist> getListOfSpecifiedUserPlaylists(@Header("Authorization") String auth, @Path("userId") String userId);

    @POST("https://api.spotify.com/v1/users/{userId}/playlists")
    Call<Controller.PlaylistController.UserPlaylists.CreatePlaylist.BasePlaylist> createAPlaylist(@Header("Authorization") String auth, @Path("userId") String path, @Body String name);

}
