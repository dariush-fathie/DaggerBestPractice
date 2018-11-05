package pro.ahoora.daggerbestpractice.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pro.ahoora.daggerbestpractice.di.scopes.PerActivity
import pro.ahoora.daggerbestpractice.ui.detail.DetailActivity
import pro.ahoora.daggerbestpractice.ui.detail.DetailActivityModule
import pro.ahoora.daggerbestpractice.ui.detail.DetailFragmentBuilder
import pro.ahoora.daggerbestpractice.ui.main.MainActivity
import pro.ahoora.daggerbestpractice.ui.main.MainActivityModule


@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity


    @PerActivity
    @ContributesAndroidInjector(modules = [DetailActivityModule::class, DetailFragmentBuilder::class])
    abstract fun bindDetailActivity(): DetailActivity


}