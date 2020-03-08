package ni.jugnicaragua.coyoteapp.util

import android.view.ViewGroup
import android.widget.EditText

fun ViewGroup.traveseAnyInput(): Boolean {
    var invalid = false
    loop@ for (i in 0 until this.childCount) {
        when (val child = this.getChildAt(i)) {
            is EditText -> {
                if (child.text!!.isEmpty()) return true
            }
            is ViewGroup -> {
                invalid = child.traveseAnyInput()
                if (invalid) break@loop
            }
        }
    }
    return invalid
}