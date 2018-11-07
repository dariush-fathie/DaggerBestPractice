package pro.ahoora.daggerbestpractice.repository.sharedprefs

import io.reactivex.Completable
import io.reactivex.Single

interface ISharedPrefs {

    fun putString(key: String, value: String): Completable
    fun getString(key: String): Single<String>

    fun putInt(key: String, value: Int): Completable
    fun getInt(key: String): Single<Int>

    fun putFloat(key: String, value: Float): Completable
    fun getFloat(key: String): Single<Float>

    fun putStringList(key: String, value: MutableSet<String>): Completable
    fun getStringList(key: String): Single<MutableSet<String>>

}