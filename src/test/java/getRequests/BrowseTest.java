package getRequests;

import Client.SpotifyClient;
import Controller.BrowseController.Album.BaseAlbum;
import Controller.BrowseController.Categories.BaseCategory;
import Controller.BrowseController.Categories.Category;
import Controller.BrowseController.Playlist.BasePlaylist;
import Controller.BrowseController.Recommendations.BaseRecommendation;
import Controller.BrowseController.Recommendations.RecommendationGenreList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BrowseTest {

    static SpotifyClient client;

    static {
        try {
            client = new SpotifyClient("d56c8c3f79a1459bba2c286cfa7aa15b", "9dcd475a773d467990dd75eede0af55f");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void newReleasesTest() throws IOException {

        BaseAlbum album = client.getAllNewReleases(client);
        assertNotNull(album);

    }

    @Test
    void featuredPlaylistTest() throws IOException{

        BasePlaylist playlist = client.getAllFeaturedPlaylists(client);
        assertNotNull(playlist);

    }

    @Test
    void categoriesTest() throws IOException{

        BaseCategory categories = client.getAllCategories(client);
        assertNotNull(categories);

    }

    @Test
    void singleCategoryTest() throws IOException{

        Category category = client.getSingleCategory(client,"dinner");
        assertNotNull(category);

    }

    @Test
    void categoryPlaylistTest() throws IOException{

        BasePlaylist categoryPlaylists = client.getCategoriesPlaylists(client,"dinner");
        assertNotNull(categoryPlaylists);

    }

    @Test
    void getRecommendations() throws IOException{

        Seed seed = client.getSeed();
        seed.addSeedArtist("4NHQUGzhtTLFvgF5SZesLK");
        seed.addSeedTrack("0c6xIDDpzE81m2q797ordA");
        seed.addSeedGenre("hip-hop");

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void getSeedGenres() throws IOException{

        RecommendationGenreList seedGenres = client.getRecommendationGenres(client);
        assertNotNull(seedGenres);

    }


}
