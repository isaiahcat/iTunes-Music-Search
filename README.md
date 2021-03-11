# iTunes Music Search
A simple Master-Detail Android Application using search results from iTunes Store API

iTunes API Documentation: [https://affiliate.itunes.apple.com/res/doc/itunes-search-api](https://affiliate.itunes.apple.com/resources/documentation/itunes-storeweb-service-search-api)

Download [APK]()

## Overview
Users are able to use the application to do the following
* Search for music using keywords
* View track details from the results
* Go to the iTunes website for song, artist, or collection details

<p align="center">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/home.gif" width="200">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/details.gif" width="200">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/search.gif" width="200">
</p>

## Architecture
This application uses Model-View-ViewModel (MVVM) architecture with the following package structure
1. [data](https://github.com/jhaiasi/iTunes-Music-Search/tree/dev/app/src/main/java/com/jhaiasi/itunesmusicsearch/data) - Data classes for mapping API responses, type converters, and database management classes
2. [di](https://github.com/jhaiasi/iTunes-Music-Search/tree/dev/app/src/main/java/com/jhaiasi/itunesmusicsearch/di) - Dependency provider modules using Dagger
3. [network](https://github.com/jhaiasi/iTunes-Music-Search/tree/dev/app/src/main/java/com/jhaiasi/itunesmusicsearch/network) - Service for accessing API
4. [ui](https://github.com/jhaiasi/iTunes-Music-Search/tree/dev/app/src/main/java/com/jhaiasi/itunesmusicsearch/ui) - View classes, adapters, and their respective view models

### Screenshots
<p align="center">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/home.png" width="160">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/search.png" width="160">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/details.png" width="160">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/no-results.png" width="160">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/explicit.png" width="160">
</p>

### Data Persistence
The user's last search results and the date and time of when that search occurred are retained so that the user can tell how up to date the data is the next time they return to the app.

The list of music tracks was retained using [Room](https://developer.android.com/jetpack/androidx/releases/room) which was chosen for good synergy with the other Jetpack components and the date and time of when the last search occurred was retained using [SharedPreferences](https://developer.android.com/reference/android/content/SharedPreferences) which was chosen because it's very straightforward and easy to use for primitive data types with it's key/value pairs.

### Sample JSON key-value pairs used for API consumption
```json
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

## Libraries Used
* [Android KTX](https://developer.android.com/kotlin/ktx) - Kotlin extensions for more concise code
* [AppCompat](https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat) - Backward compatibility
* [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) - Background operations and handling network calls
* [Dagger](https://dagger.dev/) & [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Dependency injection
* [Glide](https://bumptech.github.io/glide/) - Image loading
* [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Reactive UI that responds to lifecycle events
* [Navigation](https://developer.android.com/guide/navigation) with [SafeArgs](https://developer.android.com/jetpack/androidx/releases/navigation#safe_args) - In-app navigation
* [Retrofit](https://square.github.io/retrofit/) & [OkHttp](https://square.github.io/okhttp/) - HTTP client for API calls
    * Note that versions [2.6.4](https://github.com/square/retrofit/blob/master/CHANGELOG.md#version-264-2020-01-02) and [3.12.13](https://square.github.io/okhttp/changelog_3x/#version-31213) were used because [later versions do not support Android 4.4](https://github.com/square/okhttp/issues/4481)
    * See [Retrofit 2.7.0 changelog](https://github.com/square/retrofit/blob/master/CHANGELOG.md#version-270-2019-12-09) and [OkHttp 3.13.0 changelog](https://square.github.io/okhttp/changelog_3x/#version-3130) for details
* [SharedPreferences](https://developer.android.com/reference/android/content/SharedPreferences) and [Room](https://developer.android.com/jetpack/androidx/releases/room) - Data persistence

### Gradle Dependencies
```kotlin
// build.gradle(Module: app)
dependencies {

    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    implementation "androidx.core:core-ktx:$rootProject.ktxVersion"
    implementation "androidx.appcompat:appcompat:$rootProject.appCompatVersion"
    implementation "androidx.hilt:hilt-lifecycle-viewmodel:$rootProject.hiltViewModelVersion"
    implementation "androidx.lifecycle:lifecycle-extensions:$rootProject.lifecycleVersion"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$rootProject.lifecycleVersion"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$rootProject.lifecycleVersion"
    implementation "androidx.navigation:navigation-fragment-ktx:$rootProject.navigationVersion"
    implementation "androidx.navigation:navigation-ui-ktx:$rootProject.navigationVersion"
    implementation "com.google.android.material:material:$rootProject.materialVersion"

    //Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$rootProject.coroutineVersion"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$rootProject.coroutineVersion"

    //Dagger
    implementation "com.google.dagger:hilt-android:$rootProject.hiltVersion"
    compileOnly "com.squareup.inject:assisted-inject-annotations-dagger2:$rootProject.daggerVersion"
    kapt "com.squareup.inject:assisted-inject-processor-dagger2:$rootProject.daggerVersion"
    kapt "com.google.dagger:hilt-android-compiler:$rootProject.hiltVersion"
    kapt "androidx.hilt:hilt-compiler:$rootProject.hiltViewModelVersion"

    //Glide
    implementation "com.github.bumptech.glide:glide:$rootProject.glideVersion"

    //Retrofit2
    implementation "com.squareup.retrofit2:retrofit:$rootProject.retrofitVersion"
    implementation "com.squareup.retrofit2:converter-moshi:$rootProject.retrofitVersion"
    implementation "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$rootProject.retrofitCoroutineAdapterVersion"

    //Okhttp3
    implementation "com.squareup.okhttp3:okhttp:$rootProject.okhttpVersion"
    implementation "com.squareup.okhttp3:logging-interceptor:$rootProject.okhttpVersion"

    //Room
    implementation "androidx.room:room-runtime:$rootProject.roomVersion"
    implementation "androidx.room:room-ktx:$rootProject.roomVersion"
    kapt "androidx.room:room-compiler:$rootProject.roomVersion"

    testImplementation "junit:junit:$rootProject.junitVersion"
    androidTestImplementation "androidx.test.ext:junit:$rootProject.testExtVersion"
    androidTestImplementation "androidx.test.espresso:espresso-core:$rootProject.testEspressoVersion"
}
```

### References
* [Android MVVM Architecture](https://github.com/MindorksOpenSource/android-mvvm-architecture) - Detailed sample app that implements MVVM architecture using Dagger2, Room, RxJava, FastAndroidNetworking, PlaceHolderView and AndroidDebugDatabase
* [Android Sunflower](https://github.com/android/sunflower) - Gardening app illustrating Android development best practices with Android Jetpack
* [Plaid](https://github.com/nickbutcher/plaid) - Showcase of material design that demonstrates the use of material principles to create tactile, bold, understandable UIs
* [RetrofitKotlinDeferred](https://github.com/navi25/RetrofitKotlinDeferred) - Simple to Complex Tutorial for making network calls in Android using Retrofit2, Kotlin and its Deferred Type

### License
```
   Copyright 2021 ISAIAH CATIMPO

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```