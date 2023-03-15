package com.example.hotel.ui.screens.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotel.R
import com.example.hotel.utils.Constans.Companion.BASE_URL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_gallery.view.*


class GalleryAdapter(
    val imageShow: (String) -> Unit
) : RecyclerView.Adapter<GalleryAdapter.AdapterImage>() {
    private var listImage = emptyList<String>()

    class AdapterImage(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterImage {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery,parent,false)
        return AdapterImage(view)
    }

    override fun onBindViewHolder(holder: AdapterImage, position: Int) {
        holder.itemView.apply {
            val item = listImage[position]
//            Glide.with(this).load(BASE_URL + listImage[position]).into(imgGallery)
            Picasso.with(context)
                .load(BASE_URL + item)
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .into(imgGallery)

            imgGallery.setOnClickListener{
                imageShow(item)
            }
        }
    }
    override fun getItemCount(): Int {
        return listImage.size
    }

    fun setList(list : List<String>){
        listImage = list
        notifyDataSetChanged()
    }
}




