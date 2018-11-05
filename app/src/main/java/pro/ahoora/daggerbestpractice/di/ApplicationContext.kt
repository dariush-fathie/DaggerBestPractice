package pro.ahoora.daggerbestpractice.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import pro.ahoora.daggerbestpractice.di.qualifiers.ApplicationContext
import pro.ahoora.daggerbestpractice.di.scopes.PerApplication

@Module
abstract class ApplicationContext {

    @Binds
    @ApplicationContext
    @PerApplication
    abstract fun bindApplicationContext(application: Application): Context

}