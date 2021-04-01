package Model;

import retrofit2.Call;
import retrofit2.http.*;

public interface authorizationInterface {

    @FormUrlEncoded
    @POST("https://accounts.spotify.com/api/token")
    Call<Controller.baseAuthResponse> implicitGrant(@Field("client_id") String client_id, @Field("client_secret") String secretKey, @Field("grant_type") String grantType);

}
