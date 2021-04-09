package Model;

import Controller.PlayerController.Devices.basePlayerDevice;
import Controller.PlayerController.baseUserPlayback;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;

import java.util.Map;

public interface playerInterface {

    @GET("https://api.spotify.com/v1/me/player")
    Call<baseUserPlayback> getCurrentUserPlayback(@Header("Authorization") String auth);

    @PUT("https://api.spotify.com/v1/me/player")
    Call<Object> transferUsersPlayback(@Header("Authorization") String auth, @Body String deviceIds);

    @GET("https://api.spotify.com/v1/me/player/devices")
    Call<basePlayerDevice> getCurrentUserAvailableDevices(@Header("Authorization") String auth);

    @GET("https://api.spotify.com/v1/me/player/currently-playing")
    Call<Object> call();

}
