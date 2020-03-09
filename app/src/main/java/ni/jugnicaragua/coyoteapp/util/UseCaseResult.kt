package ni.jugnicaragua.coyoteapp.util

sealed class UseCaseResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : UseCaseResult<T>()
    object Error: UseCaseResult<Nothing>()
}
