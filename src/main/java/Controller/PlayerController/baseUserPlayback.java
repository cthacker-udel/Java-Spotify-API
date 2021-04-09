package Controller.PlayerController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class baseUserPlayback {

    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("device")
    @Expose
    private Device device;
    @SerializedName("progress_ms")
    @Expose
    private String progressMs;
    @SerializedName("is_playing")
    @Expose
    private Boolean isPlaying;
    @SerializedName("currently_playing_type")
    @Expose
    private String currentlyPlayingType;
    @SerializedName("item")
    @Expose
    private Item item;
    @SerializedName("shuffle_state")
    @Expose
    private Boolean shuffleState;
    @SerializedName("repeat_state")
    @Expose
    private String repeatState;
    @SerializedName("context")
    @Expose
    private Context context;

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getProgressMs() {
        return progressMs;
    }

    public void setProgressMs(String progressMs) {
        this.progressMs = progressMs;
    }

    public Boolean getIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(Boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public String getCurrentlyPlayingType() {
        return currentlyPlayingType;
    }

    public void setCurrentlyPlayingType(String currentlyPlayingType) {
        this.currentlyPlayingType = currentlyPlayingType;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Boolean getShuffleState() {
        return shuffleState;
    }

    public void setShuffleState(Boolean shuffleState) {
        this.shuffleState = shuffleState;
    }

    public String getRepeatState() {
        return repeatState;
    }

    public void setRepeatState(String repeatState) {
        this.repeatState = repeatState;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
