package cl.jav.pokemonesmvvm.data


import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface DaoPokemon {

 @Insert//cargar toda la lista de pokemones
 suspend fun insertPokemon(pokeList: List<Pokemon>)

 @Query("SELECT * FROM pokemones") //Extraer toda la lista de pokemones
 fun getPokemones(): LiveData<List<Pokemon>>

 @Query("SELECT * FROM pokemones where id=:pId") // Extraer un solo pokemon por id -> En detalle
 fun getPokemon(pId:String): LiveData<Pokemon>

 @Query("SELECT COUNT (*) FROM pokemones" ) // Se cuenta la cantidad total de pokemones
 suspend fun countPokemon():Int

}






