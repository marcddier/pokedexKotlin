package com.example.pokedex.pokemonList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.Pokemon.PokemonDetail
import com.example.pokedex.Pokemon.PokemonRepository
import com.example.pokedex.Pokemon.PokemonSpecies
import kotlinx.coroutines.launch

class PokemonListViewModel: ViewModel() {
    private val _pokemonList = MutableLiveData<List<PokemonSpecies>>()
    val pokemonList: LiveData<List<PokemonSpecies>> = _pokemonList

    private val _pokemonDetail = MutableLiveData<PokemonDetail>()
    val pokemonDetail: LiveData<PokemonDetail> = _pokemonDetail

    private val pokemonRepository = PokemonRepository()

    fun loadPokemonList() {
        viewModelScope.launch {
            pokemonRepository.refresh()?.let {
                _pokemonList.value = it.results
            }
        }
    }

    fun loadPokemonDetail(id: String) {
        viewModelScope.launch {
            pokemonRepository.getOne(id)?.let {
                _pokemonDetail.value = it
            }
        }
    }
}