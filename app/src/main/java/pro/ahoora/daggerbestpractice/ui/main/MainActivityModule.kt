package pro.ahoora.daggerbestpractice.ui.main

import android.graphics.Color
import dagger.Module
import dagger.Provides
import pro.ahoora.daggerbestpractice.di.scopes.ActivityScope


@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideColor(): Color {
        return Color()
    }

}