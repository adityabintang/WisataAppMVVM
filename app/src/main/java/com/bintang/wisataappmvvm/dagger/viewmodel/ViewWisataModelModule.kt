package com.bintang.wisataappmvvm.dagger.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bintang.wisataappmvvm.viewmodel.ViewModelWisata
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass


@Module
abstract class ViewWisataModelModule {

    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewWisataModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelWisata::class)
    abstract fun bindViewModel(viewMode: ViewModelWisata): ViewModel
}