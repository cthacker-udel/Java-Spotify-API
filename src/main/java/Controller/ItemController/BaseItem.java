package Controller.ItemController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseItem {

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
