package com.example.eco_shop.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eco_shop.R
import com.example.eco_shop.menu.categories.models.FoodTypeDatabase
import com.example.eco_shop.menu.categories.models.MenuCategoriesDatabase
import com.example.eco_shop.menu.categories.view.MenuCategoriesAdapter
import com.example.eco_shop.menu.categories.view.MenuCategoriesClickListener

class FoodTypeFragment : Fragment() {

    private lateinit var rootView: View

    private lateinit var foodTypeRecyclerView: RecyclerView
    private val menuCategoriesAdapter = MenuCategoriesAdapter(getMenuCategoriesClickListener())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_food_type, container, false)

        init()


        return rootView
    }

    private fun init() {

        foodTypeRecyclerView = rootView.findViewById(R.id.fragment_food_type_recyclerview)
        foodTypeRecyclerView.layoutManager = GridLayoutManager(
            rootView.context,
            2
        )
        foodTypeRecyclerView.adapter = menuCategoriesAdapter
        menuCategoriesAdapter.setList(FoodTypeDatabase.foodTypeDatabase)
    }

    private fun getMenuCategoriesClickListener(): MenuCategoriesClickListener {
        return object: MenuCategoriesClickListener {
            override fun onCategoryClick(id: String) {
                Toast.makeText(rootView.context, id, Toast.LENGTH_LONG).show()
            }
        }
    }

}