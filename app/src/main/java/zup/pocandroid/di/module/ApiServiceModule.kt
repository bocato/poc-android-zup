package zup.pocandroid.di.module

import dagger.Module
import retrofit2.Retrofit
import dagger.Provides
import zup.pocandroid.data.source.remote.PokemonApi

@Module
class ApiServiceModule {

    @Provides
    internal fun providePokemonApi(retrofit: Retrofit): PokemonApi {
        return retrofit.create<PokemonApi>(PokemonApi::class.java)
    }

}
