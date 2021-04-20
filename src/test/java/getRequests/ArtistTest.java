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

    @Test
    void getArtistAlbumsIncludeGroups() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsIncludeGroups(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsMarket() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsMarket(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsLimit() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsLimit(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsOffset() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsOffset(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsIncludeGroupsMarket() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsIncludeGroupsMarket(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsIncludeGroupsLimit() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsIncludeGroupsLimit(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsIncludeGroupsOffset() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsIncludeGroupsOffset(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsMarketLimit() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsMarketLimit(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsMarketOffset() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsMarketOffset(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsLimitOffset() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsLimitOffset(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsIncludeGroupsMarketLimit() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsIncludeGroupsMarketLimit(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsIncludeGroupsMarketOffset() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsIncludeGroupsMarketOffset(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsIncludeGroupsLimitOffset() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsIncludeGroupsLimitOffset(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsMarketLimitOffset() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsMarketLimitOffset(client);
        assertNotNull(result);
        client.clearArtists();

    }

    @Test
    void getArtistAlbumsIncludeGroupsMarketLimitOffset() throws IOException {

        Artist artists = client.getArtists();
        artists.addArtistId("0Mz5XE0kb1GBnbLQm2VbcO");
        artists.getIncludeGroups().add("album");
        artists.getIncludeGroups().add("single");
        artists.setMarket("US");
        artists.setLimit(2);
        artists.setOffset(5);
        ArtistAlbum result = client.getArtistAlbumsIncludeGroupsMarketLimitOffset(client);
        assertNotNull(result);
        client.clearArtists();

    }

}