package com.example.eco_shop.popular_products.view

import android.widget.ImageView
import com.example.eco_shop.popular_products.models.PopularProductsApiData

interface PopularProductsClickListener {

    fun onPopularProductsClick(popularProductApiData: PopularProductsApiData)

    fun onPopularProductsFavoriteClick(
        popularProductApiData: PopularProductsApiData,
        favoriteImage: ImageView
    )
}