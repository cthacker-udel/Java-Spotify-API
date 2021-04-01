package Client;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Locale;

public class SpotifyRestAPI extends SpotifyClient{

    String requestType;

    String baseUrl = "https://api.spotify.com";

    public SpotifyRestAPI(String requestType) {
        super();
        this.requestType = requestType;
    }


    public void makeRequest(String requestType){

        if(requestType.toLowerCase(Locale.ENGLISH).equals("get")){
            // make get request
        }
        else if(requestType.toLowerCase(Locale.ENGLISH).equals("post")){
            // make post request
        }
        else if(requestType.toLowerCase(Locale.ENGLISH).equals("put")){
            // make put request
        }
        else{
            // make delete request
        }

    }

    public String implicitGrant(SpotifyClient client, String redirect_uri) throws IOException {
        String accountsUrl = "https://accounts.spotify.com/authorize";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(accountsUrl)
                .build();

        Model.authorizationInterface authorizationInterface = retrofit.create(Model.authorizationInterface.class);

        Call<String> implicitGrantCall = authorizationInterface.implicitGrant(client.getApiKey(),"token","https:google.com");

        Response<String> implicitGrantResponse = implicitGrantCall.execute();

        return implicitGrantResponse.body();
    }

}
