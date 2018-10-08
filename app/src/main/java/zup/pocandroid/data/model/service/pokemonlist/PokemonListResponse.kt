package zup.pocandroid.data.model.service.pokemonlist

data class PokemonListResponse(
        val results: List<Pokemon>
)

data class Pokemon(
        val name: String? = null,
        val url: String? = null
)