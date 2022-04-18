package by.iapsit.notikeep.presentation.mvi.ui.applications

import by.iapsit.notikeep.domain.entities.PackageData
import by.iapsit.notikeep.presentation.mvi.base.UiAction
import by.iapsit.notikeep.presentation.mvi.base.UiEffect
import by.iapsit.notikeep.presentation.mvi.base.UiState

class ApplicationsContract {

    sealed class Action : UiAction

    sealed class State : UiState {
        object Loading: State()
        data class ShowApplicationList(val packages: List<PackageData>): State()
    }

    sealed class Effect : UiEffect
}