package zup.pocandroid.feature.list.viewmodel.converter

import zup.pocandroid.data.model.presentation.PokemonPresentation
import zup.pocandroid.data.model.service.Pokemon
import javax.inject.Inject

class PokemonPresentationConverter @Inject constructor() {

    fun convert(pokemons: List<Pokemon>): List<PokemonPresentation> {
        val pokemonPresentations = mutableListOf<PokemonPresentation>()

        pokemons.forEach {
            var pokemonId = ""
            val regex = Regex("/pokemon/(\\d+)")
            pokemonId = if (it.url != null) {
                val matchResult = regex.find(it.url)
                matchResult?.groupValues?.get(1) ?: ""
            } else {
                ""
            }
            val imgUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonId.png"
            val pokemonPresentation = PokemonPresentation(pokemonId = pokemonId, pokemonName = it.name, imgUrl = imgUrl)
            pokemonPresentations.add(pokemonPresentation)
        }

        return pokemonPresentations
    }

}