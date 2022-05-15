package com.example.eco_shop.favorite_products.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eco_shop.R
import com.example.eco_shop.popular_products.models.PopularProductsApiData

class FavoriteViewHolder(
    itemView: View,
    private val favoriteClickListener: FavoriteClickListener
): RecyclerView.ViewHolder(itemView) {


    private val favoriteProductsTitleTextView: TextView = itemView.findViewById(R.id.favorite_product_item_title)
    private val favoriteProductsImage: ImageView = itemView.findViewById(R.id.favorite_product_item_image)
    private val favoriteProductsCostTextView: TextView = itemView.findViewById(R.id.favorite_product_item_cost)
    private val favoriteProductsRemoveImage: ImageView = itemView.findViewById(R.id.favorite_product_item_remove_cart)

    fun onBind(popularProductsApiData: PopularProductsApiData) {

            favoriteProductsTitleTextView.text = popularProductsApiData.title
            favoriteProductsCostTextView.text = popularProductsApiData.cost

            Glide
                .with(itemView.context)
                .load(popularProductsApiData.image)
                .centerCrop()
                .into(favoriteProductsImage)

            favoriteProductsImage.setOnClickListener {
                favoriteClickListener.onFavoriteClick(popularProductsApiData)
            }

            favoriteProductsRemoveImage.setOnClickListener {
                favoriteClickListener.onRemoveClick(popularProductsApiData)
            }
    }
}