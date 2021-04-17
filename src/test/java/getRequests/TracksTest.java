package getRequests;

import Client.SpotifyClient;
import Client.SpotifyLogin;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TracksTest {

    static SpotifyClient client;

    static {
        try {
            client = new SpotifyClient("d56c8c3f79a1459bba2c286cfa7aa15b", "9dcd475a773d467990dd75eede0af55f");

            SpotifyLogin login = client.getLogin();
            login.setEmailOrUsername("exampleEmail");
            login.setPassword("examplePasword");
            login.setRedirectUri("exampleRedirectURI");
            login.addScope("user-modify-playback-state");
            client.requestAuthCodeFlowCode(client);
            client.generateAccessTokenAndRefreshToken(client);


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetSeveralTracks() throws IOException{

        assertNotNull(client.getMultipleTracks(client));

    }

    @Test
    void testGetSpecificTrack() throws IOException{

        assertNotNull(client.getTrack(client));

    }

    @Test
    void testGetAudioFeaturesOfMultipleTracks() throws IOException{

        assertNotNull(client.getAudioFeaturesForSeveralTracks(client));

    }

    @Test
    void testGetAudioFeaturesOfTrack() throws IOException{

        assertNotNull(client.getTrackAudioFeature(client));

    }

    @Test
    void testGetAudioAnalysisOfTrack() throws IOException{

        assertNotNull(client.getTrackAudioAnalysis(client));

    }

}
