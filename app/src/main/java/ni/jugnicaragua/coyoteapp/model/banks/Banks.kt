package ni.jugnicaragua.coyoteapp.model.banks

import androidx.room.Entity

@Entity(tableName = "Banks", primaryKeys = ["id"], ignoredColumns = ["cookies", "updatedOn"])
data class Banks(
    var active: Boolean = false, // true
    var cookies: List<Any> = emptyList(),
    var createdOn: String = "", // 2019-11-23T14:39:04.635
    var description: String = "", // AVANZ
    var id: Int = 0, // 3
    var shortDescription: String = "", // AVANZ
    var updatedOn: Any = Any(), // null
    var url: String = "" // https://www.avanzbanc.com/Pages/Empresas/ServiciosFinancieros/MesaCambio.aspx
)