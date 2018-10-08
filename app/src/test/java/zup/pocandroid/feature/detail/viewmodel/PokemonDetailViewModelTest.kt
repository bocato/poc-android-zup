package zup.pocandroid.feature.detail.viewmodel

import io.reactivex.Single
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import zup.pocandroid.data.model.presentation.PokemonPresentation
import zup.pocandroid.data.model.service.pokemondetail.PokemonDetailResponse
import zup.pocandroid.data.source.PokemonRepository
import zup.pocandroid.feature.detail.viewmodel.converter.PokemonDetailPresentationConverter

@RunWith(MockitoJUnitRunner::class)
class PokemonDetailViewModelTest {

    @Mock
    private lateinit var pokemonRepository: PokemonRepository
    @Mock
    private lateinit var converter: PokemonDetailPresentationConverter

    private lateinit var pokemonDetailViewModel: PokemonDetailViewModel
    private val pokemonId = "2"

    @Before
    fun setUp() {
        pokemonDetailViewModel = PokemonDetailViewModel(pokemonRepository, converter)
        pokemonDetailViewModel.initialize(pokemonId)
    }

    @Test
    fun getPokemonPresentation() {
        // Given
        val pokemonDetailResponse = PokemonDetailResponse()
        val pokemonPresentation = PokemonPresentation(pokemonId = "2", abilities = "",
                name = "", baseExperience = "", height = "", weight = "", imgUrl = "")

        // When
        Mockito.`when`(pokemonRepository.getPokemonById(pokemonId)).thenReturn(Single.just(pokemonDetailResponse))
        Mockito.`when`(converter.convert(pokemonDetailResponse)).thenReturn(pokemonPresentation)
        val testObserver = pokemonDetailViewModel.getPokemonPresentation().test()

        // Then
        testObserver.assertComplete()
        assertTrue(pokemonDetailViewModel.presentation.value == pokemonPresentation)
    }
}