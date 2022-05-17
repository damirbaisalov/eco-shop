package com.example.eco_shop.cart.view

import android.widget.TextView
import com.example.eco_shop.popular_products.models.PopularProductsApiData

interface CartClickListener {

    fun onCartClick(popularProductsApiData: PopularProductsApiData)

    fun onRemoveClick(popularProductsApiData: PopularProductsApiData)

    fun onIncreaseClick(popularProductsApiData: PopularProductsApiData, itemCount: TextView)
    fun onDecreaseClick(popularProductsApiData: PopularProductsApiData, itemCount: TextView)

}