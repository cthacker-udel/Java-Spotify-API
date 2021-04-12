package Controller.TrackController.AudioAnalysis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bar {

    @SerializedName("start")
    @Expose
    private Double start;
    @SerializedName("duration")
    @Expose
    private Double duration;
    @SerializedName("confidence")
    @Expose
    private Double confidence;

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


}
