package getRequests;

import Client.SpotifyClient;

import java.util.HashMap;

public class Personalization extends SpotifyClient {

    private String type;
    private String time_range;
    private Integer limit;
    private Integer offset;

    public Personalization(){
        super();
    }

    public HashMap<String,Object> convertQueries(){

        HashMap<String,Object> queryMap = new HashMap<>();

        if(type == null){
            return null;
        }
        if(time_range != null){
            queryMap.put("time_range",this.time_range);
        }
        if(limit != null){
            queryMap.put("limit",this.limit);
        }
        if(offset != null){
            queryMap.put("offset",this.offset);
        }
        return queryMap;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime_range() {
        return time_range;
    }

    public void setTime_range(String time_range) {
        this.time_range = time_range;
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
}
