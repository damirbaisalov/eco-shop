package com.example.eco_shop.menu.categories.models

import com.example.eco_shop.R
import com.example.eco_shop.popular_products.models.PopularProductsApiData

object FoodTypeDatabase {
    //DATABASE FOR LIST OF VIDEOMATERIALS
    val foodTypeDatabase : MutableList<MenuCategoriesApiData> = mutableListOf()

    init {

        val menuCategoriesApiDataId = arrayListOf<String>()
        val menuCategoriesApiDataTitle = arrayListOf<String>()
        val menuCategoriesApiDataImage = arrayListOf<Int>()

        menuCategoriesApiDataId.add("1")
        menuCategoriesApiDataTitle.add("Без глютена")
        menuCategoriesApiDataImage.add(R.drawable.foodtype_gluten)


        menuCategoriesApiDataId.add("2")
        menuCategoriesApiDataTitle.add("Без молока")
        menuCategoriesApiDataImage.add(R.drawable.foodtype_milk)


        menuCategoriesApiDataId.add("3")
        menuCategoriesApiDataTitle.add("Без сахара")
        menuCategoriesApiDataImage.add(R.drawable.foodtype_candy)


        menuCategoriesApiDataId.add("4")
        menuCategoriesApiDataTitle.add("Детям")
        menuCategoriesApiDataImage.add(R.drawable.foodtype_baby)

        menuCategoriesApiDataId.add("5")
        menuCategoriesApiDataTitle.add("Веган")
        menuCategoriesApiDataImage.add(R.drawable.foodtype_meet)

        for (i in 0 until menuCategoriesApiDataId.size){
            val menuCategoriesApiData =  MenuCategoriesApiData(
                id = menuCategoriesApiDataId[i],
                title = menuCategoriesApiDataTitle[i],
                image = menuCategoriesApiDataImage[i]
            )
            foodTypeDatabase.add(menuCategoriesApiData)
        }
    }
}