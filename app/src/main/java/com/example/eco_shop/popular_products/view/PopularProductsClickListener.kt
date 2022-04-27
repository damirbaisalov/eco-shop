package com.example.eco_shop.popular_products.view

import com.example.eco_shop.popular_products.models.PopularProductsApiData

interface PopularProductsClickListener {

    fun onPopularProductsClick(popularProductApiData: PopularProductsApiData)
}