package pro.ahoora.daggerbestpractice.ui.main

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import dagger.android.support.DaggerAppCompatActivity
import pro.ahoora.daggerbestpractice.R
import pro.ahoora.daggerbestpractice.repository.local.LocalRESTApi
import pro.ahoora.daggerbestpractice.ui.detail.DetailActivity
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var color: Color

    @Inject
    lateinit var localRESTApi: LocalRESTApi

    @Inject
    lateinit var pm: PackageManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Timber.e("ma color 1 %s", color)
        Timber.e("ma restApi 2 %s", localRESTApi)
        Timber.e("ma packageManager %s", pm == packageManager)


        Handler().postDelayed({
            startActivity(Intent(this, DetailActivity::class.java))
            finish()
        }, 500)

    }

    override fun onResume() {
        super.onResume()

        Timber.e("ma color 1 %s", color)
        Timber.e("ma restAPi %s", localRESTApi)

    }
}
