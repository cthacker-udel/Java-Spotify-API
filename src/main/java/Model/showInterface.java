package Model;

import Controller.ShowController.BaseEpisode;
import Controller.ShowController.MultipleShows.BaseShow;
import Controller.ShowController.MultipleShows.Show;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface showInterface {

    @GET("https://api.spotify.com/v1/shows")
    Call<BaseShow> getMultipleShows(@Header("Authorization") String auth, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/shows/{id}")
    Call<Show> getASpecificShow(@Header("Authorization") String auth, @Path("id") String showId);

    @GET("https://api.spotify.com/v1/shows/{id}/episodes")
    Call<BaseEpisode> getAShowsEpisodes(@Header("Authorization") String auth, @Path("id") String showId);

}
