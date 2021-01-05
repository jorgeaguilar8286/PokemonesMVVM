package cl.jav.pokemonesmvvm.data

import android.app.Application
import androidx.room.*
import androidx.room.Room.databaseBuilder

import cl.jav.pokemonesmvvm.Converters
import cl.jav.pokemonesmvvm.Pokemon

@Dao
interface DaoPokemon {

 @Insert//cargar toda la lista de pokemones
 fun insertPokemon(pokeList: List<Pokemon>)

 @Query("SELECT * FROM pokemones") //Extraer toda la lista de pokemones
 fun getPokemones():List<Pokemon>

 @Query("SELECT * FROM pokemones where id=:pId") // Extraer un pokemon por id
 fun getPokemon(pId:String):Pokemon

 @Query("SELECT COUNT (*) FROM pokemones" ) // Extraer un pokemon por id
 fun countPokemon():Int

}
@Database(entities= [Pokemon::class],version=1)
@TypeConverters(Converters::class)
abstract class PokeDatabase : RoomDatabase() {
 abstract fun daoPokemon(): DaoPokemon
}


  class RoomApplication : Application() {
   companion object {
    var pokeDatabase: PokeDatabase? = null
   }



   override fun onCreate() {
    super.onCreate()

    pokeDatabase = databaseBuilder(this,PokeDatabase::class.java,
      "pokemones").allowMainThreadQueries().build()
   }
  }






