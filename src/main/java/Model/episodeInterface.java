package Model;

import Controller.EpisodeController.BaseEpisode;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface episodeInterface {

    @GET("https://api.spotify.com/v1/episodes")
    Call<BaseEpisode> getEpisodes(@Header("Authorization") String authorization, @Query("ids") String ids);

}
