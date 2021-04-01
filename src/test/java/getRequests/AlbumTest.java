package getRequests;

import Client.SpotifyClient;
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
        client.getMultipleAlbums(client.getAlbum());


    }


}