package Controller.LibraryController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrackItem {

    @SerializedName("added_at")
    @Expose
    private String addedAt;
    @SerializedName("track")
    @Expose
    private Track track;

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

}
