package cl.jav.pokemonesmvvm


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.jav.pokemonesmvvm.databinding.ItemListPokemonBinding

class PokeAdapter(pListener:OnItemClickListener) : RecyclerView.Adapter<PokeAdapter.PokeVH>() {
    private val pokeList= mutableListOf<Pokemon>()
    private val listener=pListener
    class PokeVH(itemView: ItemListPokemonBinding): RecyclerView.ViewHolder(itemView.root) {
        val pokename:TextView=itemView.tvNombre

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeAdapter.PokeVH {
        val binding = ItemListPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return PokeVH(binding)
    }

    override fun onBindViewHolder(holder:PokeVH, position: Int) {
        val pokemon=pokeList[position]
        holder.pokename.text=pokemon.name
        holder.pokename.setOnClickListener{
            listener.onClick(pokemon.id)

        }

    }

    override fun getItemCount(): Int {
        return pokeList.size
    }

    fun updateList(pokeListUpdate: List<Pokemon>) {
        pokeList.clear()
        pokeList.addAll(pokeListUpdate)
        Log.d("Adapter", "updateList: la lista en el adapter se ha actualizado con ${pokeList.size} elementos")
        notifyDataSetChanged()

    }
}