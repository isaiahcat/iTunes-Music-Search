# iTunes Music Search
A simple Master-Detail Android Application using search results from iTunes Store API

iTunes API Documentation: https://affiliate.itunes.apple.com/resources/documentation/itunes-storeweb-service-search-api

<p align="center">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/home.gif" width="200">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/details.gif" width="200">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/search.gif" width="200">
</p>

### Architecture
This application uses Model-View-ViewModel (MVVM) architecture with the following package structure
1. data - Data classes for mapping API responses
2. di - Dependency provider modules using Dagger
3. network - Service for accessing API and JSON converter classes
4. ui - All view classes, adapters, and their view models

### Screenshots
<p align="center">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/home.png" width="180">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/search.png" width="180">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/details.png" width="180">
  <img src="https://github.com/jhaiasi/iTunes-Music-Search/blob/dev/screenshots/no-results.png" width="180">
</p>

### Sample JSON key-value pairs used for API consumption
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

### Libraries Used
* [AppCompat](https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat)
    * Backward compatibility
* [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
    * Background operations and handling network calls
* [Dagger](https://dagger.dev/) & [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
    * Dependency injection
* [Glide](https://bumptech.github.io/glide/)
    * Image loading
* [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
    * Reactive UI responding to lifecycle events
* [Navigation](https://developer.android.com/guide/navigation)
    * In-app navigation
* [Retrofit2](https://square.github.io/retrofit/) & [OkHttp3](https://square.github.io/okhttp/)
    * HTTP client for API calls

### Gradle Dependencies
```
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

    testImplementation "junit:junit:$rootProject.junitVersion"
    androidTestImplementation "androidx.test.ext:junit:$rootProject.testExtVersion"
    androidTestImplementation "androidx.test.espresso:espresso-core:$rootProject.testEspressoVersion"
}
```

### References
* [Android MVVM Architecture](https://github.com/MindorksOpenSource/android-mvvm-architecture)
    * A detailed sample app that implements MVVM architecture using Dagger2, Room, RxJava, FastAndroidNetworking, PlaceHolderView and AndroidDebugDatabase
* [Android Sunflower](https://github.com/android/sunflower)
    * A gardening app illustrating Android development best practices with Android Jetpack
* [Plaid](https://github.com/nickbutcher/plaid)
    * A showcase of material design that demonstrates the use of material principles to create tactile, bold, understandable UIs
* [RetrofitKotlinDeferred](https://github.com/navi25/RetrofitKotlinDeferred)
    * Simple to Complex Tutorial for making network calls in Android using Retrofit2, Kotlin and its Deferred Type