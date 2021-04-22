package getRequests;

import Client.SpotifyClient;
import Client.SpotifyLogin;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeEach;
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

            // DELETE BEFORE PUSHING

            login.setEmailOrUsername("username");
            login.setPassword("passsword");
            login.setRedirectUri("examplecallback");
            login.addScope("user-modify-playback-state");
            login.addScope("user-read-playback-state");
            login.addScope("user-read-currently-playing");
            client.requestAuthCodeFlowCode(client);
            client.generateAccessTokenAndRefreshToken(client);


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    void init(){
        Player clientPlayer = client.getPlayer();
        clientPlayer.clearAllQueries();
    }

    @Test
    void getInfoCurrUserPlayback() throws IOException {

        assertNotNull(client.getInfoCurrentUserPlayback(client));

    }

    @Test
    void getInfoCurrUserPlaybackMarket() throws IOException {

        Player clientPlayer = client.getPlayer();
        clientPlayer.setMarket("US");
        assertNotNull(client.getInfoCurrentUserPlayback(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void getInfoCurrUserPlaybackAdditionalTypes() throws IOException {

        Player clientPlayer = client.getPlayer();
        clientPlayer.getAdditionalTypes().add("track");
        clientPlayer.getAdditionalTypes().add("episode");
        assertNotNull(client.getInfoCurrentUserPlayback(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void getInfoCurrUserPlaybackAdditionalTypesMarket() throws IOException {

        Player clientPlayer = client.getPlayer();
        clientPlayer.setMarket("US");
        clientPlayer.getAdditionalTypes().add("track");
        assertNotNull(client.getInfoCurrentUserPlayback(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testTransferUserPlayback() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.getDeviceIds().add("exampledeviceid");
        assertTrue(client.transferUserPlaybackToNewDevice(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testTransferUserPlaybackPlayTrue() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.getDeviceIds().add("exampledeviceid");
        clientPlayer.setPlay(true);
        assertTrue(client.transferUserPlaybackToNewDevice(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testTransferUserPlaybackPlay() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.getDeviceIds().add("exampledeviceid");
        assertTrue(client.transferUserPlaybackToNewDevice(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testGetUserAvailableDevices() throws IOException{

        assertNotNull(client.getUserAvailableDevices(client));

    }

    @Test
    void getCurrUserPlayingTrack() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setMarket("US");
        assertNotNull(client.getUserCurrentPlayingTrack(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void getCurrUserPlayingTrackMarketAdditionalTypes() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setMarket("US");
        clientPlayer.getAdditionalTypes().add("track");
        assertNotNull(client.getUserCurrentPlayingTrack(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void startResumeUserPlayback() throws IOException{

        assertTrue(client.startOrResumeAUsersPlayback(client));

    }

    @Test
    void startResumeUserPlaybackDeviceId() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setDeviceId("exampledeviceid");
        assertTrue(client.startOrResumeAUsersPlayback(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void startResumeUserPlaybackDeviceIdContextUri() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setDeviceId("exampledeviceid");
        clientPlayer.setContextUri("spotify:album:5ht7ItJgpBH7W6vJ5BqpPr");
        assertTrue(client.startOrResumeAUsersPlayback(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void startResumeUserPlaybackDeviceIdContextUriOffsetPositionMS() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.initializeOffsetObj();
        clientPlayer.setDeviceId("exampledeviceid");
        clientPlayer.setContextUri("spotify:album:5ht7ItJgpBH7W6vJ5BqpPr");
        clientPlayer.getUris().add("spotify:track:4iV5W9uYEdYUVa79Axb7Rh");
        clientPlayer.getOffsetObj().addProperty("position",5);
        clientPlayer.setSeekPosition(2500);
        assertTrue(client.startOrResumeAUsersPlayback(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testPauseUserPlayback() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setDeviceId("exampledeviceid");
        assertTrue(client.pauseUserPlayback(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testSkipUserPlaybackNextTrack() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setDeviceId("exampledeviceid");
        assertTrue(client.skipUserPlaybackToNextTrack(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testSkipUserPlaybackToPreviousTrack() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setDeviceId("exampledeviceid");
        assertTrue(client.skipUserPlaybackToPreviousTrack(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testSeekToPositionInCurrPlayingTrack() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setDeviceId("exampledeviceid");
        clientPlayer.setSeekPosition(25000);
        assertTrue(client.seekToPositionInCurrentUserTrack(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testSetRepeatModeCurrUserPlayback() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setRepeatState("track");
        clientPlayer.setDeviceId("exampledeviceid");
        assertTrue(client.setRepeatModeOnUserPlayback(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testSetVolumeCurrUserPlayback() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setVolume_percent(50);
        clientPlayer.setDeviceId("exampledeviceid");
        assertTrue(client.setVolumeUserPlayback(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testToggleShuffleCurrUserPlayback() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setShuffleState(true);
        clientPlayer.setDeviceId("exampledeviceid");
        assertTrue(client.toggleShuffleForUserPlayback(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testGetCurrUserRecentPlayedTracksAfter() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setLimit(25);
        clientPlayer.setAfter(1484811043);
        assertNotNull(client.getCurrUserRecentPlayedTracks(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testGetCurrUserRecentPlayedTracksBefore() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setLimit(25);
        clientPlayer.setBefore(1484811043);
        assertNotNull(client.getCurrUserRecentPlayedTracks(client));
        clientPlayer.clearAllQueries();

    }

    @Test
    void testAddItemToQueue() throws IOException{

        Player clientPlayer = client.getPlayer();
        clientPlayer.setUri("spotify:track:4iV5W9uYEdYUVa79Axb7Rh");
        clientPlayer.setDeviceId("exampledeviceid");
        assertTrue(client.addItemtoQueue(client));
        clientPlayer.clearAllQueries();

    }




}
