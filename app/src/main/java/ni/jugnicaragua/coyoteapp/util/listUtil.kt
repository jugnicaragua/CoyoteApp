package ni.jugnicaragua.coyoteapp.util

inline fun <reified T> toList(list: List<*>): List<T> {
    return (list as List<T>).toList()
}