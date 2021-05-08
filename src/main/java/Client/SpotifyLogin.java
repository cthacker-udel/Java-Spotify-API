package Client;

import java.util.ArrayList;

public class SpotifyLogin extends SpotifyClient {

    /*

    Instance attributes

     */


    /*

    emailOrUsername : String : email or username field on sign in page

     */

    private String emailOrUsername;

    /*

    password : String : password value for webdriver to automatically enter in upon program execution

     */

    private String password;

    /*

    accessToken : String : access token to be acquired upon sign in

     */

    private String accessToken;

    /*

    refreshToken : String : refreshToken utilized to refresh the access token

     */

    private String refreshToken;

    /*

    authCode : String : code used to acquire access token, result of using the redirect uri

     */

    private String authCode;

    /*

    redirectUri : String : redirectUri used to acquire the code used to acquire the access token

     */

    private String redirectUri;

    /*

    scopes : ArrayList<String> : used to specify which scopes to apply to access token before access token request initiated

     */
    private ArrayList<String> scopes;

    /**
     *
     * @author Cameron Thacker - cthacker-udel
     *
     * Default No-arg constructor, intialized scopes to an empty ArrayList
     *
     */

    public SpotifyLogin(){
        super();
        this.scopes = new ArrayList<>();
    }

    /**
     * @author Cameron Thacker - cthacker-udel
     * @param username - Username of the user's Spotify account
     * @param password - Password of the user's Spotify account
     */

    public SpotifyLogin(String username, String password){
        this.emailOrUsername = username;
        this.password = password;
        this.scopes = new ArrayList<>();
    }

    /**
     *
     * @return String - redirectUri - used in generating access token
     *
     */

    public String getRedirectUri() {
        return redirectUri;
    }

    /**
     *
     * @param redirectUri - sets the redirect Uri for implementation in acquiring the access token
     */

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    /**
     *
     * @return converted scopes - Scopes converted to be accepted by the Spotify REST API Server, must be space separated
     *
     */

    public String convertScopes(){
        return String.join(" ",this.scopes);
    }

    /**
     *
     * @param scope - String - scope to add to the ArrayList to specify which scopes should be applied when generating access token
     */

    public void addScope(String scope){
        this.scopes.add(scope);
    }

    /**
     *
     * @return scopes - ArrayList<String> - List of scopes to apply to the access token when requesting token
     *
     */

    public ArrayList<String> getScopes() {
        return scopes;
    }

    /**
     *
     * @param scopes - ArrayList<String> - set scopes to ArrayList passed into function
     */

    public void setScopes(ArrayList<String> scopes) {
        this.scopes = scopes;
    }

    /**
     *
     * @return - String - auth code used in generating the access token
     */

    public String getAuthCode() {
        return authCode;
    }

    /**
     *
     * @param authCode - String authorization code - used in generating the access token
     */

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    /**
     *
     * @return - String - access token - acquires the access token for usage in SpotifyRestApi
     */

    public String getAccessToken() {
        return accessToken;
    }

    /**
     *
     * @param accessToken - String - updates access token to String value passed into function
     */

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     *
     * @return - String - refresh token used in refreshing the access token
     */

    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     *
     * @param refreshToken - String - refresh token passed into function updating current refresh token, for usage refreshing access token
     */

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     *
     * @return - String - User's Spotify email or username registered with this application
     */

    public String getEmailOrUsername() {
        return emailOrUsername;
    }

    /**
     *
     * @param emailOrUsername - String - set Spotify Email or Username to String passed into function
     */

    public void setEmailOrUsername(String emailOrUsername) {
        this.emailOrUsername = emailOrUsername;
    }

    /**
     *
     * @return - String - password associated with Spotify account used to login and generate access token to be used within Spotify REST API
     */

    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password - String - sets User Spotify password to String passed into function
     */

    public void setPassword(String password) {
        this.password = password;
    }
}
