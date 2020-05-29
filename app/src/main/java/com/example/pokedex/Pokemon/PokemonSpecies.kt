package com.example.pokedex.Pokemon

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class PokemonSpecies(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "url")
    val url: String
): Parcelable, Serializable