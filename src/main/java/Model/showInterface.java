package Model;

import Controller.ShowController.MultipleShows.BaseShow;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface showInterface {

    @GET("https://api.spotify.com/v1/shows")
    Call<BaseShow> getMultipleShows(@Header("Authorization") String auth, @Query("ids") String ids);

}
