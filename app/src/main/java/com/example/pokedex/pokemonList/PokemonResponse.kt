package com.example.pokedex.pokemonList

import com.example.pokedex.Pokemon.PokemonSpecies
import com.squareup.moshi.Json

data class PokemonResponse (
    @Json(name = "count")
    val count: Int,
    @Json(name = "next")
    val next: String,
    @Json(name = "previous")
    val previous: String,
    @Json(name = "results")
    val results: List<PokemonSpecies>
)