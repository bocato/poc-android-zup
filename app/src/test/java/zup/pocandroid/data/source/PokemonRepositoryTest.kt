package zup.pocandroid.data.source

import io.reactivex.Single
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import zup.pocandroid.TrampolineSchedulerRule
import zup.pocandroid.data.model.service.pokemondetail.PokemonDetailResponse
import zup.pocandroid.data.model.service.pokemonlist.Pokemon
import zup.pocandroid.data.model.service.pokemonlist.PokemonListResponse
import zup.pocandroid.data.source.remote.PokemonApi

@RunWith(MockitoJUnitRunner::class)
open class PokemonRepositoryTest {

    @Rule @JvmField
    val trampolineScheduler = TrampolineSchedulerRule()

    @Mock
    private lateinit var pokemonApiMock: PokemonApi

    private lateinit var pokemonRepository: PokemonRepository

    @Before
    fun setUp() {
        pokemonRepository = PokemonRepository(pokemonApiMock)
    }

    @Test
    fun getPokemonList() {
        // Given
        val pokemonList = emptyList<Pokemon>()
        val pokemonListResponse = PokemonListResponse(pokemonList)
        val pokemonListSingle = Single.just(pokemonListResponse)

        // When
        Mockito.`when`(pokemonApiMock.getPokemonList()).thenReturn(pokemonListSingle)
        val testObserver = pokemonRepository.getPokemonList().test()

        // Then
        testObserver.assertComplete().assertValue { response -> response == pokemonList }
    }

    @Test
    fun getPokemonById() {
        // Given
        val pokemonId = "1"
        val pokemonDetailResponse = PokemonDetailResponse()
        val pokemonDetailResponseSingle = Single.just(pokemonDetailResponse)

        // When
        Mockito.`when`(pokemonApiMock.getPokemonById(pokemonId)).thenReturn(pokemonDetailResponseSingle)
        val testObserver = pokemonRepository.getPokemonById(pokemonId).test()

        // Then
        testObserver.assertComplete().assertValue { response -> response == pokemonDetailResponse }
    }
}