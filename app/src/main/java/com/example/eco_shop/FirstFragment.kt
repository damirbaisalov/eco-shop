package com.example.eco_shop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eco_shop.categories.models.CategoriesDatabase
import com.example.eco_shop.categories.view.CategoriesAdapter
import com.example.eco_shop.categories.view.CategoriesDataClickListener
import com.example.eco_shop.food_detailed.FoodDetailedActivity
import com.example.eco_shop.menu.MenuActivity
import com.example.eco_shop.popular_products.models.PopularProductsApiData
import com.example.eco_shop.popular_products.models.PopularProductsDatabase
import com.example.eco_shop.popular_products.view.PopularProductsAdapter
import com.example.eco_shop.popular_products.view.PopularProductsClickListener

class FirstFragment : Fragment() {

    private lateinit var rootView: View

//    private var productsDao: ProductsDao? = null

    private lateinit var menuImageView: ImageView
    private lateinit var searchView: SearchView
    private lateinit var categoriesRecyclerView: RecyclerView
    private lateinit var popularRecyclerView: RecyclerView

    private val categoriesAdapter = CategoriesAdapter(getCategoriesClickListener())
    private val popularProductsAdapter = PopularProductsAdapter(getPopularProductsClickListener())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_first, container, false)
        init()
        
        menuImageView.setOnClickListener { 
            startActivity(Intent(requireActivity(), MenuActivity::class.java))
        }
        
        return rootView
    }

    private fun init() {

//        productsDao = ProductsDatabase.getDatabase(context = rootView.context).productsDao()
        
        menuImageView = rootView.findViewById(R.id.fragment_first_toolbar_menu_image_view)
        searchView = rootView.findViewById(R.id.first_fragment_search_view)

        categoriesRecyclerView = rootView.findViewById(R.id.first_fragment_categories_recycler_view)
        categoriesRecyclerView.layoutManager = LinearLayoutManager(
            rootView.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        categoriesRecyclerView.adapter = categoriesAdapter
        categoriesAdapter.setList(CategoriesDatabase.categoriesApiDataDatabase)

        popularRecyclerView = rootView.findViewById(R.id.first_fragment_popular_recycler_view)
        popularRecyclerView.layoutManager = LinearLayoutManager(rootView.context)

//        productsDao?.insertAll(PopularProductsDatabase.popularProductsDatabase)

        popularRecyclerView.adapter = popularProductsAdapter
        popularProductsAdapter.setList(PopularProductsDatabase.popularProductsDatabase)

    }

    private fun getCategoriesClickListener(): CategoriesDataClickListener {
        return object: CategoriesDataClickListener {
            override fun onCategoriesClick(id: String) {
                Toast.makeText(rootView.context, id, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getPopularProductsClickListener(): PopularProductsClickListener {
        return object: PopularProductsClickListener {
            override fun onPopularProductsClick(popularProductApiData: PopularProductsApiData) {

                val intent = Intent(rootView.context, FoodDetailedActivity::class.java)
                intent.putExtra("PRODUCT_TITLE", popularProductApiData.title)
                intent.putExtra("PRODUCT_COST", popularProductApiData.cost)
                intent.putExtra("PRODUCT_IMAGE", popularProductApiData.image)
                intent.putExtra("PRODUCT_IS_FAVORITE", popularProductApiData.isFavorite)
                intent.putExtra("PRODUCT_ID", popularProductApiData.id)
                startActivity(intent)
            }

            override fun onPopularProductsFavoriteClick(
                popularProductApiData: PopularProductsApiData,
                favoriteImage: ImageView
            ) {
                if (popularProductApiData.isFavorite)
                {
                    popularProductApiData.isFavorite = false
                    Glide
                        .with(rootView.context)
                        .load(R.drawable.ic_food_detailed_favorite_false)
                        .centerCrop()
                        .into(favoriteImage)
                    SecondFragment.favoriteList.remove(popularProductApiData)
                }
                else
                {
                    popularProductApiData.isFavorite = true
                    Glide
                        .with(rootView.context)
                        .load(R.drawable.ic_food_detailed_favorite_true)
                        .centerCrop()
                        .into(favoriteImage)
                    SecondFragment.favoriteList.add(popularProductApiData)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        init()
    }
}