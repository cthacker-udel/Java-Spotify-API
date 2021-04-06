package Controller.BrowseController.Recommendations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseRecommendation {

    @SerializedName("tracks")
    @Expose
    private List<Track> tracks = null;
    @SerializedName("seeds")
    @Expose
    private List<Seed> seeds = null;

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Seed> getSeeds() {
        return seeds;
    }

    public void setSeeds(List<Seed> seeds) {
        this.seeds = seeds;
    }

}
