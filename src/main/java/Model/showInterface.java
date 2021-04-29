package Model;

import Controller.ShowController.BaseEpisode;
import Controller.ShowController.MultipleShows.BaseShow;
import Controller.ShowController.MultipleShows.Show;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;

public interface showInterface {

    @GET("https://api.spotify.com/v1/shows")
    Call<BaseShow> getMultipleShows(@Header("Authorization") String auth, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/shows/{id}")
    Call<Show> getASpecificShow(@Header("Authorization") String auth, @Path("id") String showId, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/shows/{id}/episodes")
    Call<BaseEpisode> getAShowsEpisodes(@Header("Authorization") String auth, @Path("id") String showId, @QueryMap HashMap<String,Object> queries);

}
