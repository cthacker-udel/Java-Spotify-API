package Model;

import Controller.PlayerController.CurrentTrack.baseCurrentTrack;
import Controller.PlayerController.CurrentUserRecentTrack.BaseTrack;
import Controller.PlayerController.Devices.basePlayerDevice;
import Controller.PlayerController.baseUserPlayback;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface playerInterface {

    @GET("https://api.spotify.com/v1/me/player")
    Call<baseUserPlayback> getCurrentUserPlayback(@Header("Authorization") String auth);

    @PUT("https://api.spotify.com/v1/me/player")
    Call<Object> transferUsersPlayback(@Header("Authorization") String auth, @Body String deviceIds);

    @GET("https://api.spotify.com/v1/me/player/devices")
    Call<basePlayerDevice> getCurrentUserAvailableDevices(@Header("Authorization") String auth);

    @GET("https://api.spotify.com/v1/me/player/currently-playing")
    Call<baseCurrentTrack> getCurrentUserTrack(@Header("Authorization") String auth, @Query("market") String isoCountryCode);

    @PUT("https://api.spotify.com/v1/me/player/play")
    Call<Object> startOrResumeCurrentUserPlayback(@Header("Authorization") String auth);

    @PUT("https://api.spotify.com/v1/me/player/pause")
    Call<Object> pauseUsersPlayback(@Header("Authorization") String auth);

    @POST("https://api.spotify.com/v1/me/player/next")
    Call<Object> skipUserPlaybackToNextTrack(@Header("Authorization") String auth);

    @POST("https://api.spotify.com/v1/me/player/previous")
    Call<Object> skipUserPlaybackToPreviousTrack(@Header("Authorization") String auth);

    @PUT("https://api.spotify.com/v1/me/player/seek")
    Call<Object> seekToCurrentUserTrackPosition(@Header("Authorization") String auth, @Query("position_ms") Integer position);

    @PUT("https://api.spotify.com/v1/me/player/repeat")
    Call<Object> setRepeatModeOnUserPlayback(@Header("Authorization") String auth, @Query("state") String state);

    @PUT("https://api.spotify.com/v1/me/player/volume")
    Call<Object> setVolumeForUserPlayback(@Header("Authorization") String auth, @Query("volume_percent") Integer volume_percent);

    @PUT("https://api.spotify.com/v1/me/player/shuffle")
    Call<Object> toggleShuffleForUserPlayback(@Header("Authorization") String auth, @Query("state") String shuffleState);

    @GET("https://api.spotify.com/v1/me/player/recently-played")
    Call<BaseTrack> getCurrentUserRecentlyPlayedTracks(@Header("Authorization") String auth);

    @POST("https://api.spotify.com/v1/me/playr/queue")
    Call<Object> addItemToUserQueue(@Header("Authorization") String auth, @Query("uri") String uri);

}