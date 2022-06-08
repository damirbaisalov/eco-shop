package com.example.eco_shop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eco_shop.favorite_products.view.FavoriteAdapter
import com.example.eco_shop.favorite_products.view.FavoriteClickListener
import com.example.eco_shop.food_detailed.FoodDetailedActivity
import com.example.eco_shop.popular_products.models.PopularProductsApiData

class SecondFragment : Fragment() {

    private lateinit var rootView: View

    private lateinit var favoriteRecyclerView: RecyclerView
    private val favoriteAdapter = FavoriteAdapter(getFavoriteProductsClickListener())
    private lateinit var backButton: ImageView
    private lateinit var emptyFavoriteTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_second, container, false)
        init()

        backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        return rootView
    }

    private fun init() {

        backButton = rootView.findViewById(R.id.fragment_second_back_button)
        emptyFavoriteTextView = rootView.findViewById(R.id.second_fragment_empty_favorites_text_view)
        favoriteRecyclerView = rootView.findViewById(R.id.second_fragment_recycler_view)

        if (favoriteList.isEmpty()) {
            emptyFavoriteTextView.visibility = View.VISIBLE
            favoriteRecyclerView.visibility = View.GONE
        }  else {
            emptyFavoriteTextView.visibility = View.GONE
            favoriteRecyclerView.visibility = View.VISIBLE
        }

        favoriteRecyclerView.layoutManager = LinearLayoutManager(rootView.context)
        favoriteRecyclerView.adapter = favoriteAdapter
        favoriteAdapter.setList(favoriteList)

    }

    private fun getFavoriteProductsClickListener(): FavoriteClickListener {
        return object: FavoriteClickListener {
            override fun onFavoriteClick(popularProductsApiData: PopularProductsApiData) {

                val intent = Intent(rootView.context, FoodDetailedActivity::class.java)
                intent.putExtra("PRODUCT_TITLE", popularProductsApiData.title)
                intent.putExtra("PRODUCT_COST", popularProductsApiData.cost)
                intent.putExtra("PRODUCT_IMAGE", popularProductsApiData.image)
                intent.putExtra("PRODUCT_IS_FAVORITE", popularProductsApiData.isFavorite)
                intent.putExtra("PRODUCT_ID", popularProductsApiData.id)
                intent.putExtra("PRODUCT_DESCRIPTION", popularProductsApiData.description)

                startActivity(intent)
            }

            override fun onRemoveClick(popularProductsApiData: PopularProductsApiData) {
                popularProductsApiData.isFavorite = false
                favoriteList.remove(popularProductsApiData)
                favoriteAdapter.notifyDataSetChanged()
                init()
            }
        }
    }

    //Container of favorite products
    companion object {
        val favoriteList: MutableList<PopularProductsApiData> = ArrayList()
    }

}