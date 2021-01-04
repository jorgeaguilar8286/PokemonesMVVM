package cl.jav.pokemonesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
Requisitos
1.[x] traer pokedex desde algun proyecto.(1 min) copiar pegar
2.[x] POJOs (1 min) copiar pegar
3.[] Recycleview
4.[] Adapter
5.[] Uso de ViewBinding(gradle)
6.[] Layout (activity
7.[] Activar permisos(internet).
8.[] Room (pojo, dao, dataBase).
9.[maneja datos] Repositorio
10.[] ViewModel
11.[] Fragmentos
 a. [inconclusa] list_fragment
 b. [] detail_fragment
12.[] Glide


----Dependencias y plugin
[] Glide
[] ViewModel
[] ViewBinding
[] Room
[] kotlin-kapt
[] Livedata



*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}