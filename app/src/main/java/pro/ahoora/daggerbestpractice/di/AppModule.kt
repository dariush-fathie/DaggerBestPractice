package pro.ahoora.daggerbestpractice.di

import android.app.Application
import android.content.Context
import android.graphics.drawable.ShapeDrawable
import dagger.Module
import dagger.Provides
import pro.ahoora.daggerbestpractice.di.scopes.PerApplication


@Module(includes = [RESTModule::class, ViewModelModule::class])
class AppModule {

    /**
     * provide all sort of dependencies that have to exit until end of application lifecycle
     */

    @Provides
    @PerApplication
    fun provideApplicationContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    fun provideSomething(): ShapeDrawable {
        return ShapeDrawable()
    }


}