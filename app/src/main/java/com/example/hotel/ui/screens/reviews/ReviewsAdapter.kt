package com.example.hotel.ui.screens.reviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.example.hotel.R
import com.example.hotel.domain.model.reviewsModel.ResponseReviewsItem
import kotlinx.android.synthetic.main.item_reviews.view.*

class ReviewsAdapter : RecyclerView.Adapter<ReviewsAdapter.ReviewsHolder>(){
    var listReviews = emptyList<ResponseReviewsItem>()
    class ReviewsHolder (view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_reviews,parent,false)
        return ReviewsHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewsHolder, position: Int) {
        val article = listReviews[position]
        holder.itemView.apply {
            tvTitleReviews.text = article.name
            tvCityReviews.text = article.city
            tvDescReviews.text = article.descript
        }
    }

    override fun getItemCount(): Int {
        return listReviews.size
    }

    fun setList(list : List<ResponseReviewsItem>){
        listReviews = list
        notifyDataSetChanged()
    }
}