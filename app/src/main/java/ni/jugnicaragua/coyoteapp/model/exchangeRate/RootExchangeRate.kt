package ni.jugnicaragua.coyoteapp.model.exchangeRate

import androidx.annotation.Keep

@Keep
data class RootExchangeRate(
    val `data`: List<ExchangeRate>,
    val size: Int // 6
)