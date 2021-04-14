package Client;

import java.util.ArrayList;

public class SpotifyLogin extends SpotifyClient {

    private String emailOrUsername;
    private String password;
    private String accessToken;
    private String refreshToken;
    private String authCode;
    private String redirectUri;
    private ArrayList<String> scopes;

    public SpotifyLogin(){
        super();
        this.scopes = new ArrayList<>();
    }

    public SpotifyLogin(String username, String password){
        this.emailOrUsername = username;
        this.password = password;
        this.scopes = new ArrayList<>();
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String convertScopes(){
        return String.join(" ",this.scopes);
    }

    public void addScope(String scope){
        this.scopes.add(scope);
    }

    public ArrayList<String> getScopes() {
        return scopes;
    }

    public void setScopes(ArrayList<String> scopes) {
        this.scopes = scopes;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getEmailOrUsername() {
        return emailOrUsername;
    }

    public void setEmailOrUsername(String emailOrUsername) {
        this.emailOrUsername = emailOrUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
