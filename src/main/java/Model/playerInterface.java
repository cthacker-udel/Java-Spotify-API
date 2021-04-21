package Model;

import Controller.PlayerController.CurrentTrack.baseCurrentTrack;
import Controller.PlayerController.CurrentUserRecentTrack.BaseTrack;
import Controller.PlayerController.Devices.basePlayerDevice;
import Controller.PlayerController.baseUserPlayback;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.Map;

public interface playerInterface {

    @GET("https://api.spotify.com/v1/me/player")
    Call<baseUserPlayback> getCurrentUserPlayback(@Header("Authorization") String auth, @QueryMap HashMap<String,Object> queries);

    @PUT("https://api.spotify.com/v1/me/player")
    Call<Void> transferUsersPlayback(@Header("Authorization") String auth, @Body String deviceIds, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/me/player/devices")
    Call<basePlayerDevice> getCurrentUserAvailableDevices(@Header("Authorization") String auth);

    @GET("https://api.spotify.com/v1/me/player/currently-playing")
    Call<baseCurrentTrack> getCurrentUserTrack(@Header("Authorization") String auth, @Query("market") String isoCountryCode);

    @PUT("https://api.spotify.com/v1/me/player/play")
    Call<Void> startOrResumeCurrentUserPlayback(@Header("Authorization") String auth);

    @PUT("https://api.spotify.com/v1/me/player/pause")
    Call<Void> pauseUsersPlayback(@Header("Authorization") String auth);

    @POST("https://api.spotify.com/v1/me/player/next")
    Call<Void> skipUserPlaybackToNextTrack(@Header("Authorization") String auth);

    @POST("https://api.spotify.com/v1/me/player/previous")
    Call<Void> skipUserPlaybackToPreviousTrack(@Header("Authorization") String auth);

    @PUT("https://api.spotify.com/v1/me/player/seek")
    Call<Void> seekToCurrentUserTrackPosition(@Header("Authorization") String auth, @Query("position_ms") Integer position);

    @PUT("https://api.spotify.com/v1/me/player/repeat")
    Call<Void> setRepeatModeOnUserPlayback(@Header("Authorization") String auth, @Query("state") String state);

    @PUT("https://api.spotify.com/v1/me/player/volume")
    Call<Void> setVolumeForUserPlayback(@Header("Authorization") String auth, @Query("volume_percent") Integer volume_percent);

    @PUT("https://api.spotify.com/v1/me/player/shuffle")
    Call<Void> toggleShuffleForUserPlayback(@Header("Authorization") String auth, @Query("state") String shuffleState);

    @GET("https://api.spotify.com/v1/me/player/recently-played")
    Call<BaseTrack> getCurrentUserRecentlyPlayedTracks(@Header("Authorization") String auth);

    @POST("https://api.spotify.com/v1/me/playr/queue")
    Call<Void> addItemToUserQueue(@Header("Authorization") String auth, @Query("uri") String uri);

}
