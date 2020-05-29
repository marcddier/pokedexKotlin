package com.example.pokedex.Pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.R
import com.example.pokedex.pokemonList.PokemonListViewModel
import kotlinx.android.synthetic.main.activity_pokemon.*
import kotlinx.android.synthetic.main.item_pokemon.*
import kotlin.properties.Delegates

class PokemonActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(PokemonListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

        val infoPokemon = intent.getSerializableExtra("infoPokemon") as PokemonSpecies
        val pokemonUrl: List<String> = infoPokemon.url.split('/')
        val idPokemon: String = pokemonUrl[pokemonUrl.size - 2]

        viewModel.loadPokemonDetail(idPokemon)

        viewModel.pokemonDetail.observe(this, androidx.lifecycle.Observer { pokeDetail ->
            findViewById<TextView>(R.id.nameDetailTextView).text = pokeDetail.name
        })
    }

    companion object {
        const val POKEMON_DESC = "pokeDesc"
    }
}
