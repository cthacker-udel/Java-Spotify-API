package getRequests;

import Client.SpotifyClient;
import Client.SpotifyLogin;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

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
    void getInfoCurrUserPlayback() throws IOException {

        assertNotNull(client.getInfoCurrentUserPlayback(client));

    }

    @Test
    void testTransferUserPlayback() throws IOException{

        assertTrue(client.transferUserPlaybackToNewDevice(client));

    }

    @Test
    void testGetUserAvailableDevices() throws IOException{

        assertNotNull(client.getUserAvailableDevices(client));

    }

    @Test
    void getCurrUserPlayingTrack() throws IOException{

        assertNotNull(client.getUserCurrentPlayingTrack(client));

    }

    @Test
    void startResumeUserPlayback() throws IOException{


        assertTrue(client.startOrResumeAUsersPlayback(client));

    }

    @Test
    void testPauseUserPlayback() throws IOException{

        assertTrue(client.pauseUserPlayback(client));

    }

    @Test
    void testSkipUserPlaybackNextTrack() throws IOException{


        assertTrue(client.skipUserPlaybackToNextTrack(client));

    }

    @Test
    void testSkipUserPlaybackToPreviousTrack() throws IOException{

        assertTrue(client.skipUserPlaybackToPreviousTrack(client));

    }

    @Test
    void testSeekToPositionInCurrPlayingTrack() throws IOException{

        assertTrue(client.seekToPositionInCurrentUserTrack(client));

    }

    @Test
    void testSetRepeatModeCurrUserPlayback() throws IOException{

        assertTrue(client.setRepeatModeOnUserPlayback(client));

    }

    @Test
    void testSetVolumeCurrUserPlayback() throws IOException{

        assertTrue(client.setVolumeUserPlayback(client));

    }

    @Test
    void testToggleShuffleCurrUserPlayback() throws IOException{

        assertTrue(client.toggleShuffleForUserPlayback(client));

    }

    @Test
    void testGetCurrUserRecentPlayedTracks() throws IOException{

        assertNotNull(client.getCurrUserRecentPlayedTracks(client));

    }

    @Test
    void testAddItemToQueue() throws IOException{

        assertTrue(client.addItemtoQueue(client));

    }




}
