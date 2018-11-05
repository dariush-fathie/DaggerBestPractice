package pro.ahoora.daggerbestpractice.ui.detail

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pro.ahoora.daggerbestpractice.di.scopes.PerFragment


@Module
abstract class DetailFragmentBuilder {

    @PerFragment
    @ContributesAndroidInjector(modules = [DetailFragmentModule::class])
    abstract fun provideDetailFragmentFactory(): DetailFragment
}