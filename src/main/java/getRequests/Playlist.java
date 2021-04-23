package getRequests;

import Client.SpotifyClient;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class Playlist extends SpotifyClient {

    private String name;
    private String playlistId;

    private String country;

    private String locale;

    private String timestamp;

    private Integer limit;

    private Integer offset;

    public Playlist() {
        super();
    }

    public String getName() {
        Map<String,String> nameParams = new HashMap<>();
        nameParams.put("name",this.name);
        return new Gson().toJson(nameParams);
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
        return queryParams;

    }

    public void clearQueryParams(){

        this.country = null;
        this.locale = null;
        this.timestamp = null;
        this.limit = null;
        this.offset = null;

    }

    public String getCurrentDateISO(){

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        return df.format(new Date());

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
