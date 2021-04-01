package Client;

import java.io.IOException;

public class SpotifyClient extends SpotifyRestAPI{

    private String secretKey;
    private String apiKey;

    public SpotifyClient(){
        super();
        this.secretKey = "defaultSecretKey";
        this.apiKey = "defaultApiKey";
    }

    public SpotifyClient(String apiKey, String secretKey){
        super();
        this.secretKey = secretKey;
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void implicitGrantTokenRequest() throws IOException {
        super.implicitGrant(this,"https://www.google.com");
    }

}
