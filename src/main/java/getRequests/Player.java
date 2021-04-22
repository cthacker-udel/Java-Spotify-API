package getRequests;

import Client.SpotifyClient;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends SpotifyClient {

    private String repeatState;
    private Integer volume_percent;
    private Integer seekPosition;
    private boolean shuffleState;
    private String uri;
    private ArrayList<String> uris;
    private JsonObject offsetObj;
    private String contextUri;
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
        this.offsetObj = new JsonObject();
    }

    public HashMap<String,Object> convertQueries(){

        HashMap<String,Object> queries = new HashMap<>();

        if(repeatState != null){
            queries.put("state",this.repeatState);
        }
        if(offsetObj != null){
            queries.put("offset",this.offsetObj);
        }
        if(volume_percent != null){
            queries.put("volume_percent",this.volume_percent);
        }
        if(seekPosition != null){
            queries.put("position_ms",this.seekPosition);
        }
        if(shuffleState){
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
            queries.put("additional_types",String.join(",",this.additionalTypes));
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
        if(contextUri != null){
            queries.put("context_uri",this.contextUri);
        }
        return queries;
    }

    public void clearAllQueries(){
        this.repeatState = null;
        this.volume_percent = null;
        this.seekPosition = null;
        this.shuffleState = false;
        this.uri = null;
        this.uris.clear();
        this.deviceId = null;
        this.limit = null;
        this.after = null;
        this.before = null;
        this.offset = null;
        this.additionalTypes.clear();
        this.market = null;
        this.deviceIds.clear();
        this.play = false;
        this.contextUri = null;
        this.offsetObj = null;
    }

    public void initializeOffsetObj(){
        this.offsetObj = new JsonObject();
    }

    public JsonObject getOffsetObj() {
        return offsetObj;
    }

    public void setOffsetObj(JsonObject offsetObj) {
        this.offsetObj = offsetObj;
    }

    public String getContextUri() {
        return contextUri;
    }

    public void setContextUri(String contextUri) {
        this.contextUri = contextUri;
    }

    public boolean isShuffleState() {
        return shuffleState;
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public ArrayList<String> getDeviceIds() {
        return deviceIds;
    }

    public void setDeviceIds(ArrayList<String> deviceIds) {
        this.deviceIds = deviceIds;
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

    public boolean getShuffleState() {
        return shuffleState;
    }

    public void setShuffleState(boolean shuffleState) {
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
