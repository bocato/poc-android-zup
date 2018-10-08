package zup.pocandroid.feature.detail.viewmodel.converter

import zup.pocandroid.data.model.presentation.PokemonPresentation
import zup.pocandroid.data.model.service.pokemondetail.PokemonDetailResponse
import zup.pocandroid.util.DEFAULT_VIEW_VALUE
import zup.pocandroid.util.POKEMON_IMAGE_URL
import javax.inject.Inject

open class PokemonDetailPresentationConverter @Inject constructor() {

    open fun convert(pokemonDetailResponse: PokemonDetailResponse): PokemonPresentation {
        val pokemonId = pokemonDetailResponse.id ?: ""
        val pokemonName = pokemonDetailResponse.name ?: DEFAULT_VIEW_VALUE
        val height = pokemonDetailResponse.height?.toString() ?: DEFAULT_VIEW_VALUE
        val weight = pokemonDetailResponse.weight?.toString() ?: DEFAULT_VIEW_VALUE
        val baseExperience = pokemonDetailResponse.baseExperience?.toString() ?: DEFAULT_VIEW_VALUE
        val imgUrl = String.format(POKEMON_IMAGE_URL, pokemonId)

        var abilities = ""
        pokemonDetailResponse.abilities?.forEach {
            abilities += it.abilityDetail?.name
        }

        return PokemonPresentation(
                pokemonId = pokemonId,
                name = pokemonName,
                height = height, weight = weight,
                abilities = abilities,
                baseExperience = baseExperience,
                imgUrl = imgUrl)
    }

}