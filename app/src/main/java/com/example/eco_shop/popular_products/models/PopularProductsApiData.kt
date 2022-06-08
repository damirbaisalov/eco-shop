package com.example.eco_shop.popular_products.models

data class PopularProductsApiData(
    val id: String,
    val title: String,
    val image: Int,
    val cost: String,
    val description: String,
    var isFavorite: Boolean
)