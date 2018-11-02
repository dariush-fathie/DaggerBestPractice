package pro.ahoora.daggerbestpractice

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pro.ahoora.daggerbestpractice.di.DaggerAppComponent
import pro.ahoora.daggerbestpractice.repository.local.LocalRESTApi
import timber.log.Timber
import javax.inject.Inject


class BestPracticeApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out BestPracticeApp> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }


}