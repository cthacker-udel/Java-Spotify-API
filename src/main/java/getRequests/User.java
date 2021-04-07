package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;

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
