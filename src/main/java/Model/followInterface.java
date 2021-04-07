package Model;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface followInterface {

    @PUT("https://api.spotify.com/v1/playlists/{playlistId}/followers")
    Call<Object> followAPlaylist(@Header("Authorization") String authorization, @Header("Content-Type") String contentType, @Path("playlistId") String playListId);


    @DELETE("https://api.spotify.ocm/v1/playlists/{playlist_id}/followers")
    Call<Object> unfollowPlaylist(@Header("Authorization") String authorization, @Header("Conent-type") String contentTypem, @Path("playlist_id") String playlistID);

    @GET("https://api.spotify.com/v1/playlists/{playlistId}/followers/contains")
    Call<Object> checkUserFollowsPlaylist(@Header("Authorization") String authorization, @Path("playlistId") String playListId, @Query("ids") String userIds);

    @GET("https://api.spotify.com/v1/me/following")
    Call<Controller.FollowController.BaseArtist> getUserFollowedArtists(@Header("Authorization") String auth, @Query("type") String type);

    @PUT("https://api.spotify.com/v1/me/following")
    Call<Object> followUserOrArtist(@Header("Authorization") String auth, @Query("type") String type, @Query("ids") String ids, @Body Map<String,String[]> id);

    @DELETE("https://api.spotify.com/v1/me/following")
    Call<Object> unfollowArtistOrUser(@Header("Authorization") String authorization, @Query("type") String type, @Query("ids") String ids);

}
