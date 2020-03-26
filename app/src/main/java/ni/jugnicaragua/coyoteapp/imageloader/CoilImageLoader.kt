package ni.jugnicaragua.coyoteapp.imageloader

import android.widget.ImageView
import coil.api.load
import coil.request.CachePolicy
import ni.jugnicaragua.coyoteapp.R

class CoilImageLoader : ImageLoader {
    override fun load(imageUrl: String, imageView: ImageView) {
        imageView.load(imageUrl){
            crossfade(true)
            error(R.drawable.ic_error)
            placeholder(R.drawable.ic_launcher_foreground)
            memoryCachePolicy(CachePolicy.ENABLED)
        }
    }

    override fun load(imageSrc: Int, imageView: ImageView) {
        imageView.load(imageSrc){
            placeholder(R.drawable.ic_launcher_foreground)
        }
    }
}