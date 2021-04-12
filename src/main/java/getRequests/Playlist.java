package getRequests;

import Client.SpotifyClient;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Playlist extends SpotifyClient {

    private String name;
    private String playlistId;

    public Playlist() {
        super();
    }

    public String getName() {
        Map<String,String> nameParams = new HashMap<>();
        nameParams.put("name",this.name);
        return new Gson().toJson(nameParams);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }
}
