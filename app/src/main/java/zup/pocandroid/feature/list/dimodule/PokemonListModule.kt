package zup.pocandroid.feature.list.dimodule

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import zup.pocandroid.di.module.BaseActivityModule
import zup.pocandroid.feature.list.activity.PokemonListActivity

@Module(includes = [(BaseActivityModule::class)])
abstract class PokemonListModule {

    @Binds
    abstract fun activity(activity: PokemonListActivity): AppCompatActivity

}