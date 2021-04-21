package getRequests;

import Client.SpotifyClient;

import java.io.IOException;
import java.util.HashMap;

public class Follow extends SpotifyClient {

    private String contentType;
    private String playListId;
    private boolean Public = true;
    private String after;
    private Integer limit;

    public Follow(){
        super();
    }

    public boolean isPublic() {
        return Public;
    }

    public void setPublic(boolean aPublic) {
        Public = aPublic;
    }

    public HashMap<String,Object> convertQueries(){

        HashMap<String,Object> queries = new HashMap<>();
        if(this.after != null){
            queries.put("after",this.after);
        }
        if(this.limit != null){
            queries.put("limit",this.limit);
        }
        return queries;

    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getPlayListId() {
        return playListId;
    }

    public void setPlayListId(String playListId) {
        this.playListId = playListId;
    }
}
