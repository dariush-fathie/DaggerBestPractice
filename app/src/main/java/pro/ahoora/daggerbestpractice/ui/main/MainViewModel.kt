package pro.ahoora.daggerbestpractice.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pro.ahoora.daggerbestpractice.repository.local.LocalRESTApi
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(private val localRESTApi: LocalRESTApi) : ViewModel() {

    val username = MutableLiveData<String>()

    init {
        Timber.e("mainViewModel restApi %s", localRESTApi)
        username.value = "dariush fathi"
    }

}