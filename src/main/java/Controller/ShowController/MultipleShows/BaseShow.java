package Controller.ShowController.MultipleShows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseShow {

    @SerializedName("shows")
    @Expose
    private List<Show> shows = null;

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

}
