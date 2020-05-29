package com.example.pokedex.Pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokedex.R

class PokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)
    }

    companion object {
        const val POKEMON_DESC = "pokeDesc"
    }
}
