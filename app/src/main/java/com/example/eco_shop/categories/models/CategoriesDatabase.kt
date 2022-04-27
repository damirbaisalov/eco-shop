package com.example.eco_shop.categories.models

object CategoriesDatabase {
    //DATABASE FOR LIST OF VIDEOMATERIALS
    val categoriesApiDataDatabase : MutableList<CategoriesApiData> = mutableListOf()

    init {

        val categoriesApiDataId = arrayListOf<String>()
        val categoriesApiDataTitle = arrayListOf<String>()


        categoriesApiDataId.add("1")
        categoriesApiDataTitle.add("Без глютена")

        categoriesApiDataId.add("2")
        categoriesApiDataTitle.add("Детям")

        categoriesApiDataId.add("3")
        categoriesApiDataTitle.add("Без молока")

        categoriesApiDataId.add("4")
        categoriesApiDataTitle.add("Без сахара")

        categoriesApiDataId.add("5")
        categoriesApiDataTitle.add("Все")

        for (i in 0 until categoriesApiDataId.size){
            val categoriesApiData =  CategoriesApiData(
                id = categoriesApiDataId[i],
                title = categoriesApiDataTitle[i]
            )
            categoriesApiDataDatabase.add(categoriesApiData)
        }
    }
}