package zup.pocandroid.feature.list.activity

import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_pokemon_list.rvPokemons
import javax.inject.Inject
import zup.pocandroid.R
import zup.pocandroid.base.BaseActivity
import zup.pocandroid.feature.list.adapter.PokemonAdapter
import zup.pocandroid.feature.list.adapter.PokemonAdapter.OnPokemonSelectedListener
import zup.pocandroid.feature.list.navigator.PokemonListNavigator
import zup.pocandroid.feature.list.viewmodel.PokemonListViewModel
import zup.pocandroid.util.showAlertMessage

class PokemonListActivity : BaseActivity<PokemonListViewModel>() {

    @Inject
    lateinit var pokemonAdapter: PokemonAdapter
    @Inject
    lateinit var navigator: PokemonListNavigator

    private val compositeDisposable = CompositeDisposable()

    override fun getLayoutId(): Int?  = R.layout.activity_pokemon_list

    override fun getViewModelClass(): Class<PokemonListViewModel> = PokemonListViewModel::class.java

    override fun initialize() {
        rvPokemons.adapter = pokemonAdapter
        pokemonAdapter.onPokemonSelectedListener = (object : OnPokemonSelectedListener {
            override fun onPokemonSelected(pokemonId: String) {
                navigator.onClickPokemon(pokemonId)
            }
        })

        compositeDisposable.add(viewModel.getPokemonsPresentation().subscribe({pokemonPresentations ->
            pokemonAdapter.items = pokemonPresentations
        }, { _ ->
            showAlertMessage(this, "Ocorreu um erro inesperado.")
        }))
    }

    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable.dispose()
    }
}
