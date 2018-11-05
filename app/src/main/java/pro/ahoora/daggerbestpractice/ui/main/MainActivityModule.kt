package pro.ahoora.daggerbestpractice.ui.main

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import dagger.Module
import dagger.Provides
import pro.ahoora.daggerbestpractice.di.qualifiers.ActivityContext
import pro.ahoora.daggerbestpractice.di.scopes.PerActivity


@Module(includes = [MainActivityContextModule::class])
class MainActivityModule {

    // put all main activity dependencies here

    @PerActivity
    @Provides
    fun provideColor(): Color {
        return Color()
    }

    @PerActivity
    @Provides
    fun providePackageManager(/*@Named("activity_context")*/@ActivityContext context: Context): PackageManager {
        return context.packageManager
    }

}
