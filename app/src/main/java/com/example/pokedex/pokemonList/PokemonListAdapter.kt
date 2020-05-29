package com.example.pokedex.pokemonList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.Pokemon.PokemonSpecies
import com.example.pokedex.R
import kotlin.properties.Delegates

class PokemonListAdapter (): RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {

    var onDescClickListener: (PokemonSpecies) -> Unit = {  }

    var list: List<PokemonSpecies> by Delegates.observable(emptyList()) { _,_,_ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class PokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind (pokemon: PokemonSpecies) {
            itemView.findViewById<TextView>(R.id.NameTextView).text = pokemon.name
            itemView.findViewById<TextView>(R.id.UrlTextView).text = pokemon.url
            itemView.findViewById<Button>(R.id.descButton).setOnClickListener { onDescClickListener.invoke(pokemon) }
        }
    }
}