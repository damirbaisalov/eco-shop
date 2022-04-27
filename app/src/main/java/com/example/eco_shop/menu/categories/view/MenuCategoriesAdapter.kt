package com.example.eco_shop.menu.categories.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eco_shop.R
import com.example.eco_shop.menu.categories.models.MenuCategoriesApiData

class MenuCategoriesAdapter(
    private val menuCategoriesClickListener: MenuCategoriesClickListener
): RecyclerView.Adapter<MenuCategoriesViewHolder>() {

    private var dataList: MutableList<MenuCategoriesApiData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuCategoriesViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_categories_item, parent, false)

        return MenuCategoriesViewHolder(rootView, menuCategoriesClickListener)
    }

    override fun onBindViewHolder(holder: MenuCategoriesViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    fun setList(menuCategoriesApiData: List<MenuCategoriesApiData>) {
        dataList.clear()
        dataList.addAll(menuCategoriesApiData)
        notifyDataSetChanged()
    }

    fun clearAll() {
        (dataList as? ArrayList<MenuCategoriesApiData>)?.clear()
        notifyDataSetChanged()
    }
}