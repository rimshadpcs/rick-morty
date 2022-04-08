package com.rimapps.kotlintuts.network
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@Serializable
@JsonClass(generateAdapter = true)
data class Character (
    @Json(name="id")
    val id: Int,
    @Json(name="name")
    val name: String,
    @Json(name="image")
    val image: String,
    @Json(name="status")
    val status: String,
    @Json(name="species")
    val species: String,
    @Json(name="gender")
    val gender: String
 )
//data class to get the Character results from json
data class CharacterResponse(@Json(name="results")

var result: List<Character>)
