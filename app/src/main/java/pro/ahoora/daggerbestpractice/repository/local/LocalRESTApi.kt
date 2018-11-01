package pro.ahoora.daggerbestpractice.repository.local

import android.database.Observable
import pro.ahoora.daggerbestpractice.data.models.User
import retrofit2.http.GET

interface LocalRESTApi {

    @GET
    fun getAllLocalPatients(): Observable<User>
}