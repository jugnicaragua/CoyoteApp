package ni.jugnicaragua.coyoteapp.model.exchangeRate.centralBank

import androidx.annotation.Keep

@Keep
data class RootCentralBank(
    val `data`: List<CentralBank>,
    val size: Int // 6
)