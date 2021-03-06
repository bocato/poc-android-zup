package zup.pocandroid.data.source.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import zup.pocandroid.data.model.service.pokemondetail.PokemonDetailResponse
//import zup.pocandroid.data.model.service.pokemondetail.PokemonDetailResponse
import zup.pocandroid.data.model.service.pokemonlist.PokemonListResponse

interface PokemonApi {

    @GET("pokemon/")
    fun getPokemonList(): Single<PokemonListResponse>

    @GET("pokemon/{id}")
    fun getPokemonById(@Path(value="id") id: String): Single<PokemonDetailResponse>

}