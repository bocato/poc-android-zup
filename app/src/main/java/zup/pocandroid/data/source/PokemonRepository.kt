package zup.pocandroid.data.source

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import zup.pocandroid.data.model.service.Pokemon
import zup.pocandroid.data.source.remote.PokemonApi
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokemonApi: PokemonApi) {

    fun getPokemonList(): Single<List<Pokemon>> {
        return pokemonApi.getPokemonList().map {
            it.results
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    /*fun getPokemonById(id: String): Single<List<Pokemon>> {
        return pokemonApi.getPokemonById(id).map {
//            it.results
        }
    }*/

}