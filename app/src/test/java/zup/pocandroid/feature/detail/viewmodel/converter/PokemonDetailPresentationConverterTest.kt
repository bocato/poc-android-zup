package zup.pocandroid.feature.detail.viewmodel.converter

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import zup.pocandroid.data.model.service.pokemondetail.Ability
import zup.pocandroid.data.model.service.pokemondetail.AbilityDetail
import zup.pocandroid.data.model.service.pokemondetail.PokemonDetailResponse
import zup.pocandroid.feature.list.viewmodel.converter.PokemonPresentationConverter

class PokemonDetailPresentationConverterTest {

    private lateinit var pokemonDetailPresentationConverter: PokemonDetailPresentationConverter

    @Before
    fun setUp() {
        pokemonDetailPresentationConverter = PokemonDetailPresentationConverter()
    }

    @Test
    fun convert() {
        // Given
        val pokemonName = "test"
        val abilityName = "ab1"
        val abilityList = listOf(Ability(abilityDetail = AbilityDetail(name=abilityName)))
        val pokemonDetailResponse = PokemonDetailResponse(name = pokemonName, abilities = abilityList)

        // When
        val pokemonPresentation = pokemonDetailPresentationConverter.convert(pokemonDetailResponse)

        // Then
        assertTrue(pokemonPresentation.name == pokemonName)
        assertTrue(pokemonPresentation.abilities == abilityName)
    }
}