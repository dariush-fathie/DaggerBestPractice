package pro.ahoora.daggerbestpractice.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import dagger.android.support.DaggerAppCompatActivity
import io.realm.Realm
import pro.ahoora.daggerbestpractice.data.RealmInstanceManager

abstract class BaseActivity : DaggerAppCompatActivity() {


    inline fun <reified T : ViewModel> AppCompatActivity.getViewModel(factory: ViewModelProvider.Factory): T {
        return ViewModelProviders.of(this, factory).get(T::class.java)
    }

    inline fun <reified T : ViewModel> AppCompatActivity.withViewModel(factory: ViewModelProvider.Factory, body: T.() -> Unit): T {
        val vm = getViewModel<T>(factory)
        vm.body()
        return vm
    }

    fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
        liveData.observe(this, Observer(body))
    }

    fun getRealmInstance(): Realm = Realm.getDefaultInstance()
}