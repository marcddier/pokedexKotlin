package com.example.pokedex.pokemonList

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.Pokemon.PokemonActivity
import com.example.pokedex.Pokemon.PokemonSpecies

import com.example.pokedex.R
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import java.io.Serializable

class PokemonListFragment : Fragment() {
    private val adapter = PokemonListAdapter()

    private val viewModel by lazy {
        ViewModelProvider(this).get(PokemonListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(activity)

        adapter.onDescClickListener = {
            val intent = Intent(activity, PokemonActivity::class.java)
            intent.putExtra("infoPokemon", it as Serializable)
            startActivityForResult(intent, KEY_POKEMON_DESC)
        }

        viewModel.pokemonList.observe(this, androidx.lifecycle.Observer { newList ->
            adapter.list = newList.orEmpty()
        })
    }

    override fun onResume() {
        super.onResume()

        viewModel.loadPokemon()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val pokemon = data!!.getSerializableExtra(PokemonActivity.POKEMON_DESC) as PokemonSpecies
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == KEY_POKEMON_DESC) {
            if (resultCode == Activity.RESULT_OK) {
                recyclerview.adapter?.notifyDataSetChanged()
            }
        }
    }

    companion object {
        const val KEY_POKEMON_DESC = 200
    }
}
