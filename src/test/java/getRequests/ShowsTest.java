package getRequests;

import Client.SpotifyClient;
import Client.SpotifyLogin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShowsTest {

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

    @BeforeEach
    void init(){
        Show clientShow = client.getShow();
        clientShow.clearQueries();
    }

    @Test
    void testGetMultipleShows() throws IOException {

        assertNotNull(client.getMultipleShows(client));

    }

    @Test
    void testGetSpecificShow() throws IOException{

        assertNotNull(client.getSpecificShow(client));

    }

    @Test
    void testGetShowsEpisodes() throws IOException{

        assertNotNull(client.getShowsEpisodes(client));

    }



}
