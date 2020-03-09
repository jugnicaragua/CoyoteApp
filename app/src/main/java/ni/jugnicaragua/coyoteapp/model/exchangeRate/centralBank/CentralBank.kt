package ni.jugnicaragua.coyoteapp.model.exchangeRate.centralBank

import androidx.room.Entity

@Entity(tableName = "CentralBank", primaryKeys = ["id"], ignoredColumns = ["updatedOn"])
data class CentralBank(
    var amount: Double = 0.0, // 34.0877
    var createdOn: String = "", // 2020-02-21T06:15:01.166
    var currency: String = "", // DOLAR ($)
    var date: String = "", // 2020-03-31
    var id: Int = 0, // 20200331
    var updatedOn: Any = Any() // null
)