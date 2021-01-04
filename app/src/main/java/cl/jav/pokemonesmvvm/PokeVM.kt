package cl.jav.pokemonesmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PokeVM: ViewModel(){
    val repository = Repository()
   fun getPokemones(): List<Pokemon> {
       return repository.cargarPokemones()

   }
}