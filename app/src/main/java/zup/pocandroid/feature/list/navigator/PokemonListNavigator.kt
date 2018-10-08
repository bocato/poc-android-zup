package zup.pocandroid.feature.list.navigator

import android.support.v7.app.AppCompatActivity
import zup.pocandroid.feature.detail.activity.PokemonDetailActivity
import javax.inject.Inject

open class PokemonListNavigator @Inject constructor(private val activity: AppCompatActivity){

    fun onClickPokemon(pokemonId: String) {
        activity.startActivity(PokemonDetailActivity.newIntent(activity, pokemonId = pokemonId))
    }

}