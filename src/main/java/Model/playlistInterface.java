package Model;

import Controller.PlaylistController.CoverImage;
import Controller.PlaylistController.Playlist;
import Controller.PlaylistController.PlaylistItems.BasePlaylistItems;
import Controller.PlaylistController.SnapshotId;
import Controller.PlaylistController.UserPlaylists.BasePlaylist;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.Map;

public interface playlistInterface {

    @GET("https://api.spotify.com/v1/me/playlists")
    Call<BasePlaylist> getListOfCurrUserPlaylists(@Header("Authorization") String auth, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/users/{userId}/playlists")
    Call<BasePlaylist> getListOfSpecifiedUserPlaylists(@Header("Authorization") String auth, @Path("userId") String userId, @QueryMap HashMap<String,Object> queries);

    @POST("https://api.spotify.com/v1/users/{userId}/playlists")
    Call<Controller.PlaylistController.UserPlaylists.CreatePlaylist.BasePlaylist> createAPlaylist(@Header("Authorization") String auth, @Path("userId") String path, @Body HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/playlists/{playlistId}")
    Call<Playlist> getPlaylist(@Header("Authorzation") String auth, @Path("playlistId") String playListId, @QueryMap HashMap<String,Object> queries);

    @PUT("https://api.spotify.com/v1/playlists/{playlistId}")
    Call<Object> changePlaylistDetails(@Header("Authorization") String auth, @Path("playlistId") String playlistId, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/playlists/{playlistId}/tracks")
    Call<BasePlaylistItems> getPlaylistItems(@Header("Authorization") String auth, @Path("playlistId") String playlistId, @QueryMap HashMap<String,Object> queries);

    @POST("https://api.spotify.com/v1/playlists/{playlistId}/tracks")
    Call<SnapshotId> addItemsToPlaylist(@Header("Authorization") String auth, @Path("playlistId") String playlistId, @QueryMap HashMap<String,Object> queries);

    @PUT("https://api.spotify.com/v1/playlists/{playlistId}/tracks")
    Call<SnapshotId> replacePlaylistsItems(@Header("Authorization") String auth, @Path("playlistId") String playlistId, @QueryMap HashMap<String,Object> queries);

    @PUT("https://api.spotify.com/v1/playlists/{playlistId}/tracks")
    Call<SnapshotId> reorderPlaylistsItems(@Header("Authorization") String auth, @Path("playlistId") String playlistId, @Body HashMap<String,Object> body);

    @DELETE("https://api.spotify.com/v1/playlists/{playlistId}/tracks")
    Call<SnapshotId> removeItemsFromPlaylist(@Header("Authorization") String auth, @Path("playlistId") String playlistId, @Body HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/playlists/{playlistId}/images")
    Call<CoverImage> getPlaylistCoverImage(@Header("Authorization") String auth, @Path("playlistId") String playlistId);

    @PUT("https://api.spotify.com/v1/playlists/{playlistId}/images")
    Call<Object> uploadPlaylistCoverImage(@Header("Authorization") String auth, @Header("Content-Type") String contentType, @Path("playlistId") String playlistId);

}
