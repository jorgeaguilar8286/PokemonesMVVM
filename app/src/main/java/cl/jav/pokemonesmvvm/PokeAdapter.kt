package cl.jav.pokemonesmvvm

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.jav.pokemonesmvvm.databinding.ItemListPokemonBinding

class PokeAdapter: RecyclerView.Adapter<PokeAdapter.PokeVH>() {
    private val pokeList:List<Pokemon>?=null
    class PokeVH(itemView:ItemListPokemonBinding): RecyclerView.ViewHolder(itemView.root) {
        val pokename:TextView=itemView.tvNombre

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeAdapter.PokeVH {
        val binding = ItemListPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PokeVH(binding)
    }

    override fun onBindViewHolder(holder:PokeVH, position: Int) {
        val lista=pokeList!![position]
        holder.pokename.text=lista.name

    }

    override fun getItemCount(): Int {
        return pokeList?.size ?:0
    }
}