package com.example.eco_shop.popular_products.models

data class PopularProductsApiData(
    val id: String,
    val title: String,
    val image: Int,
    val cost: String,
    var isFavorite: Boolean
)