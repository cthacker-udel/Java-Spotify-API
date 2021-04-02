package Model;

import Controller.ArtistController.Artist;
import Controller.ArtistController.ArtistAlbum;
import Controller.ArtistController.ArtistTopTrack;
import Controller.ArtistController.BaseArtist;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface artistInterface {

    @GET("https://api.spotify.com/v1/artists")
    Call<BaseArtist> getArtists(@Header("Authorization") String bearer_token, @Query("ids") String ids);

    @GET("https://api.spotify.com/v1/artists/{id}")
    Call<Artist> getSingleArtist(@Header("Authorization") String bearer_token, @Path("id") String id);

    @GET("https://api.spotify.com/v1/artists/{id}/top-tracks")
    Call<ArtistTopTrack> getArtistTopTracks(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("market") String iso_country_code);

    @GET("https://api.spotify.com/v1/artists/{id}/related-artists")
    Call<BaseArtist> getRelatedArtists(@Header("Authorization") String bearer_token, @Path("id") String id);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbums(@Header("Authorization") String bearer_token, @Path("id") String id);

}
