package by.iapsit.notikeep.presentation.di

import by.iapsit.notikeep.presentation.mvi.ui.applications.ApplicationsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { ApplicationsViewModel(get()) }
}