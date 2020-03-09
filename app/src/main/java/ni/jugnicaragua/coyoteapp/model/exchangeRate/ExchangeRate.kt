package ni.jugnicaragua.coyoteapp.model.exchangeRate

import androidx.room.Entity

@Entity(tableName = "ExchangeRate", primaryKeys = ["id"], ignoredColumns = ["updatedOn"])
data class ExchangeRate(
    var bank: String = "", // LAFISE
    var bestBuyPrice: Boolean = false, // false
    var bestSellPrice: Boolean = false, // true
    var buy: Double = 0.0, // 33.4800
    var createdOn: String = "", // 2020-03-08T04:00:21.17
    var currency: String = "", // DOLAR ($)
    var date: String = "", // 2020-03-08
    var id: Int = 0, // 535
    var sell: Double = 0.0, // 34.2400
    var updatedOn: Any = Any() // null
)