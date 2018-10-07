package zup.pocandroid.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import zup.pocandroid.base.ViewModelFactory
import zup.pocandroid.di.annotation.ViewModelKey
import zup.pocandroid.feature.list.viewmodel.PokemonListViewModel

@Module
abstract class ViewModelBindindsModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonListViewModel::class)
    abstract fun pokemonListViewModel(viewModel: PokemonListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}