package com.example.eco_shop.food_detailed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.eco_shop.R
import com.example.eco_shop.SecondFragment
import com.example.eco_shop.ThirdFragment
import com.example.eco_shop.popular_products.models.PopularProductsDatabase

class FoodDetailedActivity : AppCompatActivity() {

    private lateinit var backButton: ImageView

    private lateinit var foodImage: ImageView
    private lateinit var foodTitle: TextView
    private lateinit var foodCost: TextView
    private lateinit var foodIsFavorite: ImageView
    private lateinit var foodDescription: TextView

    private lateinit var addToCartButton: Button
    private var productId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detailed)
        productId = intent.getStringExtra("PRODUCT_ID").toString()

        init()

        backButton.setOnClickListener {
            onBackPressed()
        }

        addToCartButton.setOnClickListener {

            for (p in PopularProductsDatabase.popularProductsDatabase) {
                if (p.id == productId) {
                    if (!ThirdFragment.cartList.contains(p)) {
                        ThirdFragment.cartList.add(p)
                        showToast("Успешно добавлен в корзину!")
                    }
                }
            }
        }

    }

    private fun init() {

        backButton = findViewById(R.id.activity_food_detailed_back_button)

        val productTitle = intent.getStringExtra("PRODUCT_TITLE")
        val productCost = intent.getStringExtra("PRODUCT_COST")
        val productImage = intent.getIntExtra("PRODUCT_IMAGE", R.drawable.popular_image)
        val productFavorite = intent.getBooleanExtra("PRODUCT_IS_FAVORITE", false)
        val productDescription = intent.getStringExtra("PRODUCT_DESCRIPTION")

        foodTitle = findViewById(R.id.activity_food_detailed_title)
        foodCost = findViewById(R.id.activity_food_detailed_cost)
        foodImage = findViewById(R.id.activity_food_detailed_image_view)
        foodIsFavorite = findViewById(R.id.activity_food_detailed_favorite)
        addToCartButton = findViewById(R.id.activity_food_detailed_add_to_cart)
        foodDescription = findViewById(R.id.activity_food_detailed_description)

        foodTitle.text = productTitle
        foodCost.text = productCost
        foodDescription.text = productDescription

        Glide
            .with(this)
            .load(productImage)
            .centerCrop()
            .into(foodImage)

        if (productFavorite)
        {
            Glide
                .with(this)
                .load(R.drawable.ic_food_detailed_favorite_true)
                .centerCrop()
                .into(foodIsFavorite)
        }
        else
        {
            Glide
                .with(this)
                .load(R.drawable.ic_food_detailed_favorite_false)
                .centerCrop()
                .into(foodIsFavorite)
        }

        foodIsFavorite.setOnClickListener {
            if (productFavorite)
            {
                for (p in PopularProductsDatabase.popularProductsDatabase) {
                    if (productId == p.id) {
                        p.isFavorite = false
                        Glide
                            .with(this)
                            .load(R.drawable.ic_food_detailed_favorite_false)
                            .centerCrop()
                            .into(foodIsFavorite)
                        SecondFragment.favoriteList.remove(p)
                    }
                }
            }
            else
            {
                for (p in PopularProductsDatabase.popularProductsDatabase) {
                    if (productId == p.id) {
                        p.isFavorite = true
                        Glide
                            .with(this)
                            .load(R.drawable.ic_food_detailed_favorite_true)
                            .centerCrop()
                            .into(foodIsFavorite)
                        SecondFragment.favoriteList.add(p)
                    }
                }
            }
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}