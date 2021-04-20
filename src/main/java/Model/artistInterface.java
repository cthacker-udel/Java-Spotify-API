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

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsIncludeGroups(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("include_groups") String includeGroups);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsMarket(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("market") String market);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsLimit(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("limit") Integer limit);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsOffset(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("offset") Integer offset);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsIncludeGroupsMarket(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("include_groups") String includeGroups, @Query("market") String market);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsIncludeGroupsLimit(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("include_groups") String includeGroups, @Query("limit") Integer limit);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsIncludeGroupsOffset(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("include_groups") String includeGroups, @Query("offset") Integer offset);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsMarketLimit(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("market") String market, @Query("limit") Integer limit);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsMarketOffset(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("market") String market, @Query("offset") Integer offset);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsLimitOffset(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("limit") Integer market, @Query("offset") Integer offset);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsIncludeGroupsMarketLimit(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("include_groups") String includeGroups, @Query("market") String market, @Query("limit") Integer limit);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsIncludeGroupsMarketOffset(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("include_groups") String includeGroups, @Query("market") String market, @Query("offset") Integer offset);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsIncludeGroupsLimitOffset(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("include_groups") String includeGroups, @Query("limit") Integer limit, @Query("offset") Integer offset);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsMarketLimitOffset(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("market") String market, @Query("limit") Integer limit, @Query("offset") Integer offset);

    @GET("https://api.spotify.com/v1/artists/{id}/albums")
    Call<ArtistAlbum>  getArtistsAlbumsIncludeGroupsMarketLimitOffset(@Header("Authorization") String bearer_token, @Path("id") String id, @Query("include_groups") String includeGroups, @Query("market") String market, @Query("limit") Integer limit, @Query("offset") Integer offset);


}
