package pro.ahoora.daggerbestpractice.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pro.ahoora.daggerbestpractice.repository.local.LocalRESTApi
import timber.log.Timber
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val localRESTApi: LocalRESTApi) : ViewModel() {

    val username = MutableLiveData<String>()

    init {
        Timber.e("detailViewModel  restApi%s", localRESTApi)
        username.value = "detail dariush fathi"
    }

}