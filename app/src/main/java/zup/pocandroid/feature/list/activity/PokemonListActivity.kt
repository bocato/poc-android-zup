package zup.pocandroid.feature.list.activity

import android.support.v7.app.AlertDialog
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_pokemon_list.rvPokemons
import javax.inject.Inject
import zup.pocandroid.R
import zup.pocandroid.base.BaseActivity
import zup.pocandroid.base.BaseDatabindingActivity
import zup.pocandroid.data.model.presentation.PokemonPresentation
import zup.pocandroid.databinding.ActivityPokemonListBinding
import zup.pocandroid.feature.list.adapter.PokemonAdapter
import zup.pocandroid.feature.list.viewmodel.PokemonListViewModel

class PokemonListActivity : BaseActivity<PokemonListViewModel>() {

    @Inject
    lateinit var pokemonAdapter: PokemonAdapter

    private val compositeDisposable = CompositeDisposable()

    override fun getLayoutId(): Int?  = R.layout.activity_pokemon_list

    override fun getViewModelClass(): Class<PokemonListViewModel> = PokemonListViewModel::class.java

    override fun initialize() {
        rvPokemons.adapter = pokemonAdapter

        compositeDisposable.add(viewModel.getPokemonsPresentation().subscribe({pokemonPresentations ->
            pokemonAdapter.items = pokemonPresentations
        }, { throwable ->
            AlertDialog.Builder(this)
                    .setMessage(throwable.message)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }.show()
        }))
    }

    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable.dispose()
    }
}
