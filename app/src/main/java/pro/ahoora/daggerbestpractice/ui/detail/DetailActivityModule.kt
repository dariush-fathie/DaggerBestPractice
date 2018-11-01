package pro.ahoora.daggerbestpractice.ui.detail

import dagger.Module
import dagger.Provides
import pro.ahoora.daggerbestpractice.di.scopes.ActivityScope
import java.util.*


@Module
class DetailActivityModule {

    @ActivityScope
    @Provides
    fun provideString(): String {
        return UUID.randomUUID().toString()
    }

}