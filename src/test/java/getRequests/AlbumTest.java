package getRequests;

import Client.SpotifyClient;
import Controller.AlbumController.MultipleAlbums.BaseAlbum;
import Controller.AlbumController.MultipleAlbums.Tracks;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

    static SpotifyClient client;

    static {
        try {
            client = new SpotifyClient("d56c8c3f79a1459bba2c286cfa7aa15b","9dcd475a773d467990dd75eede0af55f");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void makeRequestMultipleAlbums() throws IOException {

        Album theAlbum = new Album();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        theAlbum.addAlbumId("0XFFBEzvJ7Zit24MY5oVV3");
        client.setAlbum(theAlbum);
        BaseAlbum album = client.getMultipleAlbums(client);
        assertNotNull(album);

    }

    @Test
    void makeRequestMultipleAlbumsMarket() throws IOException {

        Album theAlbum = new Album();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        theAlbum.addAlbumId("0XFFBEzvJ7Zit24MY5oVV3");
        theAlbum.setMarket("US");
        client.setAlbum(theAlbum);
        BaseAlbum album = client.getMultipleAlbumsMarket(client);
        assertNotNull(album);

    }

    @Test
    void makeSingleAlbumRequest() throws IOException {

        Album theAlbum = new Album();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        client.setAlbum(theAlbum);
        Controller.AlbumController.MultipleAlbums.Album album = client.getSingleAlbum(client);
        assertNotNull(album);

    }

    @Test
    void makeSingleAlbumRequestMarket() throws IOException {

        Album theAlbum = client.getAlbum();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        theAlbum.setMarket("US");
        Controller.AlbumController.MultipleAlbums.Album album = client.getSingleAlbumMarket(client);
        assertNotNull(album);

    }

    @Test
    void makeTracksRequest() throws IOException {

        Album theAlbum = client.getAlbum();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        Tracks theTracks = client.getAlbumsTracks(client);
        assertNotNull(theTracks);

    }

    @Test
    void makeTracksRequestMarket() throws IOException {

        Album theAlbum = client.getAlbum();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        theAlbum.setMarket("US");
        Tracks theTracks = client.getAlbumsTracks(client);
        assertNotNull(theTracks);

    }

    @Test
    void makeTracksRequestLimit() throws IOException {

        Album theAlbum = client.getAlbum();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        theAlbum.setLimit(10);
        Tracks theTracks = client.getAlbumsTracks(client);
        assertNotNull(theTracks);

    }

    @Test
    void makeTracksRequestOffset() throws IOException {

        Album theAlbum = client.getAlbum();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        theAlbum.setOffset(5);
        Tracks theTracks = client.getAlbumsTracks(client);
        assertNotNull(theTracks);

    }

    @Test
    void makeTracksRequestMarketLimit() throws IOException {

        Album theAlbum = client.getAlbum();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        theAlbum.setMarket("US");
        theAlbum.setLimit(10);
        Tracks theTracks = client.getAlbumsTracks(client);
        assertNotNull(theTracks);

    }

    @Test
    void makeTracksRequestMarketOffset() throws IOException {

        Album theAlbum = client.getAlbum();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        theAlbum.setMarket("US");
        theAlbum.setOffset(5);
        Tracks theTracks = client.getAlbumsTracks(client);
        assertNotNull(theTracks);

    }

    @Test
    void makeTracksRequestLimitOffset() throws IOException {

        Album theAlbum = client.getAlbum();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        theAlbum.setLimit(10);
        theAlbum.setOffset(5);
        Tracks theTracks = client.getAlbumsTracks(client);
        assertNotNull(theTracks);

    }

    @Test
    void makeTracksRequestMarketLimitOffset() throws IOException {

        Album theAlbum = client.getAlbum();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        theAlbum.setMarket("US");
        theAlbum.setLimit(10);
        theAlbum.setOffset(5);
        Tracks theTracks = client.getAlbumsTracks(client);
        assertNotNull(theTracks);

    }


}