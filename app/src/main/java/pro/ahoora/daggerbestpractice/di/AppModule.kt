package pro.ahoora.daggerbestpractice.di

import android.graphics.drawable.ShapeDrawable
import dagger.Module
import dagger.Provides
import pro.ahoora.daggerbestpractice.di.scopes.PerApplication


@Module(includes = [ApplicationContext::class, RESTModule::class, ViewModelModule::class])
class AppModule {

    /**
     * provide all sort of dependencies that have to exit until end of application lifecycle
     */

    /*
    this  provider replaced with applicationContext module
    @Provides
    @PerApplication
    fun provideApplicationContext(application: Application): Context {
        return application
    }*/

    @Provides
    @PerApplication
    fun provideSomething(): ShapeDrawable {
        return ShapeDrawable()
    }


}