package zup.pocandroid.data.source

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import zup.pocandroid.data.model.service.pokemondetail.PokemonDetailResponse
import zup.pocandroid.data.model.service.pokemonlist.Pokemon
import zup.pocandroid.data.source.remote.PokemonApi
import javax.inject.Inject

open class PokemonRepository @Inject constructor(private val pokemonApi: PokemonApi) {

    open fun getPokemonList(): Single<List<Pokemon>> {
        return pokemonApi.getPokemonList().map {
            it.results
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    open fun getPokemonById(id: String): Single<PokemonDetailResponse> {
        return pokemonApi.getPokemonById(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

}