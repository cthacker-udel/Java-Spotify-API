package Controller.FollowController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseArtist {

    @SerializedName("artists")
    @Expose
    private Artists artists;

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

}
