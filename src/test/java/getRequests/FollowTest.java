package getRequests;

import Client.SpotifyClient;
import Controller.EpisodeController.BaseEpisode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class FollowTest {

    static SpotifyClient client;

    static {
        try {
            client = new SpotifyClient("d56c8c3f79a1459bba2c286cfa7aa15b", "9dcd475a773d467990dd75eede0af55f");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void testFollowAPlaylist() throws IOException {
        Follow follow = client.getFollow();
        follow.setPlayListId("playlist1");
        assertTrue(client.followAPlaylist(client));
    }

    @Test
    void testUnfollowAPlaylist() throws IOException {

        Follow follow = client.getFollow();
        follow.setPlayListId("playlist1");
        assertTrue(client.unfollowPlaylist(client));
    }

    @Test
    void testCheckUserFollowPlaylist() throws IOException{

        Follow follow = client.getFollow();
        User user = client.getUserIds();
        follow.setPlayListId("playlist1");
        user.addUserId("user1");
        assertTrue(client.checkUsersFollowPlaylist(client));

    }

    @Test
    void testGetUsersFollowedArtists() throws IOException{

        User user = client.getUserIds();
        user.setType("type1");
        assertNotNull(client.getUsersArtistsFollowed(client));

    }

    @Test
    void testFollowArtistOrUser() throws IOException{

        User user = client.getUserIds();
        user.setType("type1");
        user.addUserId("user1");
        assertTrue(client.followArtistOrUser(client));

    }


    @Test
    void testUnfollowArtistOrUser() throws IOException{

        User user = client.getUserIds();
        user.clearUserIds();
        user.addUserId("user1");
        user.addUserId("user2");
        user.setType("type2");
        assertTrue(client.unfollowArtistOrUser(client));

    }

    @Test
    void testGetFollowingStateForArtistOrUser() throws IOException {

        User user = client.getUserIds();
        user.clearUserIds();
        user.setType("type3");
        user.addUserId("user1");
        assertTrue(client.getFollwingStateOfUserOrArtist(client));
    }



}

