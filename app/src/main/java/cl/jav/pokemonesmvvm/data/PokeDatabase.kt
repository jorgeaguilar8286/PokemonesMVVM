package cl.jav.pokemonesmvvm.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities= [Pokemon::class],version=1)
@TypeConverters(Converter::class)
abstract class PokeDatabase : RoomDatabase() {


    abstract fun daoPokemon(): DaoPokemon


    class RoomApplication : Application() {
        companion object {
            var pokeDatabase: PokeDatabase? = null
        }


        override fun onCreate() {
            super.onCreate()

            pokeDatabase = Room.databaseBuilder(this, PokeDatabase::class.java,
                    "pokemones").build()
        }
    }
}
