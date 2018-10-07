package zup.pocandroid.feature.list.adapter

import zup.pocandroid.R
import zup.pocandroid.base.BaseRecyclerViewAdapter
import zup.pocandroid.data.model.presentation.PokemonPresentation
import zup.pocandroid.databinding.ItemPokemonBinding
import javax.inject.Inject

class PokemonAdapter @Inject constructor(): BaseRecyclerViewAdapter<PokemonPresentation, ItemPokemonBinding>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_pokemon
    }

}