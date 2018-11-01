package pro.ahoora.daggerbestpractice.di

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pro.ahoora.daggerbestpractice.di.scopes.ApplicationScope
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

@Module
class RetrofitModule {

    @Provides
    @ApplicationScope
    fun provideRetrofit(okHttpclient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpclient)
                .baseUrl("http://www.unary.ir")
                .build()
    }

    @Provides
    @ApplicationScope
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @ApplicationScope
    fun getOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build()
    }

    @Provides
    @ApplicationScope
    fun provideCache(cacheFile: File): Cache {
        return Cache(cacheFile, 10 * 60 * 1024)
    }


    @Provides
    @ApplicationScope
    fun provideCacheFile(context: Context): File {
        return File(context.cacheDir, "httpCache")
    }

}