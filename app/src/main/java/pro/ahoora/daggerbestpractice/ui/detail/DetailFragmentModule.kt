package pro.ahoora.daggerbestpractice.ui.detail

import dagger.Module
import dagger.Provides
import pro.ahoora.daggerbestpractice.di.scopes.PerFragment
import java.nio.charset.Charset

@Module
class DetailFragmentModule {

    @PerFragment
    @Provides
    fun provide(): Charset {
        return Charset.defaultCharset()
    }

}