package com.example.pokedex.Pokemon

import com.example.pokedex.network.Api
import com.example.pokedex.pokemonList.PokemonResponse

class PokemonRepository {
    private val pokemonService = Api.pokemonListService

    suspend fun refresh(): PokemonResponse? {
        val response = pokemonService.getPokemonSpecies()
        return if (response.isSuccessful) response.body() else null
    }
}