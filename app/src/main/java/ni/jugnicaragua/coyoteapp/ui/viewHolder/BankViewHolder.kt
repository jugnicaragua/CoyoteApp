package ni.jugnicaragua.coyoteapp.ui.viewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.bank_content.*
import ni.jugnicaragua.coyoteapp.R
import ni.jugnicaragua.coyoteapp.imageloader.ImageLoader
import ni.jugnicaragua.coyoteapp.model.exchangeRate.ExchangeRate

class BankViewHolder constructor(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(exchangeRate: ExchangeRate) {
        //plantImage?.let { imageLoader.load("${BuildConfig.COYOTE_SERVICE}/gallery/${plant.image}", it) }
        sellValue.text = exchangeRate.sell.toString()
        purchaseValue.text = exchangeRate.buy.toString()

        //plantImage.layoutParams.height = ImageSizer().getRandomIntInRange(250, 180)
    }

    companion object {
        fun create(parent: ViewGroup): BankViewHolder {
            return BankViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.banks_card, parent, false))
        }
    }
}