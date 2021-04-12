package Controller.PlaylistController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("added_at")
    @Expose
    private String addedAt;
    @SerializedName("added_by")
    @Expose
    private AddedBy addedBy;
    @SerializedName("is_local")
    @Expose
    private Boolean isLocal;
    @SerializedName("track")
    @Expose
    private Track track;

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    public AddedBy getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(AddedBy addedBy) {
        this.addedBy = addedBy;
    }

    public Boolean getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(Boolean isLocal) {
        this.isLocal = isLocal;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

}
