# Public Rest API for Spotify - Cameron Thacker (4/1/2021)

![Version](https://img.shields.io/badge/version-2.0.0-blue)
![dependencies](https://img.shields.io/badge/dependencies-up%20to%20date-brightgreen)
![Retrofit](https://img.shields.io/badge/retrofit-2.7.2-green)
![Gson](https://img.shields.io/badge/gson-2.9.0-green)
![Selenium](https://img.shields.io/badge/selenium-4.0.0-green)
![WebdriverManager](https://img.shields.io/badge/WebdriverManager-3.7.1-green)

![GitHub stars](https://img.shields.io/github/stars/cthacker-udel/Java-Spotify-API?style=social&label=Star)
## General API Information

**All information contained within this repository is referenced from the [Spotify Web API Reference website](https://developer.spotify.com/documentation/web-api/reference/)**

* The base http client code is contained within the class called : [Spotify Client](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/main/java/Client/SpotifyClient.java)

* The Rest API methods that interact with the [Retrofit](https://square.github.io/retrofit/) interface are located at the class called : [Spotify Rest API](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/main/java/Client/SpotifyRestAPI.java)

* The Interfaces corresponding to section in the Web API Reference are located in the Model folder located here : [Model](https://github.com/cthacker-udel/Java-Spotify-API/tree/master/src/main/java/Model)

* Majority of requests are made via [Retrofit](https://square.github.io/retrofit/) interface, only 1 request is made via [Selenium](https://www.selenium.dev/documentation/en/), and that is generating the access tokens! The tests listed under [this](https://github.com/cthacker-udel/Java-Spotify-API/tree/master/src/test/java) folder have been tested for functionality, if any functions do not function properly, please raise an issue! Raise an issue [here](https://github.com/cthacker-udel/Java-Spotify-API/issues/new)

**All additions and recommendations are welcome!**

* Please check the Project Tab for Updates on current objectives


## Usage

* How to use the Java-Spotify-API wrapper 
  * Create an instance of `SpotifyClient` by calling the constructors listed in this [file](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/main/java/Client/SpotifyClient.java)
  * When you create an instance of `SpotifyClient` using the constructors listed above, you can utilize the methods listed in `SpotifyRestAPI` listed in this [file](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/main/java/Client/SpotifyRestAPI.java)


## Examples


### [SpotifyClient](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/main/java/Client/SpotifyClient.java)

* `SpotifyClient client = new SpotifyClient();` 
  * creates an instance of SpotifyClient with empty API key and Secret Key

* `SpotifyClient client = new SpotifyClient("apikey","secretkey");` 
  * creates an instance of SpotifyClient with API key `"apikey"` and Secret Key `"secretkey"` **recommended usage**

* `SpotifyClient client = new SpotifyClient("apikey","secretkey","accessToken");` 
  * creates an instance of SpotifyClient with API key `"apikey"` and Secret Key `"secretkey"` as well as access token `"accessToken"`

---

### [SpotifyRestAPI](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/main/java/Client/SpotifyRestAPI.java)

 * For reference on Implementation of SpotifyClient in coordination with SpotifyRestAPI, check the [Test package](https://github.com/cthacker-udel/Java-Spotify-API/tree/master/src/test/java) (**specifically the [getRequests](https://github.com/cthacker-udel/Java-Spotify-API/tree/master/src/test/java/getRequests) package**)

---

### [Oauth Methods](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/test/java/Client/SpotifyRestAPITest.java)


**Step 1** : Create an instance of SpotifyClient, follow the steps under the SpotifyClient Section

**Step 2** : Add username or email,password,and this redirect uri: `http://localhost:8888/callback/` and add these values by acquiring an instance of the Spotify Login by using the method `client.getLogin();`, and using the appropriate methods outlined:

* `setEmailOrUsername(String usernameoremail);` 
  * sets your email or username for acquiring access token

* `setPassword(String password)`
  * sets your password for logging into spotify to acquire token

* `setRedirectUri(String redirectUri);`
  * sets your redirect uri for acquiring the token

**Step 3** : Acquire the access token by calling the method `client.requestAuthCodeFlowCode(SpotifyClient client);`

---

### [Album API Methods](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/test/java/getRequests/AlbumTest.java)


**Step 1** : Access Album Instance by the method `getAlbum()` available with your SpotifyClient instance

**Step 2** : Access the methods in the album instance, such as *addAlbumId*, and the setter and getters for individual query options for each request, all parameters are supplied in the tests file, under each type of request.

--- 

### [Artist API Methods](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/test/java/getRequests/ArtistTest.java)

**Step 1** : Access Artist Instance by the method `getArtists()` available with your SpotifyClient instance

**Step 2** : Access the methods in the artist interface, such as *addArtistId*, and the setter and getters for individual query parameters, all query parameters are supplied in the tests file, under each type of request.

---

### [Browse API Methods](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/test/java/getRequests/BrowseTest.java)

**Step 1**
  * Access browse seed instance by utilizing the method `.getSeed()` with your SpotifyClient instance
    * Once the seed instance has been created, add Artist, Track IDs by utilizing the method `.addSeedArtist("ID")` and `.addSeedTrack("ID")`, and also adding the genre name (as a String) with the method `.addSeedGenre(String genreName)`

**Step 2**
  * Once the seed has been given values for either artist, track, or genre, observe which instances need to be utilized for individual method calls by referencing this file : [BrowseTest.java](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/test/java/getRequests/BrowseTest.java)
