package zup.pocandroid.feature.list.viewmodel.converter

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import zup.pocandroid.data.model.service.pokemonlist.Pokemon

class PokemonPresentationConverterTest {

    private lateinit var pokemonPresentationConverter: PokemonPresentationConverter
    @Before
    fun setUp() {
        pokemonPresentationConverter = PokemonPresentationConverter()
    }

    @Test
    fun convert() {
        // Given
        val pokemon = Pokemon(name = "test", url = "http://test/pokemon/1")
        val pokemonList = listOf(pokemon)

        // When
        val pokemonPresentationList = pokemonPresentationConverter.convert(pokemonList)

        // Then
        assertTrue(pokemonPresentationList.size == 1)
        assertTrue(pokemonPresentationList[0].name == "test")
        assertTrue(pokemonPresentationList[0].imgUrl == "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png")
    }
}