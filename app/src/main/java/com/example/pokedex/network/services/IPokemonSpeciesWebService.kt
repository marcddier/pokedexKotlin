package com.example.pokedex.network.services

import com.example.pokedex.Pokemon.PokemonDetail
import com.example.pokedex.pokemonList.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IPokemonSpeciesWebService {
    @GET("pokemon-species")
    suspend fun getPokemonSpecies(): Response<PokemonResponse>

    @GET("pokemon-species/{id}")
    suspend fun getOnePokemonSpecies(@Path("id") id: String): Response<PokemonDetail>
}