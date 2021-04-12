package Controller.TrackController.AudioAnalysis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseAudioAnalysis {

    @SerializedName("bars")
    @Expose
    private List<Bar> bars = null;
    @SerializedName("beats")
    @Expose
    private List<Beat> beats = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("sections")
    @Expose
    private List<Section> sections = null;
    @SerializedName("segments")
    @Expose
    private List<Segment> segments = null;
    @SerializedName("tatums")
    @Expose
    private List<Tatum> tatums = null;
    @SerializedName("track")
    @Expose
    private Track track;

    public List<Bar> getBars() {
        return bars;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    public List<Beat> getBeats() {
        return beats;
    }

    public void setBeats(List<Beat> beats) {
        this.beats = beats;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public List<Tatum> getTatums() {
        return tatums;
    }

    public void setTatums(List<Tatum> tatums) {
        this.tatums = tatums;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

}
