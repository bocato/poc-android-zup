package zup.pocandroid.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import zup.pocandroid.feature.detail.activity.PokemonDetailActivity
import zup.pocandroid.feature.detail.dimodule.PokemonDetailModule
import zup.pocandroid.feature.list.activity.PokemonListActivity
import zup.pocandroid.feature.list.dimodule.PokemonListModule

@Module
abstract class ActivityBindingsModule {

    @ContributesAndroidInjector(modules = [(PokemonListModule::class)])
    internal abstract fun pokemonListActivity(): PokemonListActivity

    @ContributesAndroidInjector(modules = [(PokemonDetailModule::class)])
    abstract fun pokemonDetailActivity(): PokemonDetailActivity

}
