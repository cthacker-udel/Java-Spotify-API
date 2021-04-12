package Model;

import Controller.PlaylistController.Playlist;
import Controller.PlaylistController.PlaylistItems.BasePlaylistItems;
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

    @GET("https://api.spotify.com/v1/playlists/{playlistId}")
    Call<Playlist> getPlaylist(@Header("Authorzation") String auth, @Path("playlistId") String playListId);

    @PUT("https://api.spotify.com/v1/playlists/{playlistId}")
    Call<Object> changePlaylistDetails(@Header("Authorization") String auth, @Path("playlistId") String playlistId);

    @GET("https://api.spotify.com/v1/playlists/{playlistId}/tracks")
    Call<BasePlaylistItems> getPlaylistItems(@Header("Authorization") String auth, @Path("playlistId") String playlistId);

}
