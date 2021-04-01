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

        SpotifyClient client = new SpotifyClient("d56c8c3f79a1459bba2c286cfa7aa15b","");
        client.implicitGrantTokenRequest();
    }
}