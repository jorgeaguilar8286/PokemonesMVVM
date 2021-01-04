package cl.jav.pokemonesmvvm

class Repository {

    val pokedex= Pokedex()

    fun cargarPokemones(): List<Pokemon> {
       return pokedex.getLista()

    }


}