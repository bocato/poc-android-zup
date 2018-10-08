package zup.pocandroid.feature.detail.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Completable
import zup.pocandroid.data.model.presentation.PokemonPresentation
import zup.pocandroid.data.source.PokemonRepository
import zup.pocandroid.feature.detail.viewmodel.converter.PokemonDetailPresentationConverter
import javax.inject.Inject

class PokemonDetailViewModel @Inject constructor(
        private val pokemonRepository: PokemonRepository,
        private val converter: PokemonDetailPresentationConverter) : ViewModel() {

    val presentation = MutableLiveData<PokemonPresentation>()

    private lateinit var pokemonId: String

    fun initialize(pokemonId: String) {
        this.pokemonId = pokemonId
    }

    fun getPokemonPresentation(): Completable {
        return pokemonRepository.getPokemonById(pokemonId).map {
            presentation.value = converter.convert(it)
        }.ignoreElement()
    }

}