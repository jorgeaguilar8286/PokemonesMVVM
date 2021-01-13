package cl.jav.pokemonesmvvm.data

import android.app.Application
import androidx.room.*
import androidx.room.Dao
import androidx.room.Room.databaseBuilder

@Dao
interface DaoPokemon {

 @Insert//cargar toda la lista de pokemones
 fun insertPokemon(pokeList: List<Pokemon>)

 @Query("SELECT * FROM pokemones") //Extraer toda la lista de pokemones
 fun getPokemones():List<Pokemon>

 @Query("SELECT * FROM pokemones where id=:pId") // Extraer un pokemon por id
 fun getPokemon(pId:String): Pokemon

 @Query("SELECT COUNT (*) FROM pokemones" ) // Extraer un pokemon por id
 fun countPokemon():Int

}






