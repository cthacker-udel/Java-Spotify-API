package getRequests;

import Client.SpotifyClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class User extends SpotifyClient {

    private ArrayList<String> userIds;
    private ArrayList<String> deviceIds;
    private String market;
    private ArrayList<String> additionalTypes;
    private String type;
    private boolean play;

    private String context_uri;
    private ArrayList<String> uris;
    private Integer offset;
    private Integer position_ms;

    private String singleDeviceId;
    private Integer limit;
    private Integer after;
    private Integer before;


    public User(){
        super();
        this.userIds = new ArrayList<>();
        this.deviceIds = new ArrayList<>();
        this.additionalTypes = new ArrayList<>();
        this.uris = new ArrayList<>();
    }

    public HashMap<String,Object> convertQueries(){
        HashMap<String,Object> queries = new HashMap<>();

        if(additionalTypes != null && additionalTypes.size() > 0){
            queries.put("additional_types",String.join(",",this.additionalTypes));
        }
        if(market != null){
            queries.put("market",this.market);
        }
        if(play){
            queries.put("play",this.play);
        }
        if(context_uri != null){
            queries.put("context_uri",this.context_uri);
        }
        if(uris != null){
            queries.put("uris",new Gson().toJson(this.uris.stream().toArray(String[]::new)));
        }
        if(this.offset != null){
            queries.put("offset",this.offset);
        }
        if(this.position_ms != null){
            queries.put("position_ms",this.position_ms);
        }
        if(this.singleDeviceId != null){
            queries.put("deivce_id",this.singleDeviceId);
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
        return queries;
    }



    public String jsonifyDeviceIds(){
        Map<String,String[]> ids = new LinkedHashMap<>();
        ids.put("device_ids",this.deviceIds.stream().toArray(String[]::new));
        return new Gson().toJson(ids);
    }

    public String getContext_uri() {
        return context_uri;
    }

    public void setContext_uri(String context_uri) {
        this.context_uri = context_uri;
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

    public Integer getPosition_ms() {
        return position_ms;
    }

    public void setPosition_ms(Integer position_ms) {
        this.position_ms = position_ms;
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public ArrayList<String> getUserIds() {
        return userIds;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public ArrayList<String> getAdditionalTypes() {
        return additionalTypes;
    }

    public void setAdditionalTypes(ArrayList<String> additionalTypes) {
        this.additionalTypes = additionalTypes;
    }

    public String convertDeviceIds(){
        return String.join(",",this.deviceIds);
    }

    public void clearDeviceIds(){
        this.deviceIds.clear();
    }

    public void addDeviceId(String deviceId){
        deviceIds.add(deviceId);
    }

    public ArrayList<String> getDeviceIds() {
        return deviceIds;
    }

    public void setDeviceIds(ArrayList<String> deviceIds) {
        this.deviceIds = deviceIds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String convertUserIds(){
        return String.join(",",this.userIds);
    }

    public String jsonifyUserIds(){
        Map<String,String[]> ids = new LinkedHashMap<>();
        ids.put("ids",this.userIds.stream().toArray(String[]::new));
        return new Gson().toJson(ids);
    }

    public void addUserId(String userId){
        this.userIds.add(userId);
    }

    public void clearUserIds(){
        this.userIds.clear();
    }

    public ArrayList<String> getTheUser() {
        return userIds;
    }

    public void setUserIds(ArrayList<String> userIds) {
        this.userIds = userIds;
    }
}
