package com.example.eco_shop.menu.categories.models

import com.example.eco_shop.R
import com.example.eco_shop.popular_products.models.PopularProductsApiData

object MenuCategoriesDatabase {
    //DATABASE FOR LIST OF VIDEOMATERIALS
    val menuCategoriesDatabase : MutableList<MenuCategoriesApiData> = mutableListOf()

    init {

        val menuCategoriesApiDataId = arrayListOf<String>()
        val menuCategoriesApiDataTitle = arrayListOf<String>()
        val menuCategoriesApiDataImage = arrayListOf<Int>()

        menuCategoriesApiDataId.add("1")
        menuCategoriesApiDataTitle.add("Какао продукты")
        menuCategoriesApiDataImage.add(R.drawable.category_ic_products)


        menuCategoriesApiDataId.add("2")
        menuCategoriesApiDataTitle.add("Молочные продукты")
        menuCategoriesApiDataImage.add(R.drawable.category_milk_products)


        menuCategoriesApiDataId.add("3")
        menuCategoriesApiDataTitle.add("Сладости")
        menuCategoriesApiDataImage.add(R.drawable.category_tasty_products)


        menuCategoriesApiDataId.add("4")
        menuCategoriesApiDataTitle.add("Чаи")
        menuCategoriesApiDataImage.add(R.drawable.category_tea_products)

        menuCategoriesApiDataId.add("5")
        menuCategoriesApiDataTitle.add("Масла")
        menuCategoriesApiDataImage.add(R.drawable.category_butter_products)

        menuCategoriesApiDataId.add("6")
        menuCategoriesApiDataTitle.add("Мука и смеси")
        menuCategoriesApiDataImage.add(R.drawable.category_bread_products)

        for (i in 0 until menuCategoriesApiDataId.size){
            val menuCategoriesApiData =  MenuCategoriesApiData(
                id = menuCategoriesApiDataId[i],
                title = menuCategoriesApiDataTitle[i],
                image = menuCategoriesApiDataImage[i]
            )
            menuCategoriesDatabase.add(menuCategoriesApiData)
        }
    }
}