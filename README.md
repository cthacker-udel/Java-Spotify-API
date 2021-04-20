# Public Rest API for Spotify - Cameron Thacker (4/1/2021)

## General API Information

**All information contained within this repository is referenced from the [Spotify Web API Reference website](https://developer.spotify.com/documentation/web-api/reference/)**

* The base http client code is contained within the class called : [Spotify Client](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/main/java/Client/SpotifyClient.java)

* The Rest API methods that interact with the Retrofit interface are located at the class called : [Spotify Rest API](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/main/java/Client/SpotifyRestAPI.java)

* The Interfaces corresponding to section in the Web API Reference are located in the Model folder located here : [Model](https://github.com/cthacker-udel/Java-Spotify-API/tree/master/src/main/java/Model)

* Majority of requests are made via Retrofit interface, only 1 request is made via Selenium, and that is generating the access tokens! The tests listed under [this](https://github.com/cthacker-udel/Java-Spotify-API/tree/master/src/test/java) folder have been tested for functionality, if any functions do not function properly, please raise an issue! Raise an issue [here](https://github.com/cthacker-udel/Java-Spotify-API/issues)

**All additions and recommendations are welcome!**

* Please check the Project Tab for Updates on current objectives

## Project Progress

You can view the progress towards the completion of the Project [here](https://github.com/cthacker-udel/Java-Spotify-API/projects/1)


## Usage

* How to use the Java-Spotify-API wrapper 

Create an instance of `SpotifyClient` by calling the constructors listed in this [file](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/main/java/Client/SpotifyClient.java)

When you create an instance of `SpotifyClient` using the constructors listed above, you can utilize the methods listed in SpotifyRestAPI listed in this [file](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/main/java/Client/SpotifyRestAPI.java)

### **Examples**

---

#### **SpotifyClient**

### [Client package](https://github.com/cthacker-udel/Java-Spotify-API/tree/master/src/main/java/Client) → [SpotifyClient](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/main/java/Client/SpotifyClient.java)

> `SpotifyClient client = new SpotifyClient();` → creates an instance of SpotifyClient with empty API key and Secret Key

> `SpotifyClient client = new SpotifyClient("apikey","secretkey");` → creates an instance of SpotifyClient with API key `"apikey"` and Secret Key `"secretkey"` **recommended usage**

> `SpotifyClient client = new SpotifyClient("apikey","secretkey","accessToken");` → creates an instance of SpotifyClient with API key `"apikey"` and Secret Key `"secretkey"` as well as access token `"accessToken"`

### [Client package](https://github.com/cthacker-udel/Java-Spotify-API/tree/master/src/main/java/Client) → [SpotifyRestAPI](https://github.com/cthacker-udel/Java-Spotify-API/blob/master/src/main/java/Client/SpotifyRestAPI.java)

> For reference on Implementation of SpotifyClient in coordination with SpotifyRestAPI, check the [Test package](https://github.com/cthacker-udel/Java-Spotify-API/tree/master/src/test/java) (**specifically the [getRequests](https://github.com/cthacker-udel/Java-Spotify-API/tree/master/src/test/java/getRequests) package**)
