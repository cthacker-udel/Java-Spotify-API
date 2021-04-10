package getRequests;

import Client.SpotifyClient;

public class Player extends SpotifyClient {

    private String repeatState;
    private Integer volume_percent;
    private Integer seekPosition;
    private String shuffleState;
    private String uri;

    public Player(){
        super();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getShuffleState() {
        return shuffleState;
    }

    public void setShuffleState(String shuffleState) {
        this.shuffleState = shuffleState;
    }

    public String getRepeatState() {
        return repeatState;
    }

    public void setRepeatState(String repeatState) {
        this.repeatState = repeatState;
    }

    public Integer getVolume_percent() {
        return volume_percent;
    }

    public void setVolume_percent(Integer volume_percent) {
        this.volume_percent = volume_percent;
    }

    public Integer getSeekPosition() {
        return seekPosition;
    }

    public void setSeekPosition(Integer seekPosition) {
        this.seekPosition = seekPosition;
    }
}
