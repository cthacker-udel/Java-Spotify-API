package Client;

public class SpotifyClient {

    private String secretKey;
    private String apiKey;

    public SpotifyClient(){
        this.secretKey = "defaultSecretKey";
        this.apiKey = "defaultApiKey";
    }

    public SpotifyClient(String apiKey, String secretKey){
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
}
