package getRequests;

import Client.SpotifyClient;

import java.io.IOException;

public class Follow extends SpotifyClient {

    private String contentType;
    private String playListId;

    public Follow() throws IOException {
        super();
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getPlayListId() {
        return playListId;
    }

    public void setPlayListId(String playListId) {
        this.playListId = playListId;
    }
}
