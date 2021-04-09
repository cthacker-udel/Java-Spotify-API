package Controller.LibraryController.Episode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Show {

    @SerializedName("available_markets")
    @Expose
    private List<String> availableMarkets = null;
    @SerializedName("copyrights")
    @Expose
    private List<Object> copyrights = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("explicit")
    @Expose
    private Boolean explicit;
    @SerializedName("external_urls")
    @Expose
    private ExternalUrls externalUrls;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("is_externally_hosted")
    @Expose
    private Boolean isExternallyHosted;
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;
    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("total_episodes")
    @Expose
    private Integer totalEpisodes;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("uri")
    @Expose
    private String uri;

    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    public List<Object> getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(List<Object> copyrights) {
        this.copyrights = copyrights;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrls externalUrls) {
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Boolean getIsExternallyHosted() {
        return isExternallyHosted;
    }

    public void setIsExternallyHosted(Boolean isExternallyHosted) {
        this.isExternallyHosted = isExternallyHosted;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(Integer totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
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
