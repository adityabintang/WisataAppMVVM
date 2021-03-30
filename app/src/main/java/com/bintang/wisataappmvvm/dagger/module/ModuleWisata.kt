package com.bintang.wisataappmvvm.dagger.module

import com.bintang.wisataappmvvm.network.RestApi
import com.bintang.wisataappmvvm.repository.RepositoryWisata
import com.bintang.wisataappmvvm.viewmodel.ViewModelWisata
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class ModuleWisata {
    @Module
    companion object{

        @JvmStatic
        @Provides
        fun provideConfigNetwork(retrofit: Retrofit): RestApi =
                retrofit.create(RestApi::class.java)

        @JvmStatic
        @Provides
        fun providesRepo(restApi: RestApi): RepositoryWisata = RepositoryWisata(restApi)

        @JvmStatic
        @Provides
        fun providesViewModel(repo: RepositoryWisata): ViewModelWisata = ViewModelWisata(repo)
    }
}