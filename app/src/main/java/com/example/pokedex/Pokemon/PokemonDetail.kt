package com.example.pokedex.Pokemon

import com.squareup.moshi.Json

data class PokemonDetail (
    @Json(name = "name")
    val name: String
)