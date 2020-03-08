package ni.jugnicaragua.coyoteapp.data.network

import kotlinx.coroutines.delay
import java.io.IOException

class Retry {
    suspend fun <T> retryIO(times: Int = Int.MAX_VALUE, initialDelay: Long = 100, maxDelay: Long = 1000, factor: Double = 2.0, block: suspend () -> T): T {
        var currentDelay = initialDelay
        repeat(times - 1) {
            try {
                return block()
            } catch (e: IOException) { }
            delay(currentDelay)
            currentDelay = (currentDelay * factor).toLong().coerceAtMost(maxDelay)
        }
        return block()
    }
}