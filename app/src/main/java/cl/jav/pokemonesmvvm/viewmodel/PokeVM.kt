package cl.jav.pokemonesmvvm.viewmodel


import androidx.lifecycle.ViewModel
import cl.jav.pokemonesmvvm.data.Pokemon
import cl.jav.pokemonesmvvm.data.Repository

class PokeVM : ViewModel(){

    private val repository = Repository()


   fun getPokemones(): List<Pokemon> {
       return repository.cargarPokemones()

   }

    fun getPokemon(id: String): Pokemon {

       return repository.getPokemon(id)

    }
}