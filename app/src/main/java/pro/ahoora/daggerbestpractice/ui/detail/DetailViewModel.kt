package pro.ahoora.daggerbestpractice.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pro.ahoora.daggerbestpractice.data.Resource
import pro.ahoora.daggerbestpractice.repository.local.LocalRESTApi
import pro.ahoora.daggerbestpractice.repository.sharedprefs.SharedPrefsManager
import timber.log.Timber
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val localRESTApi: LocalRESTApi
                                          , private val sharedPrefsManager: SharedPrefsManager) : ViewModel() {

    val username = MutableLiveData<String>()

    init {

        Timber.e("detailViewModel  restApi%s", localRESTApi)
        Timber.e("detailViewModel  sharedPrefsImpl%s", sharedPrefsManager)
        username.value = "detail dariush fathi"
    }

}