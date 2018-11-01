package pro.ahoora.daggerbestpractice.ui.detail

import dagger.Module
import dagger.Provides
import java.nio.charset.Charset

@Module
class DetailFragmentModule {

    @Provides
    fun provide(): Charset {
        return Charset.defaultCharset()
    }

}