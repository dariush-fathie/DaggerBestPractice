package pro.ahoora.daggerbestpractice.di

import android.app.Application
import android.content.Context
import android.graphics.drawable.ShapeDrawable
import dagger.Module
import dagger.Provides
import pro.ahoora.daggerbestpractice.di.scopes.ApplicationScope


@Module(includes = [RESTModule::class])
class AppModule {

    /**
     * provide all sort of dependencies that have to exit until end of application lifecycle
     */

    @Provides
    @ApplicationScope
    fun provideApplicationContext(application: Application): Context {
        return application
    }

    @Provides
    @ApplicationScope
    fun provideSomething(): ShapeDrawable {
        return ShapeDrawable()
    }


}