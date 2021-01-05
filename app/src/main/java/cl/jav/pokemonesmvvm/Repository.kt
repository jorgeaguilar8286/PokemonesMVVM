package cl.jav.pokemonesmvvm

class Repository {

    val pokedex= Pokedex()

    fun cargarPokemones(): List<Pokemon> {
       return pokedex.getLista()

    }

    fun getPokemon(id: String?):Pokemon {

        return pokedex.getPokemon(id)
    }


}