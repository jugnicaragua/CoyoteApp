package ni.jugnicaragua.coyoteapp.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ni.jugnicaragua.coyoteapp.ui.viewHolder.BankViewHolder
import ni.jugnicaragua.coyoteapp.imageloader.ImageLoader
import ni.jugnicaragua.coyoteapp.model.exchangeRate.ExchangeRate

class ExchangeRateAdapter() : ListAdapter<ExchangeRate, BankViewHolder>(DIFF_CALLBACK){
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ExchangeRate>() {
            override fun areItemsTheSame(oldItem: ExchangeRate, newItem: ExchangeRate) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: ExchangeRate, newItem: ExchangeRate) = oldItem == newItem
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BankViewHolder.create(parent)
    override fun onBindViewHolder(holder: BankViewHolder, position: Int) = holder.bind(getItem(position))
}