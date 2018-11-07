package pro.ahoora.daggerbestpractice.repository.sharedprefs

import android.content.SharedPreferences
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import pro.ahoora.daggerbestpractice.utility.Constants
import javax.inject.Inject

class SharedPrefsManager @Inject constructor(private val sharedPreferences: SharedPreferences) : ISharedPrefs {

    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    override fun putString(key: String, value: String): Completable {
        return Completable.fromAction {
            editor.putString(key, value)
        }.subscribeOn(Schedulers.io())
    }

    override fun getString(key: String): Single<String> {
        return Single
                .fromCallable { return@fromCallable sharedPreferences.getString(key, Constants.defaultString) }
                .subscribeOn(Schedulers.io())
    }

    override fun putInt(key: String, value: Int): Completable {
        return Completable
                .fromAction { editor.putInt(key, value) }
                .subscribeOn(Schedulers.io())
    }

    override fun getInt(key: String): Single<Int> {
        return Single
                .fromCallable { return@fromCallable sharedPreferences.getInt(key, Constants.defaultInt) }
                .subscribeOn(Schedulers.io())
    }

    override fun putFloat(key: String, value: Float): Completable {
        return Completable
                .fromAction { editor.putFloat(key, value) }
                .subscribeOn(Schedulers.io())
    }

    override fun getFloat(key: String): Single<Float> {
        return Single
                .fromCallable { return@fromCallable sharedPreferences.getFloat(key, Constants.defaultFloat) }
                .subscribeOn(Schedulers.io())
    }

    override fun putStringList(key: String, value: MutableSet<String>): Completable {
        return Completable
                .fromAction { editor.putStringSet(key, value) }
                .subscribeOn(Schedulers.io())
    }

    override fun getStringList(key: String): Single<MutableSet<String>> {
        return Single
                .fromCallable { return@fromCallable sharedPreferences.getStringSet(key, setOf()) }
                .subscribeOn(Schedulers.io())
    }


}