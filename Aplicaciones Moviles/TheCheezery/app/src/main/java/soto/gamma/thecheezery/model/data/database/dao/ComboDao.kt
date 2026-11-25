package soto.gamma.thecheezery.model.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import soto.gamma.thecheezery.model.data.database.entity.ComboEntity
import soto.gamma.thecheezery.model.data.database.entity.ComboProductEntity
import soto.gamma.thecheezery.model.data.database.relation.ComboWithProducts

@Dao
interface ComboDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCombo(combo: ComboEntity): Long

    @Update
    suspend fun updateCombo(combo: ComboEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComboProducts(comboProducts: List<ComboProductEntity>)

    @Query("DELETE FROM Combos")
    suspend fun clearCombos()

    @Transaction
    @Query("SELECT * FROM Combos")
    suspend fun getAllCombos(): List<ComboWithProducts>

    @Transaction
    @Query("SELECT * FROM Combos WHERE id = :id")
    suspend fun getComboById(id: Int): ComboWithProducts?
}
