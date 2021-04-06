package getRequests;

import Client.SpotifyClient;

public class Follow extends SpotifyClient {

    private String contentType;
    private String playListId;

    public Follow(){
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
