package Model;

import Controller.UserProfileController.CurrUser.BaseProfile;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface userprofileInterface {

    @GET("https://api.spotify.com/v1/me")
    Call<BaseProfile> getCurrentUserProfile(@Header("Authorization") String auth);

    @GET("https://api.spotify.com/v1/users/{userId}")
    Call<Controller.UserProfileController.BaseProfile> getSpecificUserProfile(@Header("Authorization") String auth, @Path("userId") String userId);

}
