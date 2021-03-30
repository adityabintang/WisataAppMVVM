package com.bintang.wisataappmvvm.network

import com.bintang.wisataappmvvm.model.ResponseWisata
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface RestApi {

    @GET("?action=findAll")
    fun getWosata():Flowable<ResponseWisata>
}