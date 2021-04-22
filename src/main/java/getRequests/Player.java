package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends SpotifyClient {

    private String repeatState;
    private Integer volume_percent;
    private Integer seekPosition;
    private String shuffleState;
    private String uri;
    private ArrayList<String> uris;
    private String deviceId;
    private Integer limit;
    private Integer after;
    private Integer before;
    private Integer offset;
    private ArrayList<String> additionalTypes;
    private String market;
    private boolean play;
    private ArrayList<String> deviceIds;

    public Player(){
        super();
        this.uris = new ArrayList<>();
        this.additionalTypes = new ArrayList<>();
        this.deviceIds = new ArrayList<>();
    }

    public HashMap<String,Object> convertQueries(){

        HashMap<String,Object> queries = new HashMap<>();

        if(repeatState != null){
            queries.put("state",this.repeatState);
        }
        if(volume_percent != null){
            queries.put("volume_percent",this.volume_percent);
        }
        if(seekPosition != null){
            queries.put("position_ms",this.seekPosition);
        }
        if(shuffleState != null){
            queries.put("state",this.shuffleState);
        }
        if(uri != null){
            queries.put("uri",this.uri);
        }
        if(deviceId != null){
            queries.put("device_id",this.deviceId);
        }
        if(limit != null){
            queries.put("limit",this.limit);
        }
        if(after != null){
            queries.put("after",this.after);
        }
        if(before != null){
            queries.put("before",this.before);
        }
        if(uris.size() != 0){
            queries.put("uris",this.uris);
        }
        if(offset != null){
            queries.put("offset",this.offset);
        }
        if(additionalTypes.size() != 0){
            queries.put("additional_types",this.additionalTypes);
        }
        if(market != null){
            queries.put("market",this.market);
        }
        if(deviceIds.size() != 0){
            queries.put("device_ids",this.deviceIds);
        }
        if(play){
            queries.put("play",this.play);
        }
        return queries;
    }

    public ArrayList<String> getUris() {
        return uris;
    }

    public void setUris(ArrayList<String> uris) {
        this.uris = uris;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public ArrayList<String> getAdditionalTypes() {
        return additionalTypes;
    }

    public void setAdditionalTypes(ArrayList<String> additionalTypes) {
        this.additionalTypes = additionalTypes;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getAfter() {
        return after;
    }

    public void setAfter(Integer after) {
        this.after = after;
    }

    public Integer getBefore() {
        return before;
    }

    public void setBefore(Integer before) {
        this.before = before;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getShuffleState() {
        return shuffleState;
    }

    public void setShuffleState(String shuffleState) {
        this.shuffleState = shuffleState;
    }

    public String getRepeatState() {
        return repeatState;
    }

    public void setRepeatState(String repeatState) {
        this.repeatState = repeatState;
    }

    public Integer getVolume_percent() {
        return volume_percent;
    }

    public void setVolume_percent(Integer volume_percent) {
        this.volume_percent = volume_percent;
    }

    public Integer getSeekPosition() {
        return seekPosition;
    }

    public void setSeekPosition(Integer seekPosition) {
        this.seekPosition = seekPosition;
    }
}
