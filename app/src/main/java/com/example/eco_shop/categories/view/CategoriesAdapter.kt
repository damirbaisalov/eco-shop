package com.example.eco_shop.categories.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eco_shop.R
import com.example.eco_shop.categories.models.CategoriesApiData

class CategoriesAdapter(
    private val categoriesDataClickListener: CategoriesDataClickListener
): RecyclerView.Adapter<CategoriesDataViewHolder>() {

    private var dataList: MutableList<CategoriesApiData> = mutableListOf()
    private var selectedPosition: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesDataViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.categories_horizontal_item, parent, false)

        return CategoriesDataViewHolder(rootView, categoriesDataClickListener)
    }

    override fun onBindViewHolder(holder: CategoriesDataViewHolder, position: Int) {
        holder.onBind(dataList[position])

        holder.categoriesTitleTextView.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
        }

        if (selectedPosition == position) {

            holder.itemView.setBackgroundResource(R.drawable.bg_categories_horizontal_selected)
            holder.categoriesTitleTextView.setTextColor(Color.parseColor("#FFFFFF"))
        } else {

            holder.itemView.setBackgroundResource(R.drawable.bg_categories_horizontal)
            holder.categoriesTitleTextView.setTextColor(Color.parseColor("#000000"))
       }
    }

    override fun getItemCount(): Int = dataList.size

    fun setList(categoriesApiData: List<CategoriesApiData>) {
        dataList.clear()
        dataList.addAll(categoriesApiData)
        notifyDataSetChanged()
    }

    fun clearAll() {
        (dataList as? ArrayList<CategoriesApiData>)?.clear()
        notifyDataSetChanged()
    }
}