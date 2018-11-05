package pro.ahoora.daggerbestpractice.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pro.ahoora.daggerbestpractice.base.InjectingViewModelFactory
import pro.ahoora.daggerbestpractice.di.keys.ViewModelKey
import pro.ahoora.daggerbestpractice.di.scopes.PerApplication
import pro.ahoora.daggerbestpractice.ui.detail.DetailViewModel
import pro.ahoora.daggerbestpractice.ui.main.MainViewModel


@Module
abstract class ViewModelModule {

    /**
     * add all viewModels here
     */

    @Binds
    @PerApplication
    abstract fun bindViewModelFactory(factory: InjectingViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel

}