package pro.ahoora.daggerbestpractice.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pro.ahoora.daggerbestpractice.repository.local.LocalRESTApi
import pro.ahoora.daggerbestpractice.repository.sharedprefs.SharedPrefsManager
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(localRESTApi: LocalRESTApi
                                        , sharedPrefsManager: SharedPrefsManager) : ViewModel() {


    val username = MutableLiveData<String>()

    init {
        Timber.e("mainViewModel restApi %s", localRESTApi)
        Timber.e("mainViewModel sharedPrefsImpl %s", sharedPrefsManager)

        sharedPrefsManager.putString("first", "this is first")
                .subscribe {
                    Timber.e("put string %s", "some string")
                }.dispose()

        sharedPrefsManager
                .putString("key", "value")
                .doOnComplete(this::putString)
                .subscribe()

        sharedPrefsManager.getString("first")
                .doOnSubscribe {

                }
                .subscribe()

        username.value = "dariush fathi"
    }


    fun getString() {

    }

    private fun putString() {

    }

}