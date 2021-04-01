package Controller;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class baseAuthResponse {

    @SerializedName("access_token")
    @Expose
    private String token;

    @SerializedName("token_type")
    @Expose
    private String tokenType;

    @SerializedName("expires_in")
    @Expose
    private String expires_in;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }
}
