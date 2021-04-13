package Model;

import Controller.EpisodeController.BaseEpisode;

import Controller.EpisodeController.Episode;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface episodeInterface {

    @GET("https://api.spotify.com/v1/episodes")
    Call<BaseEpisode> getEpisodes(@Header("Authorization") String authorization, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/episodes/{episodeId}")
    Call<Episode> getSingleEpisode(@Header("Authorization") String authorization, @Path("episodeId") String episodeId, @Query("market") String market);

}
