package com.example.pokedex.network.services

import com.example.pokedex.pokemonList.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface IPokemonSpeciesWebService {
    @GET("pokemon-species")
    suspend fun getPokemonSpecies(): Response<PokemonResponse>
}