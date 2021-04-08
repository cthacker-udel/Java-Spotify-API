package Controller.LibraryController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrackExternalIds {

    @SerializedName("isrc")
    @Expose
    private String isrc;

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

}
