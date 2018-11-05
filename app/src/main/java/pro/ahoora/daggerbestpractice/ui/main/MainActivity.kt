package pro.ahoora.daggerbestpractice.ui.main

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import pro.ahoora.daggerbestpractice.R
import pro.ahoora.daggerbestpractice.base.BaseActivity
import pro.ahoora.daggerbestpractice.repository.local.LocalRESTApi
import pro.ahoora.daggerbestpractice.ui.detail.DetailActivity
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity() {


    @Inject
    lateinit var color: Color

    @Inject
    lateinit var localRESTApi: LocalRESTApi

    @Inject
    lateinit var pm: PackageManager

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Timber.e("is equal pm %s", "$pm ${pm == packageManager}")

        observe(mainViewModel.username) {
            Timber.e("username %s", it)
        }

        Handler().postDelayed({
            startActivity(Intent(this, DetailActivity::class.java))
        }, 500)

    }

}
