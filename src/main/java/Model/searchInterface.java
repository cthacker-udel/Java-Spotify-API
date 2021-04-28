package Model;

import Controller.ItemController.BaseItem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.HashMap;

public interface searchInterface {

    @GET("https://api.spotify.com/v1/search")
    Call<BaseItem> searchForAnItem(@Header("Authorization") String auth, @QueryMap HashMap<String,Object> queries);

}
