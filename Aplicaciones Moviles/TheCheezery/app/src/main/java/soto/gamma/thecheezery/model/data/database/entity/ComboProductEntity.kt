package soto.gamma.thecheezery.model.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "ComboProducts",
    primaryKeys = ["idCombo", "idProduct"],
    foreignKeys = [
        ForeignKey(
            entity = ComboEntity::class,
            parentColumns = ["id"],
            childColumns = ["idCombo"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ProductEntity::class,
            parentColumns = ["idProduct"],
            childColumns = ["idProduct"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["idCombo"]),
        Index(value = ["idProduct"])
    ]
)
data class ComboProductEntity(
    @ColumnInfo(name = "idCombo")
    val idCombo: Int,
    @ColumnInfo(name = "idProduct")
    val idProduct: Int
)
