package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;

public class Track extends SpotifyClient {

    ArrayList<String> trackIds;

    public Track(){
        super();
        this.trackIds = new ArrayList<>();
    }

    public String convertTrackIds(){
        return String.join(",",this.trackIds);
    }

    public void addTrackId(String trackId){
        trackIds.add(trackId);
    }

    public void clearTrackIds(){
        this.trackIds.clear();
    }


    public ArrayList<String> getTracks() {
        return trackIds;
    }

    public void setTracks(ArrayList<String> tracks) {
        this.trackIds = tracks;
    }
}
