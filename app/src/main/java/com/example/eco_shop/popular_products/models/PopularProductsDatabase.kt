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
        val popularProductsApiDataDescription = arrayListOf<String>()
        val popularProductsApiDataIsFavorite = arrayListOf<Boolean>()

        popularProductsApiDataId.add("1")
        popularProductsApiDataTitle.add("Вафли \"Шоколад\" Bite")
        popularProductsApiDataImage.add(R.drawable.product_test_10)
        popularProductsApiDataCost.add("525Т")
        popularProductsApiDataDescription.add("Вафли Bitey со вкусом шоколада - это вкусное и полезное лакомство для всей семьи. Продукт совсем не содержит добавленного сахара, консервантов и искусственных красителей.  А еще эти вафли невероятно красивого зеленого цвета! В качестве красителя мы используем настоящий суперфуд и кладезь полезных микроэлементов - 100% натуральный хлорофилл.")
        popularProductsApiDataIsFavorite.add(false)

        popularProductsApiDataId.add("2")
        popularProductsApiDataTitle.add("Шоколад \" Горький без сахара какао\" 100г")
        popularProductsApiDataImage.add(R.drawable.product_test_2)
        popularProductsApiDataCost.add("840Т")
        popularProductsApiDataDescription.add("Эксклюзивная серия некалорийного шоколада без сахара с «медовой травой» Стевией просто идеальна для полноценной и здоровой жизни. В ней на 12% меньше калорий и 0% сахара. В этой серии также представлены 3 самых популярных вида: Горький 72% какао, Десертный 57% какао и Молочный 36% какао.")
        popularProductsApiDataIsFavorite.add(false)

        popularProductsApiDataId.add("3")
        popularProductsApiDataTitle.add("Кокосовая сгущёнка, без сахара, 230г")
        popularProductsApiDataImage.add(R.drawable.product_test_6)
        popularProductsApiDataCost.add("2850Т")
        popularProductsApiDataDescription.add("Кокосовая сгущенка - отличный выбор, чтобы порадовать себя и своих близких полезным лакомством с превосходным вкусом, содержащим только полезные ингредиенты. Наша сгущенка не содержит сахара, молока, консервантов и искусственных ароматизаторов. Завтрак или перекус, тосты или хлебцы - выбор за Вами.")
        popularProductsApiDataIsFavorite.add(false)

        popularProductsApiDataId.add("4")
        popularProductsApiDataTitle.add("Ромашковый чай с лавандой 30 г")
        popularProductsApiDataImage.add(R.drawable.product_test_9)
        popularProductsApiDataCost.add("890Т")
        popularProductsApiDataDescription.add("Ромашка издавна известна и широко применяется в фитотерапии за счет своего мягкого и всестороннего воздействия на организм. Теплый чай с ромашкой успокоит, расслабит и настроит на позитивный лад. Аромат лаванды невозможно с чем-то спутать или забыть. Теперь аромат лавандового поля можно вдыхать прямо из чашки.")
        popularProductsApiDataIsFavorite.add(false)


        for (i in 0 until popularProductsApiDataId.size){
            val popularProductsApiData =  PopularProductsApiData(
                id = popularProductsApiDataId[i],
                title = popularProductsApiDataTitle[i],
                image = popularProductsApiDataImage[i],
                cost = popularProductsApiDataCost[i],
                description = popularProductsApiDataDescription[i],
                isFavorite = popularProductsApiDataIsFavorite[i]
            )
            popularProductsDatabase.add(popularProductsApiData)
        }
    }
}