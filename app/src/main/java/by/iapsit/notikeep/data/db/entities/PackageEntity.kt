package by.iapsit.notikeep.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import by.iapsit.notikeep.domain.entities.PackageData

private const val PACKAGES_TABLE_NAME = "packages"
private const val PACKAGE_NAME_COLUMN_NAME = "package_name"
private const val IS_FAVOURITE_COLUMN_NAME = "is_favourite"

@Entity(primaryKeys = [PACKAGE_NAME_COLUMN_NAME], tableName = PACKAGES_TABLE_NAME)
data class PackageEntity(
    @ColumnInfo(name = PACKAGE_NAME_COLUMN_NAME) val packageName: String,
    @ColumnInfo(name = IS_FAVOURITE_COLUMN_NAME) val isFavourite: Boolean
)

fun PackageData.toEntity() = PackageEntity(packageName, isFavourite)

fun PackageEntity.toModel() = PackageData(packageName, isFavourite)

fun List<PackageEntity>.toModel() = map { it.toModel() }