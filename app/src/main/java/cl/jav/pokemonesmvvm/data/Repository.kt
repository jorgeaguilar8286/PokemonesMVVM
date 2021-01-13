package cl.jav.pokemonesmvvm.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.jav.pokemonesmvvm.data.Pokedex
import cl.jav.pokemonesmvvm.data.Pokemon


class Repository {

    val pokedex = Pokedex()
    val pokeDatabase = PokeDatabase.RoomApplication.pokeDatabase!!



    suspend fun loadPokedex() {
        if (isDatabaseempty()) {
            Log.d("Repository", "Creando información de pokemones")
            pokeDatabase.daoPokemon().insertPokemon(pokedex.getLista())
        } else {
            Log.d("Repository", "La base de datos no está vacía")
        }
    }

    private suspend fun isDatabaseempty(): Boolean {
        var result = false

        if (pokeDatabase.daoPokemon().countPokemon() == 0) {
            result = true
        }

        return result
    }


    fun cargarPokemones(): LiveData<List<Pokemon>> {
        return pokeDatabase.daoPokemon().getPokemones()
    }

    fun getPokemon(id: String): LiveData<Pokemon> {

        return pokeDatabase.daoPokemon().getPokemon(id)
    }
}