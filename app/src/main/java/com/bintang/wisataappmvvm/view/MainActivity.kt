package com.bintang.wisataappmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bintang.wisataappmvvm.R
import com.bintang.wisataappmvvm.adapter.AdapterWisata
import com.bintang.wisataappmvvm.dagger.viewmodel.ViewWisataModelFactory
import com.bintang.wisataappmvvm.model.ResponseWisata
import com.bintang.wisataappmvvm.viewmodel.ViewModelWisata
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModel: ViewWisataModelFactory
    private lateinit var view : ViewModelWisata
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view = ViewModelProvider(this, viewModel).get(ViewModelWisata::class.java)
        observer()
        view.getData()
    }
    private fun observer() {
        view.isSuccess().observe(this, Observer { responseSuccess(it) })
        view.isError().observe(this, Observer { responseError(it) })
    }

    private fun responseError(it: Throwable?) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }

    private fun responseSuccess(it: ResponseWisata?) {
        Toast.makeText(this, "Sukses", Toast.LENGTH_SHORT).show()
        val data = AdapterWisata(it?.data)
        wisatalist.adapter = data
    }
}