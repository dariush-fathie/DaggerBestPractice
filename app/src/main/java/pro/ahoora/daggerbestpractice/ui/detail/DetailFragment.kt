package pro.ahoora.daggerbestpractice.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import pro.ahoora.daggerbestpractice.R
import pro.ahoora.daggerbestpractice.repository.local.LocalRESTApi
import timber.log.Timber
import javax.inject.Inject

class DetailFragment : DaggerFragment() {

    @Inject
    lateinit var localRESTApi: LocalRESTApi

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        Log.e("detail", view.toString())

        return view
    }

    override fun onStart() {
        super.onStart()

        Timber.e("detail Fragment %s", localRESTApi)
    }

}