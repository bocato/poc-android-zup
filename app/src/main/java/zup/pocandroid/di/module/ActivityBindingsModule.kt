package zup.pocandroid.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import zup.pocandroid.feature.ShowPokemonActivity

@Module
abstract class ActivityBindingsModule {

    @ContributesAndroidInjector(modules = [(ShowPokemonModule::class)])
    abstract fun createShowPokemonActivity(): ShowPokemonActivity

}
