package soto.gamma.thecheezery.model.data.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import soto.gamma.thecheezery.model.data.database.entity.ComboEntity
import soto.gamma.thecheezery.model.data.database.entity.ComboProductEntity
import soto.gamma.thecheezery.model.data.database.entity.ProductEntity

data class ComboWithProducts(
    @Embedded
    val combo: ComboEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "idProduct",
        associateBy = Junction(
            value = ComboProductEntity::class,
            parentColumn = "idCombo",
            entityColumn = "idProduct"
        )
    )
    val products: List<ProductEntity>
)
