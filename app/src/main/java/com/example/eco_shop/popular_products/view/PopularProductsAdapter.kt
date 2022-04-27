package com.example.eco_shop.popular_products.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eco_shop.R
import com.example.eco_shop.categories.models.CategoriesApiData
import com.example.eco_shop.categories.view.CategoriesDataClickListener
import com.example.eco_shop.categories.view.CategoriesDataViewHolder
import com.example.eco_shop.popular_products.models.PopularProductsApiData

class PopularProductsAdapter(
    private val popularProductsClickListener: PopularProductsClickListener
): RecyclerView.Adapter<PopularProductsViewHolder>() {

    private var dataList: MutableList<PopularProductsApiData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularProductsViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.popular_food_item, parent, false)

        return PopularProductsViewHolder(rootView, popularProductsClickListener)
    }

    override fun onBindViewHolder(holder: PopularProductsViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    fun setList(popularProductsApiData: List<PopularProductsApiData>) {
        dataList.clear()
        dataList.addAll(popularProductsApiData)
        notifyDataSetChanged()
    }

    fun clearAll() {
        (dataList as? ArrayList<PopularProductsApiData>)?.clear()
        notifyDataSetChanged()
    }
}