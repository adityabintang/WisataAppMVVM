package com.bintang.wisataappmvvm.network

import com.bintang.wisataappmvvm.BuildConfig
import com.bintang.wisataappmvvm.constant.ConstantWisata
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkConfigWisata {

    @Provides
    @Singleton
    fun providesHttpLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = when(BuildConfig.DEBUG) {
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }
    @Provides
    @Singleton
    fun provideInterceptor(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            addInterceptor(interceptor)
        }.build()
    }
    @Provides
    @Singleton
    fun providesRetrofit(client: OkHttpClient): Retrofit {

        var constant : ConstantWisata
        constant = ConstantWisata()
        return Retrofit.Builder().apply {
            client(client)
            baseUrl(constant.URL)
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        }.build()
    }


}