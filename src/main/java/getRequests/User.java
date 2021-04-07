package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class User extends SpotifyClient {

    private ArrayList<String> userIds;
    private String type;

    public User(){
        super();
        this.userIds = new ArrayList<>();
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

    public Map<String,String[]> jsonifyUserIds(){
        Map<String,String[]> ids = new LinkedHashMap<>();
        ids.put("ids",this.userIds.stream().toArray(String[]::new));
        return ids;
    }

    public void addUserId(String userId){
        this.userIds.add(userId);
    }

    public void clearUserIds(){
        this.userIds.clear();
    }

    public ArrayList<String> getUser() {
        return userIds;
    }

    public void setUserIds(ArrayList<String> userIds) {
        this.userIds = userIds;
    }
}
