package getRequests;

import Client.SpotifyClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class User extends SpotifyClient {

    private ArrayList<String> userIds;
    private String type;

    public User(){
        super();
        this.userIds = new ArrayList<>();
    }

    public ArrayList<String> getUserIds() {
        return userIds;
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
