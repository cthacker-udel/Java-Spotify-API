package getRequests;

import Client.SpotifyClient;
import Controller.BrowseController.Album.BaseAlbum;
import Controller.BrowseController.Categories.BaseCategory;
import Controller.BrowseController.Categories.Category;
import Controller.BrowseController.Playlist.BasePlaylist;
import Controller.BrowseController.Recommendations.BaseRecommendation;
import Controller.BrowseController.Recommendations.RecommendationGenreList;
import org.junit.After;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BrowseTest {

    static SpotifyClient client;

    static {
        try {
            client = new SpotifyClient("d56c8c3f79a1459bba2c286cfa7aa15b", "9dcd475a773d467990dd75eede0af55f");
            Seed seed = client.getSeed();
            seed.addSeedArtist("4NHQUGzhtTLFvgF5SZesLK");
            seed.addSeedTrack("0c6xIDDpzE81m2q797ordA");
            seed.addSeedGenre("hip-hop");
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
    void newReleasesTestCountry() throws IOException {

        Album album = client.getAlbum();
        album.setMarket("US");

        BaseAlbum baseAlbum = client.getAllNewReleases(client);
        assertNotNull(baseAlbum);

    }

    @Test
    void newReleasesTestLimit() throws IOException {

        Album album = client.getAlbum();
        album.setLimit(5);

        BaseAlbum baseAlbum = client.getAllNewReleases(client);
        assertNotNull(baseAlbum);

    }

    @Test
    void newReleasesTestOffset() throws IOException {

        Album album = client.getAlbum();
        album.setOffset(5);

        BaseAlbum baseAlbum = client.getAllNewReleases(client);
        assertNotNull(baseAlbum);

    }

    @Test
    void newReleasesTestCountryOffset() throws IOException {

        Album album = client.getAlbum();
        album.setMarket("US");
        album.setOffset(5);

        BaseAlbum baseAlbum = client.getAllNewReleases(client);
        assertNotNull(baseAlbum);

    }

    @Test
    void newReleasesTestCountryLimit() throws IOException {

        Album album = client.getAlbum();
        album.setMarket("US");
        album.setLimit(5);

        BaseAlbum baseAlbum = client.getAllNewReleases(client);
        assertNotNull(baseAlbum);

    }

    @Test
    void newReleasesTestLimitOffset() throws IOException {

        Album album = client.getAlbum();
        album.setOffset(10);
        album.setLimit(5);

        BaseAlbum baseAlbum = client.getAllNewReleases(client);
        assertNotNull(baseAlbum);

    }

    @Test
    void newReleasesTestCountryLimitOffset() throws IOException {

        Album album = client.getAlbum();
        album.setMarket("US");
        album.setOffset(10);
        album.setLimit(5);

        BaseAlbum baseAlbum = client.getAllNewReleases(client);
        assertNotNull(baseAlbum);

    }


    @Test
    void featuredPlaylistTest() throws IOException{

        Playlist playlist = client.getPlaylist();
        BasePlaylist basePlaylist = client.getAllFeaturedPlaylists(client);
        assertNotNull(playlist);

    }


    @Test
    void featuredPlaylistTestCountry() throws IOException{

        Playlist playlist = client.getPlaylist();
        playlist.setCountry("US");
        BasePlaylist basePlaylist = client.getAllFeaturedPlaylists(client);
        assertNotNull(playlist);

    }

    @Test
    void featuredPlaylistTestLocale() throws IOException{

        Playlist playlist = client.getPlaylist();
        playlist.setLocale("es_MX");

        BasePlaylist basePlaylist = client.getAllFeaturedPlaylists(client);
        assertNotNull(playlist);

    }

    @Test
    void featuredPlaylistTestTimestamp() throws IOException{

        Playlist playlist = client.getPlaylist();
        playlist.setTimestamp(playlist.getCurrentDateISO());

        BasePlaylist basePlaylist = client.getAllFeaturedPlaylists(client);
        assertNotNull(playlist);

    }

    @Test
    void featuredPlaylistTestLimit() throws IOException{

        Playlist playlist = client.getPlaylist();
        playlist.setLimit(5);

        BasePlaylist basePlaylist = client.getAllFeaturedPlaylists(client);
        assertNotNull(playlist);

    }

    @Test
    void featuredPlaylistTestOffset() throws IOException{

        Playlist playlist = client.getPlaylist();
        playlist.setOffset(5);

        BasePlaylist basePlaylist = client.getAllFeaturedPlaylists(client);
        assertNotNull(playlist);

    }

    @Test
    void categoriesTest() throws IOException{

        BaseCategory categories = client.getAllCategories(client);
        assertNotNull(categories);

    }

    @Test
    void categoriesTestCountry() throws IOException{

        getRequests.Category category = client.getCategory();
        category.setCountry("US");
        BaseCategory categories = client.getAllCategories(client);
        assertNotNull(categories);

    }

    @Test
    void categoriesTestLocale() throws IOException{

        getRequests.Category category = client.getCategory();
        category.setLocale("es_MX");
        BaseCategory categories = client.getAllCategories(client);
        assertNotNull(categories);

    }

    @Test
    void categoriesTestLimit() throws IOException{

        getRequests.Category category = client.getCategory();
        category.setLimit(5);
        BaseCategory categories = client.getAllCategories(client);
        assertNotNull(categories);

    }

    @Test
    void categoriesTestOffset() throws IOException{

        getRequests.Category category = client.getCategory();
        category.setOffset(5);
        BaseCategory categories = client.getAllCategories(client);
        assertNotNull(categories);

    }

    @Test
    void singleCategoryTest() throws IOException{

        Category category = client.getSingleCategory(client,"dinner");
        assertNotNull(category);

    }

    @Test
    void singleCategoryTestCountry() throws IOException{

        getRequests.Category category = client.getCategory();
        category.setCountry("US");
        Category singleCategory = client.getSingleCategory(client,"dinner");
        assertNotNull(singleCategory);

    }

    @Test
    void singleCategoryTestLocale() throws IOException{

        getRequests.Category category = client.getCategory();
        category.setLocale("sv_SE");
        Category singleCategory = client.getSingleCategory(client,"dinner");
        assertNotNull(singleCategory);

    }



    @Test
    void categoryPlaylistTest() throws IOException{

        BasePlaylist categoryPlaylists = client.getCategoriesPlaylists(client,"dinner");
        assertNotNull(categoryPlaylists);

    }

    @Test
    void categoryPlaylistTestCountry() throws IOException{

        getRequests.Category category = client.getCategory();
        category.setCountry("US");
        BasePlaylist categoryPlaylists = client.getCategoriesPlaylists(client,"dinner");
        assertNotNull(categoryPlaylists);

    }

    @Test
    void categoryPlaylistTestLimit() throws IOException{

        getRequests.Category category = client.getCategory();
        category.setLimit(5);
        BasePlaylist categoryPlaylists = client.getCategoriesPlaylists(client,"dinner");
        assertNotNull(categoryPlaylists);

    }

    @Test
    void categoryPlaylistTestOffset() throws IOException{

        getRequests.Category category = client.getCategory();
        category.setOffset(10);
        BasePlaylist categoryPlaylists = client.getCategoriesPlaylists(client,"dinner");
        assertNotNull(categoryPlaylists);

    }

    @Test
    void getRecommendations() throws IOException{

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsLimit() throws IOException{

        Seed seed = client.getSeed();
        seed.setLimit(10);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMarket() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMinAcousticness() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMinAcousticness(140.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMaxAcousticness() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMaxAcousticness(200.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsTargetAcousticness() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setTargetAcousticness(1.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMinDanceability() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMinDanceability(1.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMaxDanceability() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMaxDanceability(100.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsTargetDanceability() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMaxDanceability(1.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMinDurationMS() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMinDurationMS(60000);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMaxDurationMS() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMaxDurationMS(60000);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsTargetDurationMS() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setTargetDurationMS(60000);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMinEnergy() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMinEnergy(1.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMaxEnergy() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMaxEnergy(50.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsTargetEnergy() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setTargetEnergy(50.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMinIntrumentalness() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMinInstrumentalness(1.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMaxIntrumentalness() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMaxInstrumentalness(50.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsTargetIntrumentalness() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setTargetInstrumentalness(50.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMinKey() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMinKey(1);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMaxKey() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMaxKey(50);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsTargetKey() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setTargetKey(50);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMinLiveness() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMinLiveness(1.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMaxLiveness() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMaxLiveness(1.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsTargetLiveness() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setTargetLiveness(40.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMinLoudness() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMinLoudness(1.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMaxLoudness() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMaxLoudness(40.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsTargetLoudness() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setTargetLoudness(40.0);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMinMode() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMinMode(4);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsMaxMode() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setMaxMode(4);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void testGetRecommendationsTargetMode() throws IOException{

        Seed seed = client.getSeed();
        seed.setMarket("US");
        seed.setTargetMode(4);

        BaseRecommendation recommendations = client.getRecommendations(client);
        assertNotNull(recommendations);

    }

    @Test
    void getSeedGenres() throws IOException{

        RecommendationGenreList seedGenres = client.getRecommendationGenres(client);
        assertNotNull(seedGenres);

    }


}
