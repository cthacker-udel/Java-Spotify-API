package Model;

import Controller.ItemController.BaseItem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface searchInterface {

    @GET("https://api.spotify.com/v1/search")
    Call<BaseItem> searchForAnItem(@Header("Authorization") String auth, @Query("q") String q, @Query("type") String type);

}
