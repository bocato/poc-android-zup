package zup.pocandroid.feature

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.pokemon_details.view.*
import zup.pocandroid.R
import zup.pocandroid.data.model.presentation.Pokemon

class PokemonAdapter(private val pokemonList: List<Pokemon>,
                     private val context: Context): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pokemon_details, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(pokemonList[position])
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindView(pokemon: Pokemon) {
            val name = itemView.pokemonName
            val url = itemView.pokemonImg

            name.text = pokemon.pokemonName
            //url to image
        }

    }
}