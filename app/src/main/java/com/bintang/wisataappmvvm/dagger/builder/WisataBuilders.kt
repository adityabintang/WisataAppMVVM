package com.bintang.wisataappmvvm.dagger.builder

import com.bintang.wisataappmvvm.dagger.module.ModuleWisata
import com.bintang.wisataappmvvm.dagger.viewmodel.ViewWisataModelModule
import com.bintang.wisataappmvvm.repository.RepositoryWisata
import com.bintang.wisataappmvvm.scope.PresentationWisata
import com.bintang.wisataappmvvm.view.MainActivity
import com.bintang.wisataappmvvm.viewmodel.ViewModelWisata
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class WisataBuilders {
    @PresentationWisata
    @ContributesAndroidInjector(
            modules = [
                ModuleWisata::class
            ]
    )
    abstract fun contributeRepository(): RepositoryWisata

    @PresentationWisata
    @ContributesAndroidInjector(
            modules = [
                ModuleWisata::class
            ]
    )
    abstract fun contributeViewModel(): ViewModelWisata

    @PresentationWisata
    @ContributesAndroidInjector(
            modules = [
                ViewWisataModelModule::class
            ]
    )
    abstract fun contributeMainActivity(): MainActivity


}