package cl.jav.pokemonesmvvm.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import cl.jav.pokemonesmvvm.viewmodel.PokeVM
import cl.jav.pokemonesmvvm.databinding.FragmentDetailBinding
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    private var param1 = ""
    private lateinit var binding:FragmentDetailBinding
    private val pokeVM: PokeVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1).toString()

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate t layout for this fragment
        binding= FragmentDetailBinding.inflate(inflater,container,false)
        pokeVM.getPokemon(param1).observe(viewLifecycleOwner, {pokemon ->
            binding.tvId.text= pokemon.id
            binding.tvNamedetail.text= pokemon.name
            binding.tvTypes.text= pokemon.types.toString()
            context?.let {
                Glide.with(it).load(pokemon.img).into(binding.ivPoke) }
        })
        binding.fabShare.setOnClickListener {
            //view -> Snackbar.make(view, "Compartir el pokemon", Snackbar.LENGTH_LONG).setAction("Estás seguro?", this).show()
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "${binding.tvNamedetail.text}")
            startActivity(intent)
        }

        Log.d("nombre", "onCreateView: $param1")


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
                DetailFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)

                    }
                }
    }
}