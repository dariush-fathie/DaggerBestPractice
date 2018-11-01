package pro.ahoora.daggerbestpractice.ui.detail

import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import pro.ahoora.daggerbestpractice.R
import pro.ahoora.daggerbestpractice.ui.main.MainActivity
import timber.log.Timber
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var uuid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        Timber.e("ma color 1 %s", uuid)
        Timber.e("ma color 2 %s", uuid)
        Timber.e("ma color 3 %s", uuid)

        if (savedInstanceState == null)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fl_detail, DetailFragment())
                    .commit()
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
    }

}
