package com.example.eco_shop.favorite_products.view

import com.example.eco_shop.popular_products.models.PopularProductsApiData

interface FavoriteClickListener {

    fun onFavoriteClick(popularProductsApiData: PopularProductsApiData)

    fun onRemoveClick(popularProductsApiData: PopularProductsApiData)
}