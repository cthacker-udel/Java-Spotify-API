package Controller.TrackController.AudioAnalysis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Segment {

    @SerializedName("start")
    @Expose
    private Double start;
    @SerializedName("duration")
    @Expose
    private Double duration;
    @SerializedName("confidence")
    @Expose
    private Double confidence;
    @SerializedName("loudness_start")
    @Expose
    private Double loudnessStart;
    @SerializedName("loudness_max_time")
    @Expose
    private Double loudnessMaxTime;
    @SerializedName("loudness_max")
    @Expose
    private Double loudnessMax;
    @SerializedName("loudness_end")
    @Expose
    private Integer loudnessEnd;
    @SerializedName("pitches")
    @Expose
    private List<Double> pitches = null;
    @SerializedName("timbre")
    @Expose
    private List<Double> timbre = null;

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Double getLoudnessStart() {
        return loudnessStart;
    }

    public void setLoudnessStart(Double loudnessStart) {
        this.loudnessStart = loudnessStart;
    }

    public Double getLoudnessMaxTime() {
        return loudnessMaxTime;
    }

    public void setLoudnessMaxTime(Double loudnessMaxTime) {
        this.loudnessMaxTime = loudnessMaxTime;
    }

    public Double getLoudnessMax() {
        return loudnessMax;
    }

    public void setLoudnessMax(Double loudnessMax) {
        this.loudnessMax = loudnessMax;
    }

    public Integer getLoudnessEnd() {
        return loudnessEnd;
    }

    public void setLoudnessEnd(Integer loudnessEnd) {
        this.loudnessEnd = loudnessEnd;
    }

    public List<Double> getPitches() {
        return pitches;
    }

    public void setPitches(List<Double> pitches) {
        this.pitches = pitches;
    }

    public List<Double> getTimbre() {
        return timbre;
    }

    public void setTimbre(List<Double> timbre) {
        this.timbre = timbre;
    }


}
