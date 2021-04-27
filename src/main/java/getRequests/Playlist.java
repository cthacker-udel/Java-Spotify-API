package getRequests;

import Client.SpotifyClient;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Playlist extends SpotifyClient {

    private String name;

    private String playlistId;

    private String country;

    private String locale;

    private String timestamp;

    private Integer limit;

    private Integer offset;

    private String userId;

    private boolean Public;

    private boolean collaborative;

    private String description;

    private String market;

    private ArrayList<String> fields;

    private ArrayList<String> additionalTypes;

    public Playlist() {
        super();
    }

    public HashMap<String,Object> convertQueryParams(){

        HashMap<String,Object> queryParams = new HashMap<>();

        if(this.country != null){
            queryParams.put("country",this.country);
        }
        if(this.locale != null){
            queryParams.put("locale",this.locale);
        }
        if(this.timestamp != null){
            queryParams.put("timestamp",this.timestamp);
        }
        if(this.limit != null){
            queryParams.put("limit",this.limit);
        }
        if(this.offset != null){
            queryParams.put("offset",this.offset);
        }
        if(!this.Public){
            queryParams.put("public",this.Public);
        }
        if(!this.collaborative){
            queryParams.put("collaborative",this.collaborative);
        }
        if(this.description != null){
            queryParams.put("description",this.description);
        }
        if(this.name != null){
            queryParams.put("name",this.name);
        }
        if(this.market != null){
            queryParams.put("market",this.market);
        }
        if(this.fields.size() > 0){
            queryParams.put("fields",String.join(",",this.fields));
        }
        if(this.additionalTypes.size() > 0){
            queryParams.put("additional_types",String.join(",",this.additionalTypes));
        }
        return queryParams;

    }

    public void clearQueryParams(){
        this.playlistId = "";
        this.country = null;
        this.locale = null;
        this.timestamp = null;
        this.limit = null;
        this.offset = null;
        this.Public = true;
        this.collaborative = false;
        this.description = null;
        this.name = null;
        this.market = null;
        this.fields.clear();
        this.additionalTypes.clear();
    }

    public String getName() {
        return name;
    }

    public boolean isPublic() {
        return Public;
    }

    public void setPublic(boolean aPublic) {
        Public = aPublic;
    }

    public boolean isCollaborative() {
        return collaborative;
    }

    public void setCollaborative(boolean collaborative) {
        this.collaborative = collaborative;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public ArrayList<String> getFields() {
        return fields;
    }

    public void setFields(ArrayList<String> fields) {
        this.fields = fields;
    }

    public ArrayList<String> getAdditionalTypes() {
        return additionalTypes;
    }

    public void setAdditionalTypes(ArrayList<String> additionalTypes) {
        this.additionalTypes = additionalTypes;
    }

    public String getCurrentDateISO(){

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        return df.format(new Date());

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }
}
