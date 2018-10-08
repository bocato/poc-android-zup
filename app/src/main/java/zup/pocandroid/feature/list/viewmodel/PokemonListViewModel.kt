package zup.pocandroid.feature.list.viewmodel

import android.arch.lifecycle.ViewModel
import io.reactivex.Single
import zup.pocandroid.data.model.presentation.PokemonPresentation
import zup.pocandroid.data.source.PokemonRepository
import zup.pocandroid.feature.list.viewmodel.converter.PokemonPresentationConverter
import javax.inject.Inject

class PokemonListViewModel @Inject constructor(
        private val pokemonRepository: PokemonRepository,
        private val converter: PokemonPresentationConverter) : ViewModel() {

    fun getPokemonsPresentation(): Single<List<PokemonPresentation>> {
        return pokemonRepository.getPokemonList().map {
            converter.convert(it)
        }
    }

}