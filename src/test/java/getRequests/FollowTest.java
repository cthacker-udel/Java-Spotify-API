package getRequests;

import Client.SpotifyClient;
import Client.SpotifyLogin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class FollowTest {

    static SpotifyClient client;

    static {
        try {
            client = new SpotifyClient("d56c8c3f79a1459bba2c286cfa7aa15b", "9dcd475a773d467990dd75eede0af55f");
            /*

            ------------------------------

            DELETE THIS AFTERWARDS

            ------------------------------


             */
            SpotifyLogin login = client.getLogin();
            login.setEmailOrUsername("defaultUsername");
            login.setPassword("defaultPassword");
            login.setRedirectUri("defaultRedirectUri");
            login.addScope("playlist-modify-public");
            login.addScope("playlist-modify-private");
            client.requestAuthCodeFlowCode(client);
            client.generateAccessTokenAndRefreshToken(client);


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    void testFollowAPlaylist() throws IOException {
        Follow follow = client.getFollow();
        follow.setPlayListId("2v3iNvBX8Ay1Gt2uXtUKUT");
        assertTrue(client.followAPlaylist(client));
    }

    @Test
    void testFollowAPlaylistFalse() throws IOException {
        Follow follow = client.getFollow();
        follow.setPublic(false);
        follow.setPlayListId("2v3iNvBX8Ay1Gt2uXtUKUT");
        assertTrue(client.followAPlaylist(client));
    }

    @Test
    void testUnfollowAPlaylist() throws IOException {

        Follow follow = client.getFollow();
        follow.setPlayListId("2v3iNvBX8Ay1Gt2uXtUKUT");
        assertTrue(client.unfollowPlaylist(client));
    }

    @Test
    void testCheckUserFollowPlaylist() throws IOException{

        Follow follow = client.getFollow();
        User user = client.getUser();
        follow.setPlayListId("2v3iNvBX8Ay1Gt2uXtUKUT");
        user.addUserId("possan");
        assertTrue(client.checkUsersFollowPlaylist(client));

    }

    @Test
    void testGetUsersFollowedArtists() throws IOException{

        User user = client.getUser();
        user.setType("artist");
        Follow follow = client.getFollow();
        follow.setAfter("0I2XqVXqHScXjHhk6AYYRe");
        follow.setLimit(20);
        assertNotNull(client.getUsersArtistsFollowed(client));

    }

    @Test
    void testFollowArtist() throws IOException{

        User user = client.getUser();
        user.setType("artist");
        user.addUserId("6SWohEYYTym0RIBxvoh6wt");
        assertTrue(client.followArtistOrUser(client));

    }

    @Test
    void testFollowUser() throws IOException{

        User user = client.getUser();
        user.setType("user");
        user.addUserId("6SWohEYYTym0RIBxvoh6wt");
        assertTrue(client.followArtistOrUser(client));

    }


    @Test
    void testUnfollowArtist() throws IOException{

        User user = client.getUser();
        user.clearUserIds();
        user.addUserId("6SWohEYYTym0RIBxvoh6wt");
        user.setType("artist");
        assertTrue(client.unfollowArtistOrUser(client));

    }

    @Test
    void testUnfollowArtistOrUser() throws IOException{

        User user = client.getUser();
        user.clearUserIds();
        user.addUserId("6SWohEYYTym0RIBxvoh6wt");
        user.setType("user");
        assertTrue(client.unfollowArtistOrUser(client));

    }

    @Test
    void testGetFollowingStateForArtist() throws IOException {

        User user = client.getUser();
        user.clearUserIds();
        user.setType("artist");
        user.addUserId("6SWohEYYTym0RIBxvoh6wt");
        assertTrue(client.getFollwingStateOfUserOrArtist(client));
    }

    @Test
    void testGetFollowingStateForUser() throws IOException {

        User user = client.getUser();
        user.clearUserIds();
        user.setType("user");
        user.addUserId("6SWohEYYTym0RIBxvoh6wt");
        assertTrue(client.getFollwingStateOfUserOrArtist(client));
    }



}

