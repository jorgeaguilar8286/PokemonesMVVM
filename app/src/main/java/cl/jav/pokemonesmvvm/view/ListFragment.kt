package cl.jav.pokemonesmvvm.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.jav.pokemonesmvvm.viewmodel.PokeVM
import cl.jav.pokemonesmvvm.R
import cl.jav.pokemonesmvvm.databinding.FragmentListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class ListFragment : Fragment(), OnItemClickListener {
    private lateinit var adapter: PokeAdapter

    lateinit var binding: FragmentListBinding

    private val pokeVM: PokeVM by viewModels()

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        adapter = PokeAdapter(this)
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        val recyclerView = binding.rvLista
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        pokeVM.getPokemones().observe(viewLifecycleOwner, {
            Log.d("ListFragment", "onCreateView: la lista tiene ${it.size} elementos")
            adapter.updateList(it)
        })
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(id:String) {
     //   Log.d("prueba", "onClick: $id")
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fl_pokemon, DetailFragment.newInstance(id))?.addToBackStack("volver")?.commit()
           }


}
