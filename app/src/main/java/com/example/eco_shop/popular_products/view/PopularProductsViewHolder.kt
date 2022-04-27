package com.example.eco_shop.popular_products.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eco_shop.R
import com.example.eco_shop.popular_products.models.PopularProductsApiData

class PopularProductsViewHolder(
    itemView: View,
    private val popularProductsClickListener: PopularProductsClickListener
): RecyclerView.ViewHolder(itemView) {


    private val popularProductsTitleTextView: TextView = itemView.findViewById(R.id.popular_food_item_title)
    private val popularProductsImage: ImageView = itemView.findViewById(R.id.popular_food_item_image)
    private val popularProductsFavoriteImage: ImageView = itemView.findViewById(R.id.popular_food_item_favorite_image)
    private val popularProductsCostTextView: TextView = itemView.findViewById(R.id.popular_food_item_cost)


    fun onBind(popularProductsApiData: PopularProductsApiData) {

        Glide
            .with(itemView.context)
            .load(popularProductsApiData.image)
            .centerCrop()
            .into(popularProductsImage)

        if (popularProductsApiData.isFavorite)
        {
            Glide
                .with(itemView.context)
                .load(R.drawable.ic_favorite_false)
                .centerCrop()
                .into(popularProductsFavoriteImage)
        }
        else
        {
            Glide
                .with(itemView.context)
                .load(R.drawable.ic_favorite_true)
                .centerCrop()
                .into(popularProductsFavoriteImage)
        }

        popularProductsTitleTextView.text = popularProductsApiData.title
        popularProductsCostTextView.text = popularProductsApiData.cost

        popularProductsImage.setOnClickListener {
            popularProductsClickListener.onPopularProductsClick(popularProductsApiData)
        }
    }
}