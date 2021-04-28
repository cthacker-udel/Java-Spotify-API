package getRequests;

import Client.SpotifyClient;
import Client.SpotifyLogin;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SearchTest {

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
    void testSearchForAnItem() throws IOException{

        Search clientSearchParams = client.getSearch();
        clientSearchParams.getQueryKeywords().add("roadhouse blues");
        clientSearchParams.getItemTypes().add("album");
        clientSearchParams.getItemTypes().add("track");
        clientSearchParams.setMarket("US");
        clientSearchParams.setLimit(10);
        clientSearchParams.setOffset(10);
        clientSearchParams.setInclude_external("audio");
        assertNotNull(client.searchForItem(client));

    }

}
