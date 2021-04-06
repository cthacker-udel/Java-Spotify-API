package getRequests;

import Client.SpotifyClient;
import Controller.EpisodeController.BaseEpisode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class EpisodeTest {

    static SpotifyClient client;

    static {
        try {
            client = new SpotifyClient("d56c8c3f79a1459bba2c286cfa7aa15b", "9dcd475a773d467990dd75eede0af55f");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void testGetEpisodes() throws IOException {
        Episode episode = client.getEpisode();
        episode.getEpisodes().add("episode1");
        BaseEpisode episodes = client.getMultipleEpisodes(client);
        assertNotNull(episodes);

    }

    @Test
    void testSingleEpisode() throws IOException{

        Episode episode = client.getEpisode();
        episode.addEpisode("Episode1");
        Controller.EpisodeController.Episode episode2 = client.getSingleEpisode(client,client.getEpisode().getEpisodes().get(0));
        assertNotNull(episode2);

    }



}

