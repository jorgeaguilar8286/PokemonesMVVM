package cl.jav.pokemonesmvvm.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.jav.pokemonesmvvm.data.Pokemon
import cl.jav.pokemonesmvvm.data.Repository
import kotlinx.coroutines.launch

class PokeVM : ViewModel(){

    private val repository = Repository()
    init {
        viewModelScope.launch {
            repository.loadPokedex()
        }
    }

   fun getPokemones(): LiveData<List<Pokemon>>{

       return repository.cargarPokemones()

   }

    fun getPokemon(id: String): LiveData<Pokemon> {
        return   repository.getPokemon(id)
    }
}