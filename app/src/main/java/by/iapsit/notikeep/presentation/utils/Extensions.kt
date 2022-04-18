package by.iapsit.notikeep.presentation.utils

import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult

fun List<Any>.isIndexLast(index: Int) = index == size - 1

suspend fun SnackbarHostState.showSnackBarWithAction(
    message: String,
    actionLabel: String,
    duration: SnackbarDuration = SnackbarDuration.Short,
    callback: () -> Unit
) {
    val result = showSnackbar(message, actionLabel, duration)
    if (result == SnackbarResult.ActionPerformed) callback()
}