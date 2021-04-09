package Model;

import Controller.PersonalizationController.baseUserTopTracksAndArtists;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface personalizationInterface {

    @GET("https://api.spotify.com/v1/me/top/{type}")
    Call<baseUserTopTracksAndArtists> getUserTopTracksAndArtist(@Header("Authorization") String auth, @Path("type") String type);

}
