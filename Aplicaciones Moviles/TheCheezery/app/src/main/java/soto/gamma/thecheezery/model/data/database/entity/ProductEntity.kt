package soto.gamma.thecheezery.model.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idProduct")
    val id: Int = 0,
    @ColumnInfo(name = "nameProduct")
    val name: String,
    @ColumnInfo(name = "priceProduct")
    val price: Float,
    @ColumnInfo(name = "imageProduct")
    val imageRes: Int,
    @ColumnInfo(name = "category")
    val category: String
)
