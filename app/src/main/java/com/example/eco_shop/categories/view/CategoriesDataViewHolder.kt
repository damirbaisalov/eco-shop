package com.example.eco_shop.categories.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eco_shop.R
import com.example.eco_shop.categories.models.CategoriesApiData

class CategoriesDataViewHolder(
    itemView: View,
    private val categoriesDataClickListener: CategoriesDataClickListener
): RecyclerView.ViewHolder(itemView) {


    val categoriesTitleTextView: TextView = itemView.findViewById(R.id.categories_horizontal_item_title)

    fun onBind(categoriesApiData: CategoriesApiData) {

        categoriesTitleTextView.text = categoriesApiData.title

        categoriesTitleTextView.setOnClickListener {
            categoriesDataClickListener.onCategoriesClick(categoriesApiData.id)
        }
    }
}