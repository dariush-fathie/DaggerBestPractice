package pro.ahoora.daggerbestpractice.repository.remote

import android.database.Observable
import pro.ahoora.daggerbestpractice.data.models.User
import retrofit2.http.GET

interface RemoteRESTApi {

    @GET
    fun getAllRemotePatients(): Observable<User>
}