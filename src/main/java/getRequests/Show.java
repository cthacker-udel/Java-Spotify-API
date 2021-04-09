package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;

public class Show extends SpotifyClient {

    ArrayList<String> showIds;

    public Show(){
        super();
        this.showIds = new ArrayList<String>();
    }

    public String convertShowIds(){
        return String.join(",",this.showIds);
    }

    public void clearShowIds(){
        this.showIds.clear();
    }

    public void addShowId(String showId){
        this.showIds.add(showId);
    }

    public ArrayList<String> getShowIds() {
        return showIds;
    }

    public void setShowIds(ArrayList<String> showIds) {
        this.showIds = showIds;
    }
}
