package net.npike.poc.workmanagertest.di

import net.npike.poc.workmanagertest.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        MainViewModel(
            workManager = get()
        )
    }
}