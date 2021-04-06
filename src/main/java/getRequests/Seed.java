package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;

public class Seed extends SpotifyClient {

    private ArrayList<String> seedArtists;
    private ArrayList<String> seedGenres;
    private ArrayList<String> seedTracks;

    public Seed(){
        super();
        this.seedArtists = new ArrayList<>();
        this.seedGenres = new ArrayList<>();
        this.seedTracks = new ArrayList<>();
    }

    public void AddSeedArtist(String seedArtist){
        this.seedArtists.add("seedArtist");
    }

    public void AddSeedGenre(String seedGenre){
        this.seedGenres.add(seedGenre);
    }

    public void AddSeedTrack(String seedTrack){
        this.seedTracks.add(seedTrack);
    }

    public ArrayList<String> getSeedArtists() {
        return seedArtists;
    }

    public void setSeedArtists(ArrayList<String> seedArtists) {
        this.seedArtists = seedArtists;
    }

    public ArrayList<String> getSeedGenres() {
        return seedGenres;
    }

    public void setSeedGenres(ArrayList<String> seedGenres) {
        this.seedGenres = seedGenres;
    }

    public ArrayList<String> getSeedTracks() {
        return seedTracks;
    }

    public void setSeedTracks(ArrayList<String> seedTracks) {
        this.seedTracks = seedTracks;
    }

    public void clearSeedArtists(){
        this.seedArtists.clear();
    }

    public void clearSeedGenres(){
        this.seedGenres.clear();
    }

    public void clearSeedTracks(){
        this.seedTracks.clear();
    }

    public String convertSeedArtists(){
        return String.join(",",this.seedArtists);
    }

    public String convertSeedTracks(){
        return String.join(",",this.seedTracks);
    }

    public String convertSeedGenres(){
        return String.join(",",this.seedGenres);
    }

}
