package cl.jav.pokemonesmvvm.data

import android.util.Log
import cl.jav.pokemonesmvvm.data.Pokedex
import cl.jav.pokemonesmvvm.data.Pokemon


class Repository {

    val pokedex = Pokedex()
    val pokeDatabase = PokeDatabase.RoomApplication.pokeDatabase!!


    init {
        loadPokedex()
    }

    fun loadPokedex() {
        if (isDatabaseempty()) {
            Log.d("Repository", "Creando información de pokemones")
            pokeDatabase.daoPokemon().insertPokemon(pokedex.getLista())
        }
    }

    fun isDatabaseempty(): Boolean {
        var result = false

        if (pokeDatabase.daoPokemon().countPokemon() == 0) {
            result = true
        }

        return result
    }


    fun cargarPokemones(): List<Pokemon> {
        return pokeDatabase.daoPokemon().getPokemones()
    }

    fun getPokemon(id: String): Pokemon {

        return pokeDatabase.daoPokemon().getPokemon(id)
    }
}