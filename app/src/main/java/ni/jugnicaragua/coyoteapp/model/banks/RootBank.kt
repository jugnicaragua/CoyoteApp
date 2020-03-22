package ni.jugnicaragua.coyoteapp.model.banks

import androidx.annotation.Keep

@Keep
data class RootBank(
    val `data`: List<Banks>,
    val size: Int // 6
)