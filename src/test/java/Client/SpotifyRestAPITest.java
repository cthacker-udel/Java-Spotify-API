package Client;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SpotifyRestAPITest {

    static SpotifyClient client;

    static {
        try {
            client = new SpotifyClient("d56c8c3f79a1459bba2c286cfa7aa15b","9dcd475a773d467990dd75eede0af55f");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void makeRequest() {
    }

    @Test
    void implicitGrant() throws IOException {
        client.implicitGrantTokenRequest();
        assertTrue(client.getToken().length() > 0);
    }

    /*

        REMOVE LOGIN AFTER TESTS

     */

    @Test
    void requestAuthorizationCodeFlow() throws IOException {
        try {
            client.getLogin().setEmailOrUsername("exampleUsername@email.com");
            client.getLogin().setPassword("examplePassword");
            client.getLogin().setRedirectUri("exampleRedirect");
            client.requestAuthCodeFlowCode(client);
            assertNotEquals("",client.getLogin().getAuthCode());
        }
        catch(Exception ignored){
            System.out.println("Exception thrown");
        }

    }

    @Test
    void requestAuthorizationAccessTokenAndRefresh(){

        try{
            assertNotNull(client.generateAccessTokenAndRefreshToken(client));
        }
        catch(Exception ignored){
            System.out.println("Exception thrown");
        }

    }
}