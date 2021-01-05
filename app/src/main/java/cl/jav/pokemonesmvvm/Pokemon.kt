package cl.jav.pokemonesmvvm


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "pokemones")
data class Pokemon(
    @PrimaryKey val id: String,
    val img: String,
    val name: String,
    val types: List<String>
)


class Converter {
    @TypeConverter
    fun convertStringtoList(lista: String): List<String> {

        return lista.split(",")
    }

    @TypeConverter
    fun convertListtoString(lista: List<String>): String {

        return lista.joinToString { "," }
    }
}
