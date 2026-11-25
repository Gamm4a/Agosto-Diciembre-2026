package soto.gamma.thecheezery.model.data.repository

import soto.gamma.thecheezery.model.data.database.dao.ComboDao
import soto.gamma.thecheezery.model.data.database.dao.ProductDao
import soto.gamma.thecheezery.model.data.database.entity.ComboEntity
import soto.gamma.thecheezery.model.data.database.entity.ComboProductEntity
import soto.gamma.thecheezery.model.data.database.entity.ProductEntity
import soto.gamma.thecheezery.model.data.database.relation.ComboWithProducts

class CheezeryRepository(
    private val productDao: ProductDao,
    private val comboDao: ComboDao
) {
    suspend fun insertProduct(product: ProductEntity): Long =
        productDao.insertProduct(product)

    suspend fun insertProducts(products: List<ProductEntity>) =
        productDao.insertProducts(products)

    suspend fun updateProduct(product: ProductEntity) =
        productDao.updateProduct(product)

    suspend fun getAllProducts(): List<ProductEntity> =
        productDao.getAllProducts()

    suspend fun getProductsByCategory(category: String): List<ProductEntity> =
        productDao.getProductsByCategory(category)

    suspend fun getProductById(id: Int): ProductEntity? =
        productDao.getProductById(id)

    suspend fun insertCombo(
        name: String,
        price: Float,
        productIds: List<Int>
    ): ComboEntity {
        val comboId = comboDao.insertCombo(
            ComboEntity(name = name, price = price)
        ).toInt()

        comboDao.insertComboProducts(
            productIds.distinct().map { productId ->
                ComboProductEntity(comboId, productId)
            }
        )

        return ComboEntity(comboId, name, price)
    }

    suspend fun updateCombo(combo: ComboEntity) =
        comboDao.updateCombo(combo)

    suspend fun getAllCombos(): List<ComboWithProducts> =
        comboDao.getAllCombos()

    suspend fun getComboById(id: Int): ComboWithProducts? =
        comboDao.getComboById(id)
}
