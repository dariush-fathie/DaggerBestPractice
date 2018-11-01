package pro.ahoora.daggerbestpractice.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import pro.ahoora.daggerbestpractice.BestPracticeApp
import pro.ahoora.daggerbestpractice.di.scopes.ApplicationScope


@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class, AppModule::class])
@ApplicationScope
interface AppComponent : AndroidInjector<BestPracticeApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BestPracticeApp>() {

        override fun seedInstance(instance: BestPracticeApp?) {

        }

        @BindsInstance
        abstract fun application(application: Application): Builder
    }

}