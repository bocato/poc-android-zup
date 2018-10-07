package zup.pocandroid.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import zup.pocandroid.feature.list.activity.PokemonListActivity
import zup.pocandroid.feature.list.dimodule.PokemonListModule

@Module
abstract class ActivityBindingsModule {

    /*@ContributesAndroidInjector(modules = [(PokemonListModule::class)])
    abstract fun createShowPokemonActivity(): PokemonDetailActivity*/

    @ContributesAndroidInjector(modules = [(PokemonListModule::class)])
    internal abstract fun pokemonListActivity(): PokemonListActivity

}
