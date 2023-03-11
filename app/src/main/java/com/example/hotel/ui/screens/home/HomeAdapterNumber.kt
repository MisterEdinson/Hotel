package com.example.hotel.ui.screens.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotel.R
import com.example.hotel.domain.model.detailsModel.ResponseItem
import com.example.hotel.utils.Constans.Companion.BASE_IMG
import kotlinx.android.synthetic.main.item_number.view.*

class HomeAdapterNumber : RecyclerView.Adapter<HomeAdapterNumber.AdapterNumber>() {

    private var listNumber = emptyList<ResponseItem>()

    class AdapterNumber(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNumber {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_number, parent, false)
        return AdapterNumber(view)
    }

    override fun onBindViewHolder(holder: AdapterNumber, position: Int) {
        val article = listNumber[position]
        holder.itemView.apply {
            Glide.with(this).load(BASE_IMG + article.genImg).into(imgRV)
            tvHeaderTitle.text = article.name
            tvDescription.text = article.mDesc
            tvPrice.text = article.price


            val textId = article.id?.toInt()
            val bundle = Bundle()
            itemHome.setOnClickListener { bund ->
                textId?.let { bund -> bundle.putInt("id", bund) }
                findNavController().navigate(R.id.detailsFragment, bundle)
            }
            btnDetails.setOnClickListener { bund ->
                textId?.let { bund -> bundle.putInt("id", bund) }
                findNavController().navigate(R.id.detailsFragment, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return listNumber.size
    }

    fun setList(list: List<ResponseItem>) {
        listNumber = list
        notifyDataSetChanged()
    }
}


