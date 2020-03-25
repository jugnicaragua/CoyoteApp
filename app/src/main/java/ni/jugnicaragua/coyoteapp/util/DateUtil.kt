package ni.jugnicaragua.coyoteapp.util

import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}

fun getCalendar(): Calendar = Calendar.getInstance()

fun String.getStringDate(initialFormat: String, requiredFormat: String, locale: Locale = Locale.getDefault()): String {
    return this.toDate(initialFormat, locale).toString(requiredFormat, locale)
}

fun String.toDate(format: String, locale: Locale = Locale.getDefault()): Date = SimpleDateFormat(format, locale).parse(this)!!

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

fun Calendar.addDay(): Date{
    this.add(Calendar.DATE, 1)
    return this.time
}

fun Calendar.sustractDay() : Date {
    this.add(Calendar.DATE, -1)
    return this.time
}

fun Calendar.getFirstDayWeek(): Date{
    this.add(Calendar.DAY_OF_MONTH, Calendar.MONDAY - this[Calendar.DAY_OF_WEEK])
    return this.time
}

fun Calendar.geLastDayWeek(): Date{
    this.add(Calendar.DATE, 6)
    return this.time
}