package Controller.TrackController.MultipleTracks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseTrack {

    @SerializedName("tracks")
    @Expose
    private List<Track> tracks = null;

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }


}
