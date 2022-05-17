package com.example.eco_shop.cart.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eco_shop.R
import com.example.eco_shop.popular_products.models.PopularProductsApiData

class CartAdapter(
    private val cartClickListener: CartClickListener
): RecyclerView.Adapter<CartViewHolder>() {

    private var dataList: MutableList<PopularProductsApiData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.cart_product_item, parent, false)

        return CartViewHolder(rootView, cartClickListener)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
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

    fun removeElement(popularProductsApiData: PopularProductsApiData) {
        dataList.remove(popularProductsApiData)
        notifyDataSetChanged()
    }
}