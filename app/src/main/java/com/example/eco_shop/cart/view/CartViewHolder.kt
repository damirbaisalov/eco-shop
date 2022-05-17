package com.example.eco_shop.cart.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eco_shop.R
import com.example.eco_shop.popular_products.models.PopularProductsApiData

class CartViewHolder(
    itemView: View,
    private val cartClickListener: CartClickListener
): RecyclerView.ViewHolder(itemView) {

    private val cartProductsTitleTextView: TextView = itemView.findViewById(R.id.cart_product_item_title)
    private val cartProductsImage: ImageView = itemView.findViewById(R.id.cart_product_item_image)
    private val cartProductsCostTextView: TextView = itemView.findViewById(R.id.cart_product_item_cost)
    private val cartProductsRemoveImage: ImageView = itemView.findViewById(R.id.cart_product_item_remove_cart)
    private val addImageView: ImageView = itemView.findViewById(R.id.cart_product_item_increase_image_view)
    private val removeImageView: ImageView = itemView.findViewById(R.id.cart_product_item_decrease_image_view)
    private val productCount: TextView = itemView.findViewById(R.id.cart_product_item_count)

    fun onBind(popularProductsApiData: PopularProductsApiData) {

        cartProductsTitleTextView.text = popularProductsApiData.title
        cartProductsCostTextView.text = popularProductsApiData.cost

        Glide
            .with(itemView.context)
            .load(popularProductsApiData.image)
            .centerCrop()
            .into(cartProductsImage)

        cartProductsImage.setOnClickListener {
            cartClickListener.onCartClick(popularProductsApiData)
        }

        cartProductsRemoveImage.setOnClickListener {
            cartClickListener.onRemoveClick(popularProductsApiData)
        }

        addImageView.setOnClickListener {
            cartClickListener.onIncreaseClick(popularProductsApiData, productCount)
        }

        removeImageView.setOnClickListener {
            cartClickListener.onDecreaseClick(popularProductsApiData, productCount)
        }

    }
}