package Model;

import Controller.BrowseController.Album.BaseAlbum;
import Controller.BrowseController.Categories.BaseCategory;
import Controller.BrowseController.Categories.Category;
import Controller.BrowseController.Playlist.BasePlaylist;
import Controller.BrowseController.Recommendations.BaseRecommendation;
import Controller.BrowseController.Recommendations.RecommendationGenreList;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;

public interface browseInterface {

    @GET("https://api.spotify.com/v1/browse/new-releases")
    Call<BaseAlbum> getNewReleases(@Header("Authorization") String authorization, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/browse/featured-playlists")
    Call<BasePlaylist> getFeaturedPlaylists(@Header("Authorization") String authorization, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/browse/categories")
    Call<BaseCategory> getCategories(@Header("Authorization") String authorization, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/browse/categories/{categoryId}")
    Call<Category> getSingleCategory(@Header("Authorization") String authorization, @Path("categoryId") String categoryId, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/browse/categories/{categoryId}/playlists")
    Call<BasePlaylist> getCategoriesPlaylists(@Header("Authorization") String authorization, @Path("categoryId") String categoryId, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/recommendations")
    Call<BaseRecommendation> getRecommendations(@Header("Authorization") String authorization, @Query("seed_artists") String artists, @Query("seed_genres") String genres, @Query("seed_tracks") String tracks, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.spotify.com/v1/recommendations/available-genre-seeds")
    Call<RecommendationGenreList> getSeedGenres(@Header("Authorization") String authorization);
}
