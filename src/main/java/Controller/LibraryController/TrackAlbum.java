package Controller.LibraryController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrackAlbum {

    @SerializedName("album_type")
    @Expose
    private String albumType;
    @SerializedName("artists")
    @Expose
    private List<TrackArtist> artists = null;
    @SerializedName("available_markets")
    @Expose
    private List<String> availableMarkets = null;
    @SerializedName("external_urls")
    @Expose
    private TrackExternalUrls externalUrls;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("images")
    @Expose
    private List<TrackImage> images = null;
    @SerializedName("name")
    @Expose
    private String name;
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

    public List<TrackArtist> getArtists() {
        return artists;
    }

    public void setArtists(List<TrackArtist> artists) {
        this.artists = artists;
    }

    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    public TrackExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(TrackExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
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

    public List<TrackImage> getImages() {
        return images;
    }

    public void setImages(List<TrackImage> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
