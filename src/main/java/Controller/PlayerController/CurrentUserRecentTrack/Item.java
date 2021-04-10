package Controller.PlayerController.CurrentUserRecentTrack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("track")
    @Expose
    private Track track;
    @SerializedName("played_at")
    @Expose
    private String playedAt;
    @SerializedName("context")
    @Expose
    private Context context;

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public String getPlayedAt() {
        return playedAt;
    }

    public void setPlayedAt(String playedAt) {
        this.playedAt = playedAt;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
