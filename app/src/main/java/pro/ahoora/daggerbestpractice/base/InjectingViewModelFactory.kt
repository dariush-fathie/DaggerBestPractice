package pro.ahoora.daggerbestpractice.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pro.ahoora.daggerbestpractice.di.scopes.PerApplication
import javax.inject.Inject
import javax.inject.Provider

@PerApplication
class InjectingViewModelFactory @Inject constructor(
        private val viewModelProviders: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = viewModelProviders[modelClass]
                ?: viewModelProviders.entries.first { modelClass.isAssignableFrom(it.key) }.value

        return provider.get() as T
    }
}