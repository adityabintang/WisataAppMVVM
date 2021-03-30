package com.bintang.wisataappmvvm.dagger

import com.bintang.wisataappmvvm.dagger.component.DaggerWisataComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AppWisata : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerWisataComponent.builder().application(this).build()
    }
}