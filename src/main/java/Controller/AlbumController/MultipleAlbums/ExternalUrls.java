package Controller.AlbumController.MultipleAlbums;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExternalUrls {

        @SerializedName("spotify")
        @Expose
        private String spotify;

        public String getSpotify() {
            return spotify;
        }

        public void setSpotify(String spotify) {
            this.spotify = spotify;
        }

}
