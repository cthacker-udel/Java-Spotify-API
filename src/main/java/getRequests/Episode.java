package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;

public class Episode extends SpotifyClient {

    ArrayList<String> episodes;

    public Episode(){
        super();
        this.episodes = new ArrayList<>();
    }

    public void addEpisode(String episode){
        this.episodes.add(episode);
    }

    public String convertEpisodes(){

        return String.join(",",this.episodes);

    }

    public ArrayList<String> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<String> episodes) {
        this.episodes = episodes;
    }

    public void clearEpisodes(){
        this.episodes.clear();
    }
}
