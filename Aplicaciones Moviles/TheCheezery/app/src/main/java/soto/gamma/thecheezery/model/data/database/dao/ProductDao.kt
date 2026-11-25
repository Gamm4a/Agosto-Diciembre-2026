package soto.gamma.thecheezery.model.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import soto.gamma.thecheezery.model.data.database.entity.ProductEntity

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: ProductEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity>)

    @Update
    suspend fun updateProduct(product: ProductEntity)

    @Query("DELETE FROM Products")
    suspend fun clearProducts()

    @Query("SELECT * FROM Products")
    suspend fun getAllProducts(): List<ProductEntity>

    @Query("SELECT * FROM Products WHERE category = :category")
    suspend fun getProductsByCategory(category: String): List<ProductEntity>

    @Query("SELECT * FROM Products WHERE idProduct = :id")
    suspend fun getProductById(id: Int): ProductEntity?
}
