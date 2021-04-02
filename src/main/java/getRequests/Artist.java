package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;

public class Artist extends SpotifyClient {

    private ArrayList<String> artists;

    public Artist(){
        super();
        this.artists = new ArrayList<>();
    }

    public void addArtistId(String id){
        this.artists.add(id);
    }

    public ArrayList<String> getArtistsIDs(){
        return this.artists;
    }

    public void setArtistsIds(ArrayList<String> newArtistsIds){
        this.artists = newArtistsIds;
    }

}
