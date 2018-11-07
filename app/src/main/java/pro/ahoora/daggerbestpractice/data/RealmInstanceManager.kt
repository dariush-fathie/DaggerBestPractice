package pro.ahoora.daggerbestpractice.data

import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerApplication
import dagger.android.support.DaggerFragment
import io.realm.Realm
import timber.log.Timber
import kotlin.reflect.KClass

class RealmInstanceManager {


    /**
     * this helper class will help you in managing realm instances
     */

    private val map = HashMap<Any, Realm>()
    private val tag = javaClass.name

    fun <T : Any> openRealm(hostClass: T, instance: Realm?): Realm {
        if (checkIfSupported(hostClass)) {
            if (!map.containsKey(hostClass)) {
                if (instance != null) {
                    map[hostClass] = instance
                }
            } else {
                Timber.e(tag, "already there is an instance of realm from the $hostClass")
            }
        }

        if (!map.containsKey(hostClass)) {
            throw RealmManagerInstanceException("$tag >>> already there is'nt any instance of realm from the $hostClass\n\t")
        }

        return map[hostClass]!!
    }

    fun <T : Any> closeRealm(hostClass: T): Boolean {
        if (checkIfSupported(hostClass)) {
            if (map.containsKey(hostClass)) {
                map.remove(hostClass)
                return true
            } else {
                Timber.e(tag, "already there is'nt any instance of realm from the $hostClass")
            }
        }
        return false
    }


    private fun <T : Any> checkIfSupported(hostClass: T): Boolean {
        if (hostClass is DaggerAppCompatActivity || hostClass is DaggerFragment || hostClass is DaggerApplication) {
            return true
        } else {
            throw RealmManagerException("$tag \n\t unsupported parameter; " +
                    "\n\t hostClass should be extends from classes below\n" +
                    "\t\timport dagger.android.support.DaggerAppCompatActivity\n" +
                    "\t\timport dagger.android.support.DaggerApplication\n" +
                    "\t\timport dagger.android.support.DaggerFragment ")
        }
    }

    private class RealmManagerException(message: String) : CloneNotSupportedException(message)
    private class RealmManagerInstanceException(message: String) : ClassNotFoundException(message)

}