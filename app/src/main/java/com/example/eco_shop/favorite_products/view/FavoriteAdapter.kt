package com.example.eco_shop.favorite_products.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eco_shop.R
import com.example.eco_shop.popular_products.models.PopularProductsApiData

class FavoriteAdapter(
    private val favoriteClickListener: FavoriteClickListener
): RecyclerView.Adapter<FavoriteViewHolder>() {

    private var dataList: MutableList<PopularProductsApiData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.favorite_product_item, parent, false)

        return FavoriteViewHolder(rootView, favoriteClickListener)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
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