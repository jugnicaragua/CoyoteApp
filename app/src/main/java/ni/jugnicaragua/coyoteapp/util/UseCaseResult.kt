package ni.jugnicaragua.coyoteapp.util

import java.io.IOException

sealed class UseCaseResult<out T> {
    class Success<out T : Any>(val data: T) : UseCaseResult<T>()
    class Error(val exception: Failure.UnDefined) : UseCaseResult<Nothing>()
}

sealed class Failure : IOException() {
    object ServerException : Failure()
    object Unauthorized : Failure()
    class UnDefined(msg: String) : Failure()
}