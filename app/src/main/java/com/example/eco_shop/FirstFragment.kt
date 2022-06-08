package com.example.eco_shop

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import com.example.eco_shop.sign_in.APPLICATION_SHARED_PREFERENCES
import com.example.eco_shop.sign_in.LoginActivity
import com.example.eco_shop.sign_in.USER_TOKEN
import com.example.eco_shop.user_page.UserPageActivity

class FirstFragment : Fragment() {

    private lateinit var rootView: View

//    private var productsDao: ProductsDao? = null

    private lateinit var menuImageView: ImageView
    private lateinit var searchView: SearchView
    private lateinit var accountImageView: ImageView
    private lateinit var categoriesRecyclerView: RecyclerView
    private lateinit var popularRecyclerView: RecyclerView
    private var searchingProductsList: List<PopularProductsApiData> = listOf()

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

        accountImageView.setOnClickListener {
            if (getSaveUserToken()=="default") {
                showToast("Вы не авторизованы!")
                startActivity(Intent(requireActivity(), LoginActivity::class.java))
            } else {
                startActivity(Intent(requireActivity(), UserPageActivity::class.java))
            }
        }

        queryInSearchView()
        
        return rootView
    }

    private fun init() {

//        productsDao = ProductsDatabase.getDatabase(context = rootView.context).productsDao()
        
        menuImageView = rootView.findViewById(R.id.fragment_first_toolbar_menu_image_view)
        searchView = rootView.findViewById(R.id.first_fragment_search_view)
        accountImageView = rootView.findViewById(R.id.fragment_first_toolbar_account_image_view)
        searchingProductsList = PopularProductsDatabase.popularProductsDatabase

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

    private fun getSaveUserToken(): String {
        val sharedPreferences: SharedPreferences = rootView.context.getSharedPreferences(
            APPLICATION_SHARED_PREFERENCES,
            Context.MODE_PRIVATE
        )

        return sharedPreferences.getString(USER_TOKEN, "default") ?: "default"
    }

    private fun showToast(text: String) {
        Toast.makeText(
            rootView.context,
            text,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun queryInSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchView.clearFocus()

                val queryText = p0?.lowercase()


                popularProductsAdapter.filter(queryText!!)


                return false

            }

            override fun onQueryTextChange(p0: String?): Boolean {

                val queryText = p0?.lowercase()

//                cafeAdapter?.filter(queryText!!)
//
//                if (queryText?.isEmpty()!!)
//                    cafeAdapter?.setList(searchingCafeList)

                val productsList: MutableList<PopularProductsApiData> = mutableListOf()
                for (q in searchingProductsList) {
                    if (q.title?.lowercase()?.contains(queryText!!)!!) {
                        productsList.add(q)
                    }
                }
                popularProductsAdapter.setList(productsList)

                return false
            }
        })
    }
}