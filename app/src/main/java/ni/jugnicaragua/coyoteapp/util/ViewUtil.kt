package ni.jugnicaragua.coyoteapp.util

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.*
import android.widget.EditText
import android.widget.FrameLayout
import androidx.core.view.ViewCompat


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

fun Activity.transparentStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        this.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        this.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        this.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        this.window.statusBarColor = Color.TRANSPARENT
    } else {
        this.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    }
}