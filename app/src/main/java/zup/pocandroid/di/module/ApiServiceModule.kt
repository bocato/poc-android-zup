package zup.pocandroid.di.module

import dagger.Module
import retrofit2.Retrofit
import dagger.Provides
import zup.pocandroid.PokemonApi
import zup.pocandroid.RetrofitWcc


@Module
class ApiServiceModule {

    @Provides
    internal fun providePokemonApi(@RetrofitWcc retrofit: Retrofit): PokemonApi {
        return retrofit.create<PokemonApi>(PokemonApi::class.java)
    }

}
