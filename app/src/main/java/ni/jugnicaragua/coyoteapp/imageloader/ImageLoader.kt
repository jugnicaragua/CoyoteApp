package ni.jugnicaragua.coyoteapp.imageloader

import android.widget.ImageView

interface ImageLoader {
    fun load(imageUrl: String, imageView: ImageView)
}