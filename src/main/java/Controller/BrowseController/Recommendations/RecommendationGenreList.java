package Controller.BrowseController.Recommendations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecommendationGenreList {

    @SerializedName("genres")
    @Expose
    private List<String> genres = null;

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

}
