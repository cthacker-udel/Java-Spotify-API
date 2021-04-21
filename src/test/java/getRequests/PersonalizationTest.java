package getRequests;

import Client.SpotifyClient;
import Client.SpotifyLogin;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonalizationTest {

    static SpotifyClient client;

    static {
        try {
            client = new SpotifyClient("d56c8c3f79a1459bba2c286cfa7aa15b", "9dcd475a773d467990dd75eede0af55f");

            SpotifyLogin login = client.getLogin();
            login.setEmailOrUsername("exampleEmail");
            login.setPassword("examplePasword");
            login.setRedirectUri("exampleRedirectURI");
            login.addScope("user-top-read");
            client.requestAuthCodeFlowCode(client);
            client.generateAccessTokenAndRefreshToken(client);


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getUserTopArtist() throws IOException {

        Personalization personalization = client.getPersonalization();
        personalization.setType("artists");
        personalization.setTime_range("medium_term");
        personalization.setLimit(5);
        personalization.setOffset(10);
        assertNotNull(client.getUserTopTracksAndArtists(client));

    }

    @Test
    void getUserTopTracks() throws IOException {

        Personalization personalization = client.getPersonalization();
        personalization.setType("tracks");
        personalization.setTime_range("medium_term");
        personalization.setLimit(5);
        personalization.setOffset(10);
        assertNotNull(client.getUserTopTracksAndArtists(client));

    }


}
