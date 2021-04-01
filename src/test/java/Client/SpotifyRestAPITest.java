package Client;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SpotifyRestAPITest {

    @Test
    void makeRequest() {
    }

    @Test
    void implicitGrant() throws IOException {

        SpotifyClient client = new SpotifyClient("","");
        client.implicitGrantTokenRequest();
        assertTrue(client.getToken().length() > 0);
    }
}