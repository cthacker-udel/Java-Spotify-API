package Model;

import Controller.BrowseController.Album.BaseAlbum;
import Controller.BrowseController.Categories.BaseCategory;
import Controller.BrowseController.Categories.Category;
import Controller.BrowseController.Playlist.BasePlaylist;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface browseInterface {

    @GET("https://api.spotify.com/v1/browse/new-releases")
    Call<BaseAlbum> getNewReleases(@Header("Authorization") String authorization);

    @GET("https://api.spotify.com/v1/browse/featured-playlists")
    Call<BasePlaylist> getFeaturedPlaylists(@Header("Authorization") String authorization);

    @GET("https://api.spotify.com/v1/browse/categories")
    Call<BaseCategory> getCategories(@Header("Authorization") String authorization);

    @GET("https://api.spotify.com/v1/browse/categories/{categoryId}")
    Call<Category> getSingleCategory(@Header("Authorization") String authorization, @Path("categoryId") String categoryId);


}
