package Model;

import retrofit2.Call;
import retrofit2.http.*;

public interface followInterface {

    @PUT("https://api.spotify.com/v1/playlists/{playlistId}/followers")
    Call<Object> followAPlaylist(@Header("Authorization") String authorization, @Header("Content-Type") String contentType, @Path("playlistId") String playListId);


    @DELETE("https://api.spotify.ocm/v1/playlists/{playlist_id}/followers")
    Call<Object> unfollowPlaylist(@Header("Authorization") String authorization, @Header("Conent-type") String contentTypem, @Path("playlist_id") String playlistID);

    @GET("https://api.spotify.com/v1/playlists/{playlistId}/followers/contains")
    Call<Object> checkUserFollowsPlaylist(@Header("Authorization") String authorization, @Path("playlistId") String playListId, @Query("ids") String userIds);

}
