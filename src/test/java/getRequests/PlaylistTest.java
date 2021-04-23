package getRequests;

import Client.SpotifyClient;
import Client.SpotifyLogin;
import org.junit.jupiter.api.BeforeEach;
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

            // DELETE BEFORE PUSHING

            login.setEmailOrUsername("exampleusername");
            login.setPassword("examplepassword");
            login.setRedirectUri("examplecallback");
            login.addScope("user-modify-playback-state");
            login.addScope("playlist-read-private");
            login.addScope("playlist-read-collaborative");
            client.requestAuthCodeFlowCode(client);
            client.generateAccessTokenAndRefreshToken(client);


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    void init(){
        Playlist clientPlaylist = client.getPlaylist();
        clientPlaylist.clearQueryParams();
    }

    @Test
    void testGetListOfCurrUserPlaylist() throws IOException {
        Playlist clientPlaylist = client.getPlaylist();
        clientPlaylist.setLimit(10);
        clientPlaylist.setOffset(20);
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
