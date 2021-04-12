package Controller.TrackController.AudioFeatures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AudioFeature {

    @SerializedName("danceability")
    @Expose
    private Double danceability;
    @SerializedName("energy")
    @Expose
    private Double energy;
    @SerializedName("key")
    @Expose
    private Integer key;
    @SerializedName("loudness")
    @Expose
    private Double loudness;
    @SerializedName("mode")
    @Expose
    private Integer mode;
    @SerializedName("speechiness")
    @Expose
    private Double speechiness;
    @SerializedName("acousticness")
    @Expose
    private Double acousticness;
    @SerializedName("instrumentalness")
    @Expose
    private Double instrumentalness;
    @SerializedName("liveness")
    @Expose
    private Double liveness;
    @SerializedName("valence")
    @Expose
    private Double valence;
    @SerializedName("tempo")
    @Expose
    private Double tempo;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("track_href")
    @Expose
    private String trackHref;
    @SerializedName("analysis_url")
    @Expose
    private String analysisUrl;
    @SerializedName("duration_ms")
    @Expose
    private Integer durationMs;
    @SerializedName("time_signature")
    @Expose
    private Integer timeSignature;

    public Double getDanceability() {
        return danceability;
    }

    public void setDanceability(Double danceability) {
        this.danceability = danceability;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Double getLoudness() {
        return loudness;
    }

    public void setLoudness(Double loudness) {
        this.loudness = loudness;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Double getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(Double speechiness) {
        this.speechiness = speechiness;
    }

    public Double getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(Double acousticness) {
        this.acousticness = acousticness;
    }

    public Double getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(Double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public Double getLiveness() {
        return liveness;
    }

    public void setLiveness(Double liveness) {
        this.liveness = liveness;
    }

    public Double getValence() {
        return valence;
    }

    public void setValence(Double valence) {
        this.valence = valence;
    }

    public Double getTempo() {
        return tempo;
    }

    public void setTempo(Double tempo) {
        this.tempo = tempo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTrackHref() {
        return trackHref;
    }

    public void setTrackHref(String trackHref) {
        this.trackHref = trackHref;
    }

    public String getAnalysisUrl() {
        return analysisUrl;
    }

    public void setAnalysisUrl(String analysisUrl) {
        this.analysisUrl = analysisUrl;
    }

    public Integer getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
    }

    public Integer getTimeSignature() {
        return timeSignature;
    }

    public void setTimeSignature(Integer timeSignature) {
        this.timeSignature = timeSignature;
    }


}
