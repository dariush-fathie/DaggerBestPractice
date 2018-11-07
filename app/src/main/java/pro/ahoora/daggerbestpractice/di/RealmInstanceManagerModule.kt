package pro.ahoora.daggerbestpractice.di

import dagger.Lazy
import dagger.Module
import dagger.Provides
import pro.ahoora.daggerbestpractice.data.RealmInstanceManager
import pro.ahoora.daggerbestpractice.di.scopes.PerApplication


@Module
class RealmInstanceManagerModule {

    @Provides
    @PerApplication
    fun provideRealmInstanceManager(): RealmInstanceManager {
        return RealmInstanceManager()
    }

}