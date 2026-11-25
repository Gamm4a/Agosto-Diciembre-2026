package soto.gamma.thecheezery.model.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import soto.gamma.thecheezery.model.data.database.dao.ComboDao
import soto.gamma.thecheezery.model.data.database.dao.ProductDao
import soto.gamma.thecheezery.model.data.database.entity.ComboEntity
import soto.gamma.thecheezery.model.data.database.entity.ComboProductEntity
import soto.gamma.thecheezery.model.data.database.entity.ProductEntity

@Database(
    entities = [
        ProductEntity::class,
        ComboEntity::class,
        ComboProductEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun comboDao(): ComboDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "the_cheezery.db"
                ).fallbackToDestructiveMigration().build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
