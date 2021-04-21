package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;
import java.util.HashMap;

public class Seed extends SpotifyClient {

    private ArrayList<String> seedArtists;
    private ArrayList<String> seedGenres;
    private ArrayList<String> seedTracks;

    private Integer limit;
    private String market;
    private Double minAcousticness;
    private Double maxAcousticness;
    private Double targetAcousticness;
    private Double minDanceability;
    private Double maxDanceability;
    private Double targetDanceability;
    private Integer minDurationMS;
    private Integer maxDurationMS;
    private Integer targetDurationMS;
    private Double minEnergy;
    private Double maxEnergy;
    private Double targetEnergy;
    private Double minInstrumentalness;
    private Double maxInstrumentalness;
    private Double targetInstrumentalness;
    private Integer minKey;
    private Integer maxKey;
    private Integer targetKey;
    private Double minLiveness;
    private Double maxLiveness;
    private Double targetLiveness;
    private Double minLoudness;
    private Double maxLoudness;
    private Double targetLoudness;
    private Integer minMode;
    private Integer maxMode;
    private Integer targetMode;
    private Double minPopularity;
    private Double maxPopularity;
    private Double targetPopularity;
    private Double minSpeechiness;
    private Double maxSpeechiness;
    private Double targetSpeechiness;
    private Double minTempo;
    private Double maxTempo;
    private Double targetTempo;
    private Double minTimeSignature;
    private Double maxTimeSignature;
    private Double targetTimeSignature;
    private Double minValence;
    private Double maxValence;
    private Double targetValence;

    private HashMap<String,Object> queryParams = new HashMap<>();


    public Seed(){
        super();
        this.seedArtists = new ArrayList<>();
        this.seedGenres = new ArrayList<>();
        this.seedTracks = new ArrayList<>();
    }

    public HashMap<String,Object> convertQueryParams(){

        if(this.limit != null){
            queryParams.put("limit",this.limit);
        }
        if(this.market != null){
            queryParams.put("market",this.market);
        }
        if(this.minAcousticness != null){
            queryParams.put("min_acousticness",this.minAcousticness);
        }
        if(this.maxAcousticness != null){
            queryParams.put("max_acousticness",this.maxAcousticness);
        }
        if(this.targetAcousticness != null){
            queryParams.put("target_acousticness",this.targetAcousticness);
        }
        if(this.minDanceability != null){
            queryParams.put("min_danceability",this.minDanceability);
        }
        if(this.maxDanceability != null){
            queryParams.put("max_danceability",this.maxDanceability);
        }
        if(this.targetDanceability != null){
            queryParams.put("target_danceability",this.targetDanceability);
        }
        if(this.minDurationMS != null){
            queryParams.put("min_duration_ms",this.minDurationMS);
        }
        if(this.maxDurationMS != null){
            queryParams.put("max_duration_ms",this.maxDurationMS);
        }
        if(this.targetDurationMS != null){
            queryParams.put("target_duration_ms",this.targetDurationMS);
        }
        if(this.minEnergy != null){
            queryParams.put("min_energy",this.minEnergy);
        }
        if(this.maxEnergy != null){
            queryParams.put("max_energy",this.maxEnergy);
        }
        if(this.targetEnergy != null){
            queryParams.put("target_energy",this.targetEnergy);
        }
        if(this.minInstrumentalness != null){
            queryParams.put("min_instrumentalness",this.minInstrumentalness);
        }
        if(this.maxInstrumentalness != null){
            queryParams.put("max_instrumentalness",this.maxInstrumentalness);
        }
        if(this.targetInstrumentalness != null){
            queryParams.put("target_instrumentalness",this.targetInstrumentalness);
        }
        if(this.minKey != null){
            queryParams.put("min_key",this.minKey);
        }
        if(this.maxKey != null){
            queryParams.put("max_key",this.maxKey);
        }
        if(this.targetKey != null){
            queryParams.put("target_key", this.targetKey);
        }
        if(this.minLiveness != null){
            queryParams.put("min_liveness",this.minLiveness);
        }
        if(this.maxLiveness != null){
            queryParams.put("max_liveness",this.maxLiveness);
        }
        if(this.targetLiveness != null){
            queryParams.put("target_liveness",this.targetLiveness);
        }
        if(this.minLoudness != null){
            queryParams.put("min_loudness",this.minLoudness);
        }
        if(this.maxLoudness != null){
            queryParams.put("max_loudness",this.maxLoudness);
        }
        if(this.targetLoudness != null){
            queryParams.put("target_loudness",this.targetLoudness);
        }
        if(this.minMode != null){
            queryParams.put("min_mode",this.minMode);
        }
        if(this.maxMode != null){
            queryParams.put("max_mode",this.maxMode);
        }
        if(this.targetMode != null){
            queryParams.put("target_mode",this.targetMode);
        }
        if(this.minPopularity != null){
            queryParams.put("min_popularity",this.minPopularity);
        }
        if(this.maxPopularity != null){
            queryParams.put("max_popularity",this.maxPopularity);
        }
        if(this.targetPopularity != null){
            queryParams.put("target_popularity",this.targetPopularity);
        }
        if(this.minSpeechiness != null){
            queryParams.put("min_speechiness",this.minSpeechiness);
        }
        if(this.maxSpeechiness != null){
            queryParams.put("max_speechiness",this.maxSpeechiness);
        }
        if(this.targetSpeechiness != null){
            queryParams.put("target_speechiness",this.targetSpeechiness);
        }
        if(this.minTempo != null){
            queryParams.put("min_tempo",this.minTempo);
        }
        if(this.maxTempo != null){
            queryParams.put("max_tempo",this.maxTempo);
        }
        if(this.targetTempo != null){
            queryParams.put("target_tempo",this.targetTempo);
        }
        if(this.minTimeSignature != null){
            queryParams.put("min_time_signature",this.minTimeSignature);
        }
        if(this.maxTimeSignature != null){
            queryParams.put("max_time_signature",this.maxTimeSignature);
        }
        if(this.targetTimeSignature != null){
            queryParams.put("target_time_signature", this.targetTimeSignature);
        }
        if(this.minValence != null){
            queryParams.put("min_valence",this.minValence);
        }
        if(this.maxValence != null){
            queryParams.put("max_valence",this.maxValence);
        }
        if(this.targetValence != null){
            queryParams.put("target_valence",this.targetValence);
        }

        return queryParams;


    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Double getMinAcousticness() {
        return minAcousticness;
    }

    public void setMinAcousticness(Double minAcousticness) {
        this.minAcousticness = minAcousticness;
    }

    public Double getMaxAcousticness() {
        return maxAcousticness;
    }

    public void setMaxAcousticness(Double maxAcousticness) {
        this.maxAcousticness = maxAcousticness;
    }

    public Double getTargetAcousticness() {
        return targetAcousticness;
    }

    public void setTargetAcousticness(Double targetAcousticness) {
        this.targetAcousticness = targetAcousticness;
    }

    public Double getMinDanceability() {
        return minDanceability;
    }

    public void setMinDanceability(Double minDanceability) {
        this.minDanceability = minDanceability;
    }

    public Double getMaxDanceability() {
        return maxDanceability;
    }

    public void setMaxDanceability(Double maxDanceability) {
        this.maxDanceability = maxDanceability;
    }

    public Double getTargetDanceability() {
        return targetDanceability;
    }

    public void setTargetDanceability(Double targetDanceability) {
        this.targetDanceability = targetDanceability;
    }

    public Integer getMinDurationMS() {
        return minDurationMS;
    }

    public void setMinDurationMS(Integer minDurationMS) {
        this.minDurationMS = minDurationMS;
    }

    public Integer getMaxDurationMS() {
        return maxDurationMS;
    }

    public void setMaxDurationMS(Integer maxDurationMS) {
        this.maxDurationMS = maxDurationMS;
    }

    public Integer getTargetDurationMS() {
        return targetDurationMS;
    }

    public void setTargetDurationMS(Integer targetDurationMS) {
        this.targetDurationMS = targetDurationMS;
    }

    public Double getMinEnergy() {
        return minEnergy;
    }

    public void setMinEnergy(Double minEnergy) {
        this.minEnergy = minEnergy;
    }

    public Double getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(Double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public Double getTargetEnergy() {
        return targetEnergy;
    }

    public void setTargetEnergy(Double targetEnergy) {
        this.targetEnergy = targetEnergy;
    }

    public Double getMinInstrumentalness() {
        return minInstrumentalness;
    }

    public void setMinInstrumentalness(Double minInstrumentalness) {
        this.minInstrumentalness = minInstrumentalness;
    }

    public Double getMaxInstrumentalness() {
        return maxInstrumentalness;
    }

    public void setMaxInstrumentalness(Double maxInstrumentalness) {
        this.maxInstrumentalness = maxInstrumentalness;
    }

    public Double getTargetInstrumentalness() {
        return targetInstrumentalness;
    }

    public void setTargetInstrumentalness(Double targetInstrumentalness) {
        this.targetInstrumentalness = targetInstrumentalness;
    }

    public Integer getMinKey() {
        return minKey;
    }

    public void setMinKey(Integer minKey) {
        this.minKey = minKey;
    }

    public Integer getMaxKey() {
        return maxKey;
    }

    public void setMaxKey(Integer maxKey) {
        this.maxKey = maxKey;
    }

    public Integer getTargetKey() {
        return targetKey;
    }

    public void setTargetKey(Integer targetKey) {
        this.targetKey = targetKey;
    }

    public Double getMinLiveness() {
        return minLiveness;
    }

    public void setMinLiveness(Double minLiveness) {
        this.minLiveness = minLiveness;
    }

    public Double getMaxLiveness() {
        return maxLiveness;
    }

    public void setMaxLiveness(Double maxLiveness) {
        this.maxLiveness = maxLiveness;
    }

    public Double getTargetLiveness() {
        return targetLiveness;
    }

    public void setTargetLiveness(Double targetLiveness) {
        this.targetLiveness = targetLiveness;
    }

    public Double getMinLoudness() {
        return minLoudness;
    }

    public void setMinLoudness(Double minLoudness) {
        this.minLoudness = minLoudness;
    }

    public Double getMaxLoudness() {
        return maxLoudness;
    }

    public void setMaxLoudness(Double maxLoudness) {
        this.maxLoudness = maxLoudness;
    }

    public Double getTargetLoudness() {
        return targetLoudness;
    }

    public void setTargetLoudness(Double targetLoudness) {
        this.targetLoudness = targetLoudness;
    }

    public Integer getMinMode() {
        return minMode;
    }

    public void setMinMode(Integer minMode) {
        this.minMode = minMode;
    }

    public Integer getMaxMode() {
        return maxMode;
    }

    public void setMaxMode(Integer maxMode) {
        this.maxMode = maxMode;
    }

    public Integer getTargetMode() {
        return targetMode;
    }

    public void setTargetMode(Integer targetMode) {
        this.targetMode = targetMode;
    }

    public Double getMinPopularity() {
        return minPopularity;
    }

    public void setMinPopularity(Double minPopularity) {
        this.minPopularity = minPopularity;
    }

    public Double getMaxPopularity() {
        return maxPopularity;
    }

    public void setMaxPopularity(Double maxPopularity) {
        this.maxPopularity = maxPopularity;
    }

    public Double getTargetPopularity() {
        return targetPopularity;
    }

    public void setTargetPopularity(Double targetPopularity) {
        this.targetPopularity = targetPopularity;
    }

    public Double getMinSpeechiness() {
        return minSpeechiness;
    }

    public void setMinSpeechiness(Double minSpeechiness) {
        this.minSpeechiness = minSpeechiness;
    }

    public Double getMaxSpeechiness() {
        return maxSpeechiness;
    }

    public void setMaxSpeechiness(Double maxSpeechiness) {
        this.maxSpeechiness = maxSpeechiness;
    }

    public Double getTargetSpeechiness() {
        return targetSpeechiness;
    }

    public void setTargetSpeechiness(Double targetSpeechiness) {
        this.targetSpeechiness = targetSpeechiness;
    }

    public Double getMinTempo() {
        return minTempo;
    }

    public void setMinTempo(Double minTempo) {
        this.minTempo = minTempo;
    }

    public Double getMaxTempo() {
        return maxTempo;
    }

    public void setMaxTempo(Double maxTempo) {
        this.maxTempo = maxTempo;
    }

    public Double getTargetTempo() {
        return targetTempo;
    }

    public void setTargetTempo(Double targetTempo) {
        this.targetTempo = targetTempo;
    }

    public Double getMinTimeSignature() {
        return minTimeSignature;
    }

    public void setMinTimeSignature(Double minTimeSignature) {
        this.minTimeSignature = minTimeSignature;
    }

    public Double getMaxTimeSignature() {
        return maxTimeSignature;
    }

    public void setMaxTimeSignature(Double maxTimeSignature) {
        this.maxTimeSignature = maxTimeSignature;
    }

    public Double getTargetTimeSignature() {
        return targetTimeSignature;
    }

    public void setTargetTimeSignature(Double targetTimeSignature) {
        this.targetTimeSignature = targetTimeSignature;
    }

    public Double getMinValence() {
        return minValence;
    }

    public void setMinValence(Double minValence) {
        this.minValence = minValence;
    }

    public Double getMaxValence() {
        return maxValence;
    }

    public void setMaxValence(Double maxValence) {
        this.maxValence = maxValence;
    }

    public Double getTargetValence() {
        return targetValence;
    }

    public void setTargetValence(Double targetValence) {
        this.targetValence = targetValence;
    }

    public HashMap<String, Object> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(HashMap<String, Object> queryParams) {
        this.queryParams = queryParams;
    }

    public void addSeedArtist(String seedArtist){
        this.seedArtists.add(seedArtist);
    }

    public void addSeedGenre(String seedGenre){
        this.seedGenres.add(seedGenre);
    }

    public void addSeedTrack(String seedTrack){
        this.seedTracks.add(seedTrack);
    }

    public ArrayList<String> getSeedArtists() {
        return seedArtists;
    }

    public void setSeedArtists(ArrayList<String> seedArtists) {
        this.seedArtists = seedArtists;
    }

    public ArrayList<String> getSeedGenres() {
        return seedGenres;
    }

    public void setSeedGenres(ArrayList<String> seedGenres) {
        this.seedGenres = seedGenres;
    }

    public ArrayList<String> getSeedTracks() {
        return seedTracks;
    }

    public void setSeedTracks(ArrayList<String> seedTracks) {
        this.seedTracks = seedTracks;
    }

    public void clearSeedArtists(){
        this.seedArtists.clear();
    }

    public void clearSeedGenres(){
        this.seedGenres.clear();
    }

    public void clearSeedTracks(){
        this.seedTracks.clear();
    }

    public String convertSeedArtists(){
        return String.join(",",this.seedArtists);
    }

    public String convertSeedTracks(){
        return String.join(",",this.seedTracks);
    }

    public String convertSeedGenres(){
        return String.join(",",this.seedGenres);
    }

}
