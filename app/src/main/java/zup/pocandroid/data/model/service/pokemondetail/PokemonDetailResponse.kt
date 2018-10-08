package zup.pocandroid.data.model.service.pokemondetail

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse(
    val id: String? = null,
    val name: String? = null,
    val weight: Int? = null,
    val height: Int? = null,
    @SerializedName("base_experience")
    val baseExperience: Int? = null,
    val abilities: List<Ability>? = null
)

data class Ability(
    @SerializedName("is_hidden")
    val isHidden: Boolean? = null,
    val slot: Boolean? = null,
    @SerializedName("ability")
    val abilityDetail: AbilityDetail? = null
)

data class AbilityDetail(
    val name: String? = null,
    val url: String? = null
)