package ni.jugnicaragua.coyoteapp.model.exchangeRate

import androidx.room.Entity

@Entity(tableName = "ExchangeRate", primaryKeys = ["id"])
data class ExchangeRate(
    val bank: String, // LAFISE
    val bestBuyPrice: Boolean, // false
    val bestSellPrice: Boolean, // true
    val buy: Double, // 33.4800
    val createdOn: String, // 2020-03-08T04:00:21.17
    val currency: String, // DOLAR ($)
    val date: String, // 2020-03-08
    val id: Int, // 535
    val sell: Double, // 34.2400
    val updatedOn: Any // null
)