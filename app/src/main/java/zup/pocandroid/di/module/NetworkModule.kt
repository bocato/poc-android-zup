package zup.pocandroid.di.module

import io.reactivex.schedulers.Schedulers
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import com.google.gson.Gson
import dagger.Provides
import javax.inject.Singleton
import com.google.gson.GsonBuilder
import android.app.Application
import dagger.Module
import okhttp3.Cache
import zup.pocandroid.RetrofitWcc
import java.util.concurrent.TimeUnit
import javax.inject.Named


@Module
class NetworkModule {

    @Provides
    @Named("baseUrl")
    internal fun provideBaseUrl(): String {
        return "https://pokeapi.co/api/v2/"
    }

    @Provides
    @Singleton
    internal fun provideHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        val cache = Cache(application.cacheDir, cacheSize.toLong())
        return cache
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @RetrofitWcc
    internal fun provideRetrofitWcc(gson: Gson, cache: Cache, @Named("baseUrl") baseUrl: String): Retrofit {
        return provideRetrofit(gson, cache, baseUrl)
    }

    private fun provideRetrofit(gson: Gson, cache: Cache, @Named("baseUrl") baseUrl: String): Retrofit {
        val builder = OkHttpClient.Builder().cache(cache)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)

        val okHttpClient = builder.build()

        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
    }
}
