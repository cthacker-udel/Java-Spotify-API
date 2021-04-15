package getRequests;

import Client.SpotifyClient;
import Client.SpotifyLogin;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v84.io.IO;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {

    static SpotifyClient client;

    static {
        try {
            client = new SpotifyClient("d56c8c3f79a1459bba2c286cfa7aa15b", "9dcd475a773d467990dd75eede0af55f");

            SpotifyLogin login = client.getLogin();
            login.setEmailOrUsername("exampleEmail");
            login.setPassword("examplePasword");
            login.setRedirectUri("exampleRedirectURI");
            login.addScope("user-library-modify");
            client.requestAuthCodeFlowCode(client);
            client.generateAccessTokenAndRefreshToken(client);


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    void testGetUserSavedAlbums() throws IOException {

        assertNotNull(client.getUserSavedAlbums(client));


    }

    @Test
    void testSaveAlbumsCurrentUser() throws IOException {

        Album clientAlbum = client.getAlbum();
        clientAlbum.addAlbumId("07bYtmE3bPsLB6ZbmmFi8d");

        assertTrue(client.saveAlbumsCurrUser(client));
        client.getAlbum().clearAlbums();

    }

    @Test
    void testRemoveAlbumsCurrUser() throws IOException{

        Album clientAlbum = client.getAlbum();
        clientAlbum.addAlbumId("07bYtmE3bPsLB6ZbmmFi8d");
        assertTrue(client.removeAlbumsCurrUser(client));
        clientAlbum.clearAlbums();

    }

    @Test
    void testCheckUserAlbums() throws IOException {

        Album clientAlbum = client.getAlbum();
        clientAlbum.addAlbumId("07bYtmE3bPsLB6ZbmmFi8d");
        assertTrue(client.checkUserSavedAlbums(client));

    }

    @Test
    void testCheckUserSavedTracks() throws IOException {

        assertNotNull(client.getUserSavedTracks(client));

    }

    @Test
    void testSaveTrackForUser() throws IOException{

        Track clientTrack = client.getTrackIds();
        clientTrack.addTrackId("7ouMYWpwJ422jRcDASZB7P");
        assertTrue(client.saveTracksForUser(client));

    }

    @Test
    void testRemoveTrackForUser() throws IOException{

        Track clientTrack = client.getTrackIds();
        clientTrack.addTrackId("7ouMYWpwJ422jRcDASZB7P");
        assertTrue(client.removeUserSavedTracks(client));

    }

    @Test
    void checkUserSavedTracks() throws IOException{

        Track clientTrack = client.getTrackIds();
        clientTrack.addTrackId("7ouMYWpwJ422jRcDASZB7P");
        assertTrue(client.checkUserHasTracks(client));

    }

    @Test
    void getUserSavedEpisodes() throws IOException{

        assertNotNull(client.getUserSavedEpisodes(client));

    }

    @Test
    void saveEpisodesCurrUser() throws IOException{

        Episode clientEpisodes = client.getEpisode();
        clientEpisodes.addEpisode("exampleEpisodeId");
        // can add multiple ids
        assertTrue(client.saveEpisodeForUser(client));

    }

    @Test
    void removeUserSavedEpisodes() throws IOException{

        Episode clientEpisodes = client.getEpisode();
        clientEpisodes.addEpisode("exampleEpisodeId");
        // can add multiple ids
        assertTrue(client.removeUserSavedEpisodes(client));


    }

    @Test
    void checkUserSavedEpisodes() throws IOException{

        Episode clientEpisodes = client.getEpisode();
        clientEpisodes.addEpisode("exampleEpisodeId");
        assertTrue(client.checkIfUserHasSavedEpisodes(client));

    }

    @Test
    void testGetUserSavedShows() throws IOException{

        assertNotNull(client.getUserSavedShows(client));

    }

    @Test
    void testSaveShowsCurrUser() throws IOException{

        Show show = client.getShow();
        show.addShowId("exampleShowId");
        // can add multiple show ids
        assertTrue(client.saveShowsForCurrentUser(client));

    }

    @Test
    void testRemoveShowsCurrUser() throws IOException{

        Show show = client.getShow();
        show.addShowId("exampleShowId");
        assertTrue(client.removeUserSavedShows(client));

    }

    @Test
    void testCheckCurrUserSavedShows() throws IOException{

        Show show = client.getShow();
        show.addShowId("exampleShowId");
        assertNotNull(client.checkUserHasSavedShows(client));

    }


}
