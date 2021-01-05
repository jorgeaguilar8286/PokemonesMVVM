package cl.jav.pokemonesmvvm


import androidx.lifecycle.ViewModel

class PokeVM : ViewModel(){

    private val repository = Repository()


   fun getPokemones(): List<Pokemon> {
       return repository.cargarPokemones()

   }

    fun getPokemon(id: String):Pokemon {

       return repository.getPokemon(id)

    }
}