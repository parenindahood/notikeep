package by.iapsit.notikeep.presentation.mvi.ui.applications

import androidx.lifecycle.viewModelScope
import by.iapsit.notikeep.domain.usecases.GetPackagesUseCase
import by.iapsit.notikeep.presentation.mvi.base.BaseViewModel
import kotlinx.coroutines.launch

class ApplicationsViewModel(
    private val getPackages: GetPackagesUseCase
) : BaseViewModel<ApplicationsContract.Action, ApplicationsContract.State, ApplicationsContract.Effect>() {

    override fun createInitialState() = ApplicationsContract.State.Loading

    override suspend fun handleAction(action: ApplicationsContract.Action) {}

    init {
        viewModelScope.launch {
            getPackages().collect {
                setState { ApplicationsContract.State.ShowApplicationList(it) }
            }
        }
    }
}