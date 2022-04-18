package by.iapsit.notikeep.domain.entities

data class PackageData(
    val packageName: String,
    val isFavourite: Boolean = false
)