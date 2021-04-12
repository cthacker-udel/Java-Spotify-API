package Controller.TrackController.AudioAnalysis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("duration")
    @Expose
    private Double duration;
    @SerializedName("sample_md5")
    @Expose
    private String sampleMd5;
    @SerializedName("offset_seconds")
    @Expose
    private Integer offsetSeconds;
    @SerializedName("window_seconds")
    @Expose
    private Integer windowSeconds;
    @SerializedName("analysis_sample_rate")
    @Expose
    private Integer analysisSampleRate;
    @SerializedName("analysis_channels")
    @Expose
    private Integer analysisChannels;
    @SerializedName("end_of_fade_in")
    @Expose
    private Integer endOfFadeIn;
    @SerializedName("start_of_fade_out")
    @Expose
    private Double startOfFadeOut;
    @SerializedName("loudness")
    @Expose
    private Double loudness;
    @SerializedName("tempo")
    @Expose
    private Double tempo;
    @SerializedName("tempo_confidence")
    @Expose
    private Double tempoConfidence;
    @SerializedName("time_signature")
    @Expose
    private Integer timeSignature;
    @SerializedName("time_signature_confidence")
    @Expose
    private Integer timeSignatureConfidence;
    @SerializedName("key")
    @Expose
    private Integer key;
    @SerializedName("key_confidence")
    @Expose
    private Double keyConfidence;
    @SerializedName("mode")
    @Expose
    private Integer mode;
    @SerializedName("mode_confidence")
    @Expose
    private Double modeConfidence;
    @SerializedName("codestring")
    @Expose
    private String codestring;
    @SerializedName("code_version")
    @Expose
    private Double codeVersion;
    @SerializedName("echoprintstring")
    @Expose
    private String echoprintstring;
    @SerializedName("echoprint_version")
    @Expose
    private Double echoprintVersion;
    @SerializedName("synchstring")
    @Expose
    private String synchstring;
    @SerializedName("synch_version")
    @Expose
    private Integer synchVersion;
    @SerializedName("rhythmstring")
    @Expose
    private String rhythmstring;
    @SerializedName("rhythm_version")
    @Expose
    private Integer rhythmVersion;

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getSampleMd5() {
        return sampleMd5;
    }

    public void setSampleMd5(String sampleMd5) {
        this.sampleMd5 = sampleMd5;
    }

    public Integer getOffsetSeconds() {
        return offsetSeconds;
    }

    public void setOffsetSeconds(Integer offsetSeconds) {
        this.offsetSeconds = offsetSeconds;
    }

    public Integer getWindowSeconds() {
        return windowSeconds;
    }

    public void setWindowSeconds(Integer windowSeconds) {
        this.windowSeconds = windowSeconds;
    }

    public Integer getAnalysisSampleRate() {
        return analysisSampleRate;
    }

    public void setAnalysisSampleRate(Integer analysisSampleRate) {
        this.analysisSampleRate = analysisSampleRate;
    }

    public Integer getAnalysisChannels() {
        return analysisChannels;
    }

    public void setAnalysisChannels(Integer analysisChannels) {
        this.analysisChannels = analysisChannels;
    }

    public Integer getEndOfFadeIn() {
        return endOfFadeIn;
    }

    public void setEndOfFadeIn(Integer endOfFadeIn) {
        this.endOfFadeIn = endOfFadeIn;
    }

    public Double getStartOfFadeOut() {
        return startOfFadeOut;
    }

    public void setStartOfFadeOut(Double startOfFadeOut) {
        this.startOfFadeOut = startOfFadeOut;
    }

    public Double getLoudness() {
        return loudness;
    }

    public void setLoudness(Double loudness) {
        this.loudness = loudness;
    }

    public Double getTempo() {
        return tempo;
    }

    public void setTempo(Double tempo) {
        this.tempo = tempo;
    }

    public Double getTempoConfidence() {
        return tempoConfidence;
    }

    public void setTempoConfidence(Double tempoConfidence) {
        this.tempoConfidence = tempoConfidence;
    }

    public Integer getTimeSignature() {
        return timeSignature;
    }

    public void setTimeSignature(Integer timeSignature) {
        this.timeSignature = timeSignature;
    }

    public Integer getTimeSignatureConfidence() {
        return timeSignatureConfidence;
    }

    public void setTimeSignatureConfidence(Integer timeSignatureConfidence) {
        this.timeSignatureConfidence = timeSignatureConfidence;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Double getKeyConfidence() {
        return keyConfidence;
    }

    public void setKeyConfidence(Double keyConfidence) {
        this.keyConfidence = keyConfidence;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Double getModeConfidence() {
        return modeConfidence;
    }

    public void setModeConfidence(Double modeConfidence) {
        this.modeConfidence = modeConfidence;
    }

    public String getCodestring() {
        return codestring;
    }

    public void setCodestring(String codestring) {
        this.codestring = codestring;
    }

    public Double getCodeVersion() {
        return codeVersion;
    }

    public void setCodeVersion(Double codeVersion) {
        this.codeVersion = codeVersion;
    }

    public String getEchoprintstring() {
        return echoprintstring;
    }

    public void setEchoprintstring(String echoprintstring) {
        this.echoprintstring = echoprintstring;
    }

    public Double getEchoprintVersion() {
        return echoprintVersion;
    }

    public void setEchoprintVersion(Double echoprintVersion) {
        this.echoprintVersion = echoprintVersion;
    }

    public String getSynchstring() {
        return synchstring;
    }

    public void setSynchstring(String synchstring) {
        this.synchstring = synchstring;
    }

    public Integer getSynchVersion() {
        return synchVersion;
    }

    public void setSynchVersion(Integer synchVersion) {
        this.synchVersion = synchVersion;
    }

    public String getRhythmstring() {
        return rhythmstring;
    }

    public void setRhythmstring(String rhythmstring) {
        this.rhythmstring = rhythmstring;
    }

    public Integer getRhythmVersion() {
        return rhythmVersion;
    }

    public void setRhythmVersion(Integer rhythmVersion) {
        this.rhythmVersion = rhythmVersion;
    }


}
