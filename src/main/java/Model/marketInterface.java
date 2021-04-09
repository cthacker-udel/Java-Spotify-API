package Model;

import Controller.MarketController.Market;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface marketInterface {

    @GET("https://api.spotify.com/v1/markets")
    Call<Market> getAvailableMarkets(@Header("Authorization") String auth);

}
