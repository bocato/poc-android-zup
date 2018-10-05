package zup.pocandroid

import io.reactivex.Single
import retrofit2.http.GET
import zup.pocandroid.data.model.presentation.Pokemon

interface PokemonApi {

    @GET("/pokemon")
    fun getPokemonList(): Single<List<Pokemon>>

}