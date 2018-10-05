package zup.pocandroid.di.module

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import zup.pocandroid.feature.ShowPokemonActivity

@Module
abstract class ShowPokemonModule {

    @Binds
    abstract fun activity(activity: ShowPokemonActivity): AppCompatActivity

}