package pro.ahoora.daggerbestpractice.ui.detail

import dagger.Module
import dagger.Provides
import pro.ahoora.daggerbestpractice.di.scopes.PerActivity
import java.util.*


@Module
class DetailActivityModule {

    @PerActivity
    @Provides
    fun provideString(): String {
        return UUID.randomUUID().toString()
    }

}