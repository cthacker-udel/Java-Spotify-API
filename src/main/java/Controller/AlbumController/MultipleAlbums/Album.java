package Controller.AlbumController.MultipleAlbums;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Album {


        @SerializedName("album_type")
        @Expose
        private String albumType;
        @SerializedName("artists")
        @Expose
        private List<Artist> artists = null;
        @SerializedName("available_markets")
        @Expose
        private List<String> availableMarkets = null;
        @SerializedName("copyrights")
        @Expose
        private List<Copyright> copyrights = null;
        @SerializedName("external_ids")
        @Expose
        private ExternalIds externalIds;
        @SerializedName("external_urls")
        @Expose
        private ExternalUrls externalUrls;
        @SerializedName("genres")
        @Expose
        private List<Object> genres = null;
        @SerializedName("href")
        @Expose
        private String href;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("images")
        @Expose
        private List<Image> images = null;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("popularity")
        @Expose
        private Integer popularity;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;
        @SerializedName("release_date_precision")
        @Expose
        private String releaseDatePrecision;
        @SerializedName("tracks")
        @Expose
        private Tracks tracks;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("uri")
        @Expose
        private String uri;

        public String getAlbumType() {
            return albumType;
        }

        public void setAlbumType(String albumType) {
            this.albumType = albumType;
        }

        public List<Artist> getArtists() {
            return artists;
        }

        public void setArtists(List<Artist> artists) {
            this.artists = artists;
        }

        public List<String> getAvailableMarkets() {
            return availableMarkets;
        }

        public void setAvailableMarkets(List<String> availableMarkets) {
            this.availableMarkets = availableMarkets;
        }

        public List<Copyright> getCopyrights() {
            return copyrights;
        }

        public void setCopyrights(List<Copyright> copyrights) {
            this.copyrights = copyrights;
        }

        public ExternalIds getExternalIds() {
            return externalIds;
        }

        public void setExternalIds(ExternalIds externalIds) {
            this.externalIds = externalIds;
        }

        public ExternalUrls getExternalUrls() {
            return externalUrls;
        }

        public void setExternalUrls(ExternalUrls externalUrls) {
            this.externalUrls = externalUrls;
        }

        public List<Object> getGenres() {
            return genres;
        }

        public void setGenres(List<Object> genres) {
            this.genres = genres;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<Image> getImages() {
            return images;
        }

        public void setImages(List<Image> images) {
            this.images = images;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPopularity() {
            return popularity;
        }

        public void setPopularity(Integer popularity) {
            this.popularity = popularity;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getReleaseDatePrecision() {
            return releaseDatePrecision;
        }

        public void setReleaseDatePrecision(String releaseDatePrecision) {
            this.releaseDatePrecision = releaseDatePrecision;
        }

        public Tracks getTracks() {
            return tracks;
        }

        public void setTracks(Tracks tracks) {
            this.tracks = tracks;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

}
