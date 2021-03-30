package com.bintang.wisataappmvvm.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bintang.wisataappmvvm.R
import com.bintang.wisataappmvvm.model.DataItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_activity.view.*

class AdapterWisata(val data: List<DataItem?>?): RecyclerView.Adapter<AdapterWisata.AdapterViewHolder>(){
    class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(get: DataItem) {
            val imageView = itemView.findViewById<ImageView>(R.id.image)
            val textView = itemView.findViewById<TextView>(R.id.text)

            textView.text = get.namaTempat
            Glide.with(itemView.context)
                    .load(get.gambar)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        val holder = AdapterViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        data?.get(position).let { it?.let { it1 -> holder.bindView(it1) } }
    }

    override fun getItemCount(): Int = data?.size?: 0
}