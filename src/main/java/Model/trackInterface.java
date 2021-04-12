package Model;

import Controller.TrackController.AudioAnalysis.BaseAudioAnalysis;
import Controller.TrackController.AudioFeatures.AudioFeature;
import Controller.TrackController.AudioFeatures.BaseAudioFeature;
import Controller.TrackController.MultipleTracks.BaseTrack;
import Controller.TrackController.MultipleTracks.Track;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface trackInterface {

    @GET("https://api.spotify.com/v1/tracks")
    Call<BaseTrack> getMultipleTracks(@Header("Authorization") String auth, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/tracks/{id}")
    Call<Track> getATrack(@Header("Authorization") String auth, @Path("id") String trackId);

    @GET("https://api.spotify.com/v1/audio-features")
    Call<BaseAudioFeature> getAudioFeaturesMultipleTracks(@Header("Authorization") String auth, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/audio-features/{id}")
    Call<AudioFeature> getTrackAudioFeatures(@Header("Authorization") String auth, @Path("id") String trackId);

    @GET("https://api.spotify.com/v1/audio-analysis/{id}")
    Call<BaseAudioAnalysis> getTrackAudioAnalysis(@Header("Authorization") String auth, @Path("id") String trackId);


}
