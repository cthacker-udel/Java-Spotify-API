package Model;

import Controller.baseAccessTokenResponse;
import Controller.baseRefreshTokenResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface authorizationInterface {

    @FormUrlEncoded
    @POST("https://accounts.spotify.com/api/token")
    Call<Controller.baseAuthResponse> implicitGrant(@Field("client_id") String client_id, @Field("client_secret") String secretKey, @Field("grant_type") String grantType);

    @GET("https://accounts.spotify.com/authorize")
    Call<String> requestAuthorizationCodeFlow(@Query("client_id") String client_id, @Query("response_type") String code, @Query("redirect_uri") String redirect_uri, @Query("scope") String scopes);

    @FormUrlEncoded
    @POST("https://accounts.spotify.com/api/token")
    Call<baseAccessTokenResponse> getAccessTokenAndRefreshToken(@Field("grant_type") String grantType, @Field("code") String code, @Field("redirect_uri") String redirection_uri, @Field("client_id") String clientId, @Field("client_secret") String clientSecret);

    @FormUrlEncoded
    @POST("https://accounts.spotify.com/api/token")
    Call<baseRefreshTokenResponse> refreshAccessToken(@Header("Authorization") String auth, @Field("grant_type") String grantType, @Field("refresh_token") String refreshToken);

}
