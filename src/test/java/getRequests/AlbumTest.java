package getRequests;

import Client.SpotifyClient;
import Controller.AlbumController.MultipleAlbums.BaseAlbum;
import Controller.AlbumController.MultipleAlbums.Tracks;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

    @Test
    void makeRequestMultipleAlbums() throws IOException {

        Album theAlbum = new Album();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        theAlbum.addAlbumId("0XFFBEzvJ7Zit24MY5oVV3");
        SpotifyClient client = new SpotifyClient("","","",theAlbum);
        BaseAlbum album = client.getMultipleAlbums(client.getAlbum());
        assertNotNull(album);

    }

    @Test
    void makeSingleAlbumRequest() throws IOException {

        Album theAlbum = new Album();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        SpotifyClient client = new SpotifyClient("","","",theAlbum);
        Controller.AlbumController.MultipleAlbums.Album album = client.getSingleAlbum(client,theAlbum);
        assertNotNull(album);

    }

    @Test
    void makeTracksRequest() throws IOException {

        Album theAlbum = new Album();
        theAlbum.addAlbumId("2UuvBxV56QWWj2uviGS0up");
        SpotifyClient client = new SpotifyClient("","","",theAlbum);
        Tracks theTracks = client.getAlbumsTracks(client,theAlbum.getAlbumIds().get(0));
        assertNotNull(theTracks);

    }


}