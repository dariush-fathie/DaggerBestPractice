package pro.ahoora.daggerbestpractice.ui.detail

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import pro.ahoora.daggerbestpractice.R
import pro.ahoora.daggerbestpractice.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject


class DetailActivity : BaseActivity() /*,AppBarLayout.OnOffsetChangedListener*/ {


    @Inject
    lateinit var uuid: String

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var detailViewModel: DetailViewModel

    /*private var leftMarginDP: Int = 72 - 16
    private var bottomMarginDP: Int = 16 - 8
    private var bottomMarginPx: Int = 0
    private var leftMarginPX: Int = 0
    private var appBarLayoutTotalScrollRange: Int = 0
*/

    /*override fun onStart() {
        super.onStart()
        leftMarginPX = Converter.pxFromDp(this, leftMarginDP.toFloat()).toInt()
        bottomMarginPx = Converter.pxFromDp(this, bottomMarginDP.toFloat()).toInt()
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        /*setSupportActionBar(toolbar)
        appBarLayout.addOnOffsetChangedListener(this)

        appBarLayout.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                appBarLayoutTotalScrollRange = appBarLayout.totalScrollRange
                //Timber.i("totalScroll range %d", appBarLayoutTotalScrollRange)
                appBarLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })
        */

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


    /*override fun onOffsetChanged(p0: AppBarLayout?, offset: Int) {
        //iv_logo.translationX = offset
        Timber.d("offset %d", offset)
        val translationX = Math.abs((offset.toFloat() / appBarLayoutTotalScrollRange.toFloat()) * leftMarginPX)
        val translationY = Math.abs((offset.toFloat() / appBarLayoutTotalScrollRange.toFloat()) * bottomMarginPx)
        Timber.d("translationX %f", translationX)
        Timber.d("translationY %f", translationY)
        iv_logo.translationX = translationX
        iv_logo.translationY = translationY

        when {
            offset == 0 -> {
                // expanded
            }
            Math.abs(offset) >= appBarLayout.totalScrollRange -> {
                // collapsed

            }
            else -> {
                // idle

            }
        }
    }*/


}
