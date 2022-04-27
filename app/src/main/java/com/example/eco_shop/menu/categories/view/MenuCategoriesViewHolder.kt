package com.example.eco_shop.menu.categories.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eco_shop.R
import com.example.eco_shop.categories.models.CategoriesApiData
import com.example.eco_shop.categories.view.CategoriesDataClickListener
import com.example.eco_shop.menu.categories.models.MenuCategoriesApiData

class MenuCategoriesViewHolder(
    itemView: View,
    private val menuCategoriesClickListener: MenuCategoriesClickListener
): RecyclerView.ViewHolder(itemView) {


    private val categoriesTitleTextView: TextView = itemView.findViewById(R.id.fragment_categories_item_title)
    private val categoriesImage: ImageView = itemView.findViewById(R.id.fragment_categories_item_image)

    fun onBind(menuCategoriesApiData: MenuCategoriesApiData) {

        categoriesTitleTextView.text = menuCategoriesApiData.title

        Glide
            .with(itemView.context)
            .load(menuCategoriesApiData.image)
            .centerCrop()
            .into(categoriesImage)

        categoriesImage.setOnClickListener {
            menuCategoriesClickListener.onCategoryClick(menuCategoriesApiData.id)
        }
    }
}