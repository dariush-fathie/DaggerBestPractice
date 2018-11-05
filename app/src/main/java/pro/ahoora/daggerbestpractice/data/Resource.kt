package pro.ahoora.daggerbestpractice.data

import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

class Resource<T>(
        @NotNull message: String = "",
        @Nullable data: T? = null,
        @Nullable status: Status? = null
) {


    companion object INSTANCE {

        fun <T> success(@Nullable message: String, @Nullable data: T): Resource<T> {
            return Resource(message, data, Status.SUCCESS)
        }

        fun <T> error(@Nullable message: String, @Nullable data: T): Resource<T> {
            return Resource(message, data, Status.ERROR)
        }

        fun <T> loading(@Nullable message: String, @Nullable data: T): Resource<T> {
            return Resource(message, data, Status.LOADING)
        }

        fun <T> pending(@Nullable message: String, @Nullable data: T): Resource<T> {
            return Resource(message, data, Status.PENDING)
        }

    }

    enum class Status {
        SUCCESS, ERROR, LOADING, PENDING
    }

}