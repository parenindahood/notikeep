package by.iapsit.notikeep.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import by.iapsit.notikeep.data.db.entities.PackageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PackagesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPackage(packageEntity: PackageEntity)

    @Query("SELECT * FROM packages WHERE is_favourite = 0")
    fun getPackages(): Flow<List<PackageEntity>>
}