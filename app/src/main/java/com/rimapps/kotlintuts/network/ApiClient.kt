package com.rimapps.kotlintuts.network
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object ApiClient {
private val BASE_URL = "https://rickandmortyapi.com/api/"

    // create a variable for the moshi builder, adding a converter to it

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    /** create instance of retrofit by lazy (lazy is an alternative for lateint)
     * so it can initialized only when it is needed
     * pass the base url and the moshi variable created above
     */
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
// below the object class, create an interface to define how retrofit talks to the service using the get Method

interface ApiService{
    /**
     * need a fetchCharacters method
     * annotate with @Get passing the character path just like in the api
     * above to tell the server send us those characters
     */
    @GET("character")
    //a function fetch Characters with a query , in a page, and call to get the character repsonse
    suspend fun fetchCharacters(@Query("page")page :String):CharacterResponse


}