package zup.pocandroid

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import zup.pocandroid.di.DaggerAppComponent

class PokeApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()
        appComponent.inject(this)
        return appComponent
    }


}