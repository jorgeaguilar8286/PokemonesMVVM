package cl.jav.pokemonesmvvm


import cl.jav.pokemonesmvvm.data.RoomApplication

class Repository {

    val pokedex= Pokedex()
    val pokeDatabase=RoomApplication.pokeDatabase!!

    init{
        loadPokedex()
    }

   fun loadPokedex(){
       if (isDatabaseempty()) {
           pokeDatabase.daoPokemon().insertPokemon(pokedex.getLista())
       }
   }

    fun isDatabaseempty():Boolean{
        var result=false

        if(pokeDatabase.daoPokemon().countPokemon()==0){
            result=true
        }

        return result
    }


    fun cargarPokemones(): List<Pokemon> {
       return pokeDatabase.daoPokemon().getPokemones()

    }

    fun getPokemon(id: String):Pokemon {

        return pokeDatabase.daoPokemon().getPokemon(id)
    }


}