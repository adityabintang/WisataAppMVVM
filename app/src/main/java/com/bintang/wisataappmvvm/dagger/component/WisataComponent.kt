package com.bintang.wisataappmvvm.dagger.component

import android.app.Application
import com.bintang.wisataappmvvm.dagger.AppWisata
import com.bintang.wisataappmvvm.dagger.builder.WisataBuilders
import com.bintang.wisataappmvvm.dagger.module.ModuleWisata
import com.bintang.wisataappmvvm.dagger.viewmodel.ViewWisataModelModule
import com.bintang.wisataappmvvm.network.NetworkConfigWisata
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        WisataBuilders::class,
        ModuleWisata::class,
        NetworkConfigWisata::class,
        ViewWisataModelModule::class

    ]
)
interface WisataComponent : AndroidInjector<AppWisata> {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): WisataComponent
    }
}