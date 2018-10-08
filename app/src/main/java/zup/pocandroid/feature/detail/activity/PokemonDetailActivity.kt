package zup.pocandroid.feature.detail.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import zup.pocandroid.R
import zup.pocandroid.base.BaseDatabindingActivity
import zup.pocandroid.databinding.ActivityPokemonDetailBinding
import zup.pocandroid.feature.detail.viewmodel.PokemonDetailViewModel

class PokemonDetailActivity : BaseDatabindingActivity<ActivityPokemonDetailBinding, PokemonDetailViewModel>() {

    private lateinit var pokemonId: String

    companion object {
        private const val POKEMON_ID_KEY = "POKEMON_ID_KEY"

        @JvmStatic
        fun newIntent(context: Context, pokemonId: String): Intent {
            val intent = Intent(context, PokemonDetailActivity::class.java)
            intent.putExtra(POKEMON_ID_KEY, pokemonId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        pokemonId = intent.extras.getString(POKEMON_ID_KEY)

        super.onCreate(savedInstanceState)
    }

    override fun getViewModelClass(): Class<PokemonDetailViewModel> = PokemonDetailViewModel::class.java

    override fun getLayoutId(): Int? = R.layout.activity_pokemon_detail

    override fun initialize() {
        dataBinding.viewModel = viewModel

        viewModel.initialize(pokemonId)
        viewModel.getPokemonPresentation().subscribe()
    }
}
