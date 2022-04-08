package com.rimapps.kotlintuts

import com.rimapps.kotlintuts.network.ApiService

/**
 *Repository is a class which purpose is to provide a clean API for accessing data.
 *  What that means is that the Repository can gather data from different data sources
 *  (different REST APIs, cache, local database storage)
 *  and it provides this data to the rest of the app.
 * */

class Repository(private val apiService: ApiService){

    suspend fun getCharacters(page:String) = apiService.fetchCharacters(page)

}
