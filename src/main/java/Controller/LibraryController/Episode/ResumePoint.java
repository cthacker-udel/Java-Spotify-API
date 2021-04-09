package Controller.LibraryController.Episode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResumePoint {

    @SerializedName("fully_played")
    @Expose
    private Boolean fullyPlayed;
    @SerializedName("resume_position_ms")
    @Expose
    private Integer resumePositionMs;

    public Boolean getFullyPlayed() {
        return fullyPlayed;
    }

    public void setFullyPlayed(Boolean fullyPlayed) {
        this.fullyPlayed = fullyPlayed;
    }

    public Integer getResumePositionMs() {
        return resumePositionMs;
    }

    public void setResumePositionMs(Integer resumePositionMs) {
        this.resumePositionMs = resumePositionMs;
    }

}
