package Model;

import Controller.TrackController.MultipleTracks.BaseTrack;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface trackInterface {

    @GET("https://api.spotify.com/v1/tracks")
    Call<BaseTrack> getMultipleTracks(@Header("Authorization") String auth, @Query("ids") String ids);


}
