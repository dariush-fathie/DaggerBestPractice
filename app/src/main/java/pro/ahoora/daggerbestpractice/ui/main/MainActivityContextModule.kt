package pro.ahoora.daggerbestpractice.ui.main

import android.content.Context
import dagger.Binds
import dagger.Module
import pro.ahoora.daggerbestpractice.di.qualifiers.ActivityContext
import pro.ahoora.daggerbestpractice.di.scopes.PerActivity


@Module
abstract class MainActivityContextModule {

    @PerActivity
    @ActivityContext
    //@Named("activity_context") replaced with ^
    @Binds
    abstract fun mainActivityContext(mainActivity: MainActivity): Context

}