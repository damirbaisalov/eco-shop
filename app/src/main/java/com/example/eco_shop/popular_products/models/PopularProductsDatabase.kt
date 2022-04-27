package com.example.eco_shop.popular_products.models

import com.example.eco_shop.R

object PopularProductsDatabase {
    //DATABASE FOR LIST OF VIDEOMATERIALS
    val popularProductsDatabase : MutableList<PopularProductsApiData> = mutableListOf()

    init {

        val popularProductsApiDataId = arrayListOf<String>()
        val popularProductsApiDataTitle = arrayListOf<String>()
        val popularProductsApiDataImage = arrayListOf<Int>()
        val popularProductsApiDataCost = arrayListOf<String>()
        val popularProductsApiDataIsFavorite = arrayListOf<Boolean>()

        popularProductsApiDataId.add("1")
        popularProductsApiDataTitle.add("Кокосовое молоко, 1л.")
        popularProductsApiDataImage.add(R.drawable.popular_image)
        popularProductsApiDataCost.add("2700T")
        popularProductsApiDataIsFavorite.add(false)

        popularProductsApiDataId.add("2")
        popularProductsApiDataTitle.add("Кокосовое молоко, 1л.")
        popularProductsApiDataImage.add(R.drawable.popular_image)
        popularProductsApiDataCost.add("1500T")
        popularProductsApiDataIsFavorite.add(true)

        popularProductsApiDataId.add("3")
        popularProductsApiDataTitle.add("Кокосовое молоко, 1л.")
        popularProductsApiDataImage.add(R.drawable.popular_image)
        popularProductsApiDataCost.add("2000T")
        popularProductsApiDataIsFavorite.add(false)

        popularProductsApiDataId.add("4")
        popularProductsApiDataTitle.add("Кокосовое молоко, 1л.")
        popularProductsApiDataImage.add(R.drawable.popular_image)
        popularProductsApiDataCost.add("3900T")
        popularProductsApiDataIsFavorite.add(true)


        for (i in 0 until popularProductsApiDataId.size){
            val popularProductsApiData =  PopularProductsApiData(
                id = popularProductsApiDataId[i],
                title = popularProductsApiDataTitle[i],
                image = popularProductsApiDataImage[i],
                cost = popularProductsApiDataCost[i],
                isFavorite = popularProductsApiDataIsFavorite[i]
            )
            popularProductsDatabase.add(popularProductsApiData)
        }
    }
}