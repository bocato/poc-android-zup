package zup.pocandroid.feature.list.viewmodel

import io.reactivex.Single
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import zup.pocandroid.data.model.presentation.PokemonPresentation
import zup.pocandroid.data.model.service.pokemonlist.Pokemon
import zup.pocandroid.data.source.PokemonRepository
import zup.pocandroid.feature.list.viewmodel.converter.PokemonPresentationConverter

@RunWith(MockitoJUnitRunner::class)
class PokemonListViewModelTest {

    @Mock
    private lateinit var pokemonRepository: PokemonRepository
    @Mock
    private lateinit var pokemonPresentationConverter: PokemonPresentationConverter

    private lateinit var pokemonListViewModel: PokemonListViewModel

    @Before
    fun setUp() {
        pokemonListViewModel = PokemonListViewModel(pokemonRepository, pokemonPresentationConverter)
    }

    @Test
    fun getPokemonsPresentation() {
        // Given
        val pokemonList = emptyList<Pokemon>()
        val pokemonPresentationList = emptyList<PokemonPresentation>()
        val pokemonListSingle = Single.just(pokemonList)

        // When
        Mockito.`when`(pokemonRepository.getPokemonList()).thenReturn(pokemonListSingle)
        Mockito.`when`(pokemonPresentationConverter.convert(pokemonList)).thenReturn(pokemonPresentationList)
        val testObserver = pokemonListViewModel.getPokemonsPresentation().test()

        // Then
        testObserver.assertComplete().assertValue { response -> response == pokemonPresentationList }
    }
}