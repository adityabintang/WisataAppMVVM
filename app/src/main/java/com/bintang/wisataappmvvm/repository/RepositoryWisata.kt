package com.bintang.wisataappmvvm.repository

import com.bintang.wisataappmvvm.model.ResponseWisata
import com.bintang.wisataappmvvm.network.RestApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class RepositoryWisata( val restApi: RestApi) {
    fun getData(
        isSuccess: (ResponseWisata)-> Unit,
        isError: (Throwable) -> Unit
    ) {
        restApi.getWosata()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                isSuccess(it)
            }, {
                isError(it)
            })
    }
}