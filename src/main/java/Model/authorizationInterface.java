package Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface authorizationInterface {

    @GET("https://accounts.spotify.com/authorize")
    Call<String> implicitGrant(@Query("client_id") String client_id, @Query("reponse_type") String reponse_type, @Query("redirect_uri") String redirect_uri);

}
