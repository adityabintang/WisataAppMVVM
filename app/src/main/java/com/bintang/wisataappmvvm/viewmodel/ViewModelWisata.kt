package com.bintang.wisataappmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bintang.wisataappmvvm.model.ResponseWisata
import com.bintang.wisataappmvvm.repository.RepositoryWisata

class ViewModelWisata(var repo: RepositoryWisata) : ViewModel() {

    var success = MutableLiveData<ResponseWisata>()
    var error = MutableLiveData<Throwable>()

    fun getData() {
        repo.getData({
            success.value = it
        }, {
            error.value = it
        })
    }

    fun isSuccess(): LiveData<ResponseWisata> {
        return success
    }
    fun isError(): LiveData<Throwable> {
        return error
    }
}
