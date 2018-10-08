package zup.pocandroid.feature.list.viewmodel.converter

import zup.pocandroid.data.model.presentation.PokemonPresentation
import zup.pocandroid.data.model.service.pokemonlist.Pokemon
import zup.pocandroid.util.DEFAULT_VIEW_VALUE
import zup.pocandroid.util.POKEMON_IMAGE_URL
import javax.inject.Inject

open class PokemonPresentationConverter @Inject constructor() {

    open fun convert(pokemons: List<Pokemon>): List<PokemonPresentation> {
        val pokemonPresentations = mutableListOf<PokemonPresentation>()

        pokemons.forEach {
            val regex = Regex("/pokemon/(\\d+)")
            var pokemonId = if (it.url != null) {
                val matchResult = regex.find(it.url)
                matchResult?.groupValues?.get(1) ?: ""
            } else {
                ""
            }
            val imgUrl = String.format(POKEMON_IMAGE_URL, pokemonId)
            val name = it.name ?: "?"

            val pokemonPresentation = PokemonPresentation(
                    pokemonId = pokemonId,
                    name = name,
                    imgUrl = imgUrl,
                    abilities = DEFAULT_VIEW_VALUE,
                    weight = DEFAULT_VIEW_VALUE,
                    height = DEFAULT_VIEW_VALUE,
                    baseExperience = DEFAULT_VIEW_VALUE)

            pokemonPresentations.add(pokemonPresentation)
        }

        return pokemonPresentations
    }

}