package pro.ahoora.daggerbestpractice.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import pro.ahoora.daggerbestpractice.R
import pro.ahoora.daggerbestpractice.di.qualifiers.ApplicationContext

@Module
class SharedPrefsModule {

    @Provides
    fun provideSharedPrefs(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(context.getString(R.string.mainSharedPrefs), 0)
    }

}