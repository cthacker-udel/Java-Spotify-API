package Client;

import java.util.Locale;

public class SpotifyRestAPI {

    String requestType;

    public SpotifyRestAPI(String requestType) {
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

}
