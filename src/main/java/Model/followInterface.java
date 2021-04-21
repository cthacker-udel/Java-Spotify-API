package Model;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.Map;

public interface followInterface {

    @PUT("https://api.spotify.com/v1/playlists/{playlistId}/followers")
    Call<Void> followAPlaylist(@Header("Authorization") String authorization, @Header("Content-Type") String contentType, @Path("playlistId") String playListId, @Body boolean isPublic);


    @DELETE("https://api.spotify.com/v1/playlists/{playlist_id}/followers")
    Call<Void> unfollowPlaylist(@Header("Authorization") String authorization, @Header("Conent-type") String contentTypem, @Path("playlist_id") String playlistID);

    @GET("https://api.spotify.com/v1/playlists/{playlistId}/followers/contains")
    Call<Object> checkUserFollowsPlaylist(@Header("Authorization") String authorization, @Path("playlistId") String playListId, @Query("ids") String userIds);

    @GET("https://api.spotify.com/v1/me/following")
    Call<Controller.FollowController.BaseArtist> getUserFollowedArtists(@Header("Authorization") String auth, @Query("type") String type, @QueryMap HashMap<String,Object> queries);

    @PUT("https://api.spotify.com/v1/me/following")
    Call<Void> followUserOrArtist(@Header("Authorization") String auth, @Query("type") String type, @Query("ids") String ids, @Body String id);

    @DELETE("https://api.spotify.com/v1/me/following")
    Call<Void> unfollowArtistOrUser(@Header("Authorization") String authorization, @Query("type") String type, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/me/following/contains")
    Call<Object> checkFollowingStateForArtistOrUser(@Header("Authorization") String auth, @Query("type") String type, @Query("ids") String ids);

}
