# iTunes Music Search
A simple Master-Detail Android Application using search results from iTunes Store API
[![iTunes Store API](https://i.pinimg.com/736x/cc/c7/de/ccc7dec767c1bd757eaaf0f4e6a8569e.jpg)](https://affiliate.itunes.apple.com/resources/documentation/itunes-storeweb-service-search-api)

### Screenshots
<p align="center">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/home.png" width="100">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/search.png" width="100">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/details.png" width="100">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/home.gif" width="100">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/details.gif" width="100">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/search.gif" width="100">
</p>

### Sample JSON
```
{
    "trackId": 1440857797,
    "trackName": "Good People",
    "artistName": "Jack Johnson",
    "collectionName": "In Between Dreams (Bonus Track Version)",
    "trackPrice": 1.29,
    "trackExplicitness": "notExplicit",
    "trackTimeMillis": 208509,
    "trackViewUrl": "https://music.apple.com/us/album/good-people/1440857781?i=1440857797&uo=4",
    "artistViewUrl": "https://music.apple.com/us/artist/jack-johnson/909253?uo=4",
    "collectionViewUrl": "https://music.apple.com/us/album/good-people/1440857781?i=1440857797&uo=4",
    "artworkUrl100": "https://is2-ssl.mzstatic.com/image/thumb/Music118/v4/24/46/97/24469731-f56f-29f6-67bd-53438f59ebcb/source/100x100bb.jpg",
    "collectionPrice": 11.99,
    "currency": "USD",
    "releaseDate": "2005-03-01T12:00:00Z",
    "primaryGenreName": "Rock"
}
```

### Architecture
This application is implemented with MVVM architecture

### Libraries Used
*
*
*
* [Glide](https://bumptech.github.io/glide/)
    * Image loading

Navigation
Retrofit2
OkHttp3
Dagger
Hilt

### References
* [Android MVVM Architecture](https://github.com/MindorksOpenSource/android-mvvm-architecture)
    * A detailed sample app that implements MVVM architecture using Dagger2, Room, RxJava, FastAndroidNetworking, PlaceHolderView and AndroidDebugDatabase
* [Android Sunflower](https://github.com/android/sunflower)
    * A gardening app illustrating Android development best practices with Android Jetpack
* [Plaid](https://github.com/nickbutcher/plaid)
    * Plaid is a showcase of material design that demonstrates the use of material principles to create tactile, bold, understandable UIs
* [RetrofitKotlinDeferred](https://github.com/navi25/RetrofitKotlinDeferred)
    * Simple to Complex Tutorial for making network calls in Android using Retrofit2, Kotlin and its Deferred Type