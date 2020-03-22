package ni.jugnicaragua.coyoteapp.util

import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}

fun String.getStringDate(initialFormat: String, requiredFormat: String, locale: Locale = Locale.getDefault()): String {
    return this.toDate(initialFormat, locale).toString(requiredFormat, locale)
}

fun String.toDate(format: String, locale: Locale = Locale.getDefault()): Date = SimpleDateFormat(format, locale).parse(this)!!

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}