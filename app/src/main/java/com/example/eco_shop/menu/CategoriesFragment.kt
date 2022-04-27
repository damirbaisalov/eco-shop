package com.example.eco_shop.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eco_shop.R
import com.example.eco_shop.menu.categories.models.MenuCategoriesDatabase
import com.example.eco_shop.menu.categories.view.MenuCategoriesAdapter
import com.example.eco_shop.menu.categories.view.MenuCategoriesClickListener
import com.example.eco_shop.popular_products.models.PopularProductsDatabase
import com.example.eco_shop.popular_products.view.PopularProductsAdapter
import com.example.eco_shop.popular_products.view.PopularProductsClickListener

class CategoriesFragment : Fragment() {

    private lateinit var rootView: View

    private lateinit var categoriesRecyclerView: RecyclerView
    private val menuCategoriesAdapter = MenuCategoriesAdapter(getMenuCategoriesClickListener())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_categories, container, false)

        init()


        return rootView
    }

    private fun init() {

        categoriesRecyclerView = rootView.findViewById(R.id.fragment_categories_recyclerview)
        categoriesRecyclerView.layoutManager = GridLayoutManager(
            rootView.context,
            2
        )
        categoriesRecyclerView.adapter = menuCategoriesAdapter
        menuCategoriesAdapter.setList(MenuCategoriesDatabase.menuCategoriesDatabase)
    }

    private fun getMenuCategoriesClickListener(): MenuCategoriesClickListener {
        return object: MenuCategoriesClickListener {
            override fun onCategoryClick(id: String) {
                Toast.makeText(rootView.context, id, Toast.LENGTH_LONG).show()
            }
        }
    }
}