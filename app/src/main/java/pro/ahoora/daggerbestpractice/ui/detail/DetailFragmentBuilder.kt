package pro.ahoora.daggerbestpractice.ui.detail

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class DetailFragmentBuilder {

    @ContributesAndroidInjector(modules = [DetailFragmentModule::class])
    abstract fun provideDetailFragmentFactory(): DetailFragment
}