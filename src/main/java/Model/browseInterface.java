package Model;

import Controller.BrowseController.Album.BaseAlbum;
import Controller.BrowseController.Categories.BaseCategory;
import Controller.BrowseController.Categories.Category;
import Controller.BrowseController.Playlist.BasePlaylist;
import Controller.BrowseController.Recommendations.BaseRecommendation;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface browseInterface {

    @GET("https://api.spotify.com/v1/browse/new-releases")
    Call<BaseAlbum> getNewReleases(@Header("Authorization") String authorization);

    @GET("https://api.spotify.com/v1/browse/featured-playlists")
    Call<BasePlaylist> getFeaturedPlaylists(@Header("Authorization") String authorization);

    @GET("https://api.spotify.com/v1/browse/categories")
    Call<BaseCategory> getCategories(@Header("Authorization") String authorization);

    @GET("https://api.spotify.com/v1/browse/categories/{categoryId}")
    Call<Category> getSingleCategory(@Header("Authorization") String authorization, @Path("categoryId") String categoryId);

    @GET("https://api.spotify.com/v1/browse/categories/{categoryId}/playlists")
    Call<BasePlaylist> getCategoriesPlaylists(@Header("Authorization") String authorization, @Path("categoryId") String categoryId);

    @GET("https://api.spotify.com/v1/recommendations")
    Call<BaseRecommendation> getRecommendations(@Header("Authorization") String authorization, @Query("seed_artists") String artists, @Query("seed_genres") String genres, @Query("seed_tracks") String tracks);


}
