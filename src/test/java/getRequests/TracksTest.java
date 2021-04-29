package getRequests;

import Client.SpotifyClient;
import Client.SpotifyLogin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TracksTest {

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
        Track clientTrack = client.getTrackIds();
        clientTrack.clearQueryParams();
    }

    @Test
    void testGetSeveralTracks() throws IOException{
        Track clientTrack = client.getTrackIds();
        clientTrack.addTrackId("3n3Ppam7vgaVa1iaRUc9Lp");
        clientTrack.addTrackId("3twNvmDtFQtAd5gMKedhLD");
        clientTrack.setMarket("ES");
        assertNotNull(client.getMultipleTracks(client));

    }

    @Test
    void testGetSpecificTrack() throws IOException{
        Track clientTrack = client.getTrackIds();
        clientTrack.addTrackId("3n3Ppam7vgaVa1iaRUc9Lp");
        clientTrack.addTrackId("3twNvmDtFQtAd5gMKedhLD");
        clientTrack.setMarket("ES");
        assertNotNull(client.getTrack(client));

    }

    @Test
    void testGetAudioFeaturesOfMultipleTracks() throws IOException{
        Track clientTrack = client.getTrackIds();
        clientTrack.addTrackId("3n3Ppam7vgaVa1iaRUc9Lp");
        clientTrack.addTrackId("3twNvmDtFQtAd5gMKedhLD");
        assertNotNull(client.getAudioFeaturesForSeveralTracks(client));

    }

    @Test
    void testGetAudioFeaturesOfTrack() throws IOException{
        Track clientTrack = client.getTrackIds();
        clientTrack.addTrackId("3n3Ppam7vgaVa1iaRUc9Lp");
        clientTrack.addTrackId("3twNvmDtFQtAd5gMKedhLD");
        assertNotNull(client.getTrackAudioFeature(client));

    }

    @Test
    void testGetAudioAnalysisOfTrack() throws IOException{
        Track clientTrack = client.getTrackIds();
        clientTrack.addTrackId("3n3Ppam7vgaVa1iaRUc9Lp");
        clientTrack.addTrackId("3twNvmDtFQtAd5gMKedhLD");
        assertNotNull(client.getTrackAudioAnalysis(client));

    }

}
