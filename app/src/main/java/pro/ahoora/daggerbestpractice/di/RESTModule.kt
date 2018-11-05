package pro.ahoora.daggerbestpractice.di

import dagger.Module
import dagger.Provides
import pro.ahoora.daggerbestpractice.di.scopes.PerApplication
import pro.ahoora.daggerbestpractice.repository.local.LocalRESTApi
import pro.ahoora.daggerbestpractice.repository.remote.RemoteRESTApi
import retrofit2.Retrofit


@Module(includes = [RetrofitModule::class])
class RESTModule {

    @Provides
    @PerApplication
    fun provideLocalRestApi(retrofit: Retrofit): LocalRESTApi {
        return retrofit.create(LocalRESTApi::class.java)
    }

    @Provides
    @PerApplication
    fun provideRemoteRestApi(retrofit: Retrofit): RemoteRESTApi {
        return retrofit.create(RemoteRESTApi::class.java)
    }
}