package Controller.TrackController.AudioFeatures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseAudioFeature {

    @SerializedName("audio_features")
    @Expose
    private List<AudioFeature> audioFeatures = null;

    public List<AudioFeature> getAudioFeatures() {
        return audioFeatures;
    }

    public void setAudioFeatures(List<AudioFeature> audioFeatures) {
        this.audioFeatures = audioFeatures;
    }


}
