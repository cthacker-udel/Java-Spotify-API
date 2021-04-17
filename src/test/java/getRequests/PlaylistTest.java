package getRequests;

import Client.SpotifyClient;
import Client.SpotifyLogin;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaylistTest {

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
    void testGetListOfCurrUserPlaylist() throws IOException {

        assertNotNull(client.getListCurrUserPlaylists(client));

    }

    @Test
    void testGetListOfUserPlaylist() throws IOException{

        assertNotNull(client.getListUserPlaylists(client));

    }

    @Test
    void testCreateAPlaylist() throws IOException{

        assertNotNull(client.createAPlaylist(client));

    }

    @Test
    void testGetAPlaylist() throws IOException{

        assertNotNull(client.getAPlaylist(client));

    }

    @Test
    void testChangePlaylistDetails() throws IOException{

        assertTrue(client.changePlaylistDetails(client));

    }

    @Test
    void testGetPlaylistItems() throws IOException{

        assertNotNull(client.getPlaylistItems(client));

    }

    @Test
    void testAddItemsToPlaylist() throws IOException{

        assertNotNull(client.addItemsToPlaylist(client));

    }

    @Test
    void testReorderOrReplacePlaylistItems() throws IOException{

        assertNotNull(client.reorderOrReplacePlaylistItems(client));

    }

    @Test
    void testRemoveItemsFromPlaylist() throws IOException{

        assertNotNull(client.removePlaylistItems(client));

    }

    @Test
    void testGetPlaylistCoverImage() throws IOException{

        assertNotNull(client.getPlaylistCoverImage(client));

    }

    @Test
    void testUploadCustomPlaylistImage() throws IOException{

        assertTrue(client.uploadCustomPlaylistImage(client));

    }

}
