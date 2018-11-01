package pro.ahoora.daggerbestpractice.ui.main

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import dagger.Module
import dagger.Provides
import pro.ahoora.daggerbestpractice.di.scopes.ActivityScope
import javax.inject.Named


@Module
class MainActivityModule {



    @ActivityScope
    @Named("activity_context")
    @Provides
    fun mainActivityContext(mainActivity: MainActivity): Context {
        return mainActivity
    }

    @ActivityScope
    @Provides
    fun provideColor(): Color {
        return Color()
    }

    @ActivityScope
    @Provides
    fun providePackageManager(@Named("activity_context") context: Context): PackageManager {
        return context.packageManager
    }


}