package getRequests;

import Client.SpotifyClient;
import Controller.ArtistController.ArtistAlbum;
import Controller.ArtistController.ArtistTopTrack;
import Controller.ArtistController.BaseArtist;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ArtistTest {

    static SpotifyClient client;

    static {
        try {
            client = new SpotifyClient("d56c8c3f79a1459bba2c286cfa7aa15b","9dcd475a773d467990dd75eede0af55f");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getMultipleArtists() throws IOException {
        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.addArtistId("2GHclqNVjqGuiE5mA7BEoc");
        BaseArtist result = client.getMultipleArtists(client);
        assertNotNull(result);
        client.clearArtists();
    }

    @Test
    void getSingleArtist() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        Controller.ArtistController.Artist result = client.getSingleArtist(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistTopTrack() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        client.setISOCountryCode("US");
        ArtistTopTrack result = client.getArtistsTopTrack(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getRelatedArtists() throws IOException{

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        BaseArtist result = client.getRelatedArtists(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbums() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        ArtistAlbum result = client.getArtistAlbums(client);
        assertNotNull(result);
        client.clearArtists();

    }

}