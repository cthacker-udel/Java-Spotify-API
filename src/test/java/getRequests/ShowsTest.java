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

        Show clientShow = client.getShow();
        clientShow.addShowId("5CfCWKI5pZ28U0uOzXkDHe");
        clientShow.addShowId("5as3aKmN2k11yfDDDSrvaZ");
        clientShow.setMarket("ES");
        assertNotNull(client.getMultipleShows(client));

    }

    @Test
    void testGetSpecificShow() throws IOException{

        Show clientShow = client.getShow();
        clientShow.addShowId("38bS44xjbVVZ3No3ByF1dJ");
        clientShow.addShowId("5as3aKmN2k11yfDDDSrvaZ");
        clientShow.setMarket("ES");
        assertNotNull(client.getSpecificShow(client));

    }

    @Test
    void testGetShowsEpisodes() throws IOException{

        Show clientShow = client.getShow();
        clientShow.addShowId("38bS44xjbVVZ3No3ByF1dJ");
        clientShow.addShowId("5as3aKmN2k11yfDDDSrvaZ");
        clientShow.setMarket("ES");
        clientShow.setLimit(10);
        clientShow.setOffset(5);
        assertNotNull(client.getShowsEpisodes(client));

    }



}
