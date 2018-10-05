package zup.pocandroid.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import zup.pocandroid.di.module.ActivityBindingsModule
import zup.pocandroid.di.module.ApiServiceModule
import zup.pocandroid.di.module.BaseActivityModule
import zup.pocandroid.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class, ApiServiceModule::class, ActivityBindingsModule::class, AndroidSupportInjectionModule::class))
interface AppComponent : AndroidInjector<DaggerApplication> {

    override fun inject(daggerApplication: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}