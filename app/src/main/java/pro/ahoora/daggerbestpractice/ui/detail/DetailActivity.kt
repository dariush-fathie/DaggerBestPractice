package pro.ahoora.daggerbestpractice.ui.detail

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import pro.ahoora.daggerbestpractice.R
import pro.ahoora.daggerbestpractice.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject


class DetailActivity : BaseActivity() {

    @Inject
    lateinit var uuid: String

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var detailViewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        observe(detailViewModel.username) {
            Timber.e("detailActivity observer %s", it)
        }

        if (savedInstanceState == null)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fl_detail, DetailFragment())
                    .commit()

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}
