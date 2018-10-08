package zup.pocandroid.feature.list.adapter

import zup.pocandroid.R
import zup.pocandroid.base.BaseRecyclerViewAdapter
import zup.pocandroid.base.BaseViewHolder
import zup.pocandroid.data.model.presentation.PokemonPresentation
import zup.pocandroid.databinding.ItemPokemonBinding
import javax.inject.Inject

class PokemonAdapter @Inject constructor(): BaseRecyclerViewAdapter<PokemonPresentation, ItemPokemonBinding>() {

    interface OnPokemonSelectedListener {
        fun onPokemonSelected(pokemonId: String)
    }

    var onPokemonSelectedListener: OnPokemonSelectedListener? = null

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_pokemon
    }

    override fun onBindViewHolder(holder: BaseViewHolder<PokemonPresentation, ItemPokemonBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

        holder.binding.itemLayout.setOnClickListener {
            onPokemonSelectedListener?.onPokemonSelected(items[position].pokemonId)
        }
    }
}