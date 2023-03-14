package com.example.hotel.ui.screens.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotel.R
import com.example.hotel.utils.Constans.Companion.BASE_URL
import kotlinx.android.synthetic.main.item_details.view.*

class DetailViewPagerAdapter : RecyclerView.Adapter<DetailViewPagerAdapter.ViewPagerAdapter>() {
    private var image:List<String> = emptyList()
    class ViewPagerAdapter(view: View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_details,parent,false)
        return ViewPagerAdapter(view)
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter, position: Int) {
        val item = image[position]
        holder.itemView.apply {
            Glide.with(this).load(BASE_URL + item).into(imgItemDetails)
            imgItemDetails.setOnClickListener{
                Toast.makeText(context,item, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return image.size
    }
    fun setList(list: List<String>){
        image = list
        notifyDataSetChanged()
    }
}

