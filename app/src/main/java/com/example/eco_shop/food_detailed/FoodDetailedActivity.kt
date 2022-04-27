package com.example.eco_shop.food_detailed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.eco_shop.R

class FoodDetailedActivity : AppCompatActivity() {

    private lateinit var backButton: ImageView

    private lateinit var foodImage: ImageView
    private lateinit var foodTitle: TextView
    private lateinit var foodCost: TextView
    private lateinit var foodIsFavorite: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detailed)

        init()

        backButton.setOnClickListener {
            onBackPressed()
        }

    }

    private fun init() {

        backButton = findViewById(R.id.activity_food_detailed_back_button)

        val productTitle = intent.getStringExtra("PRODUCT_TITLE")
        val productCost = intent.getStringExtra("PRODUCT_COST")
        val productImage = intent.getIntExtra("PRODUCT_IMAGE", R.drawable.popular_image)
        val productFavorite = intent.getBooleanExtra("PRODUCT_IS_FAVORITE", false)

        foodTitle = findViewById(R.id.activity_food_detailed_title)
        foodCost = findViewById(R.id.activity_food_detailed_cost)
        foodImage = findViewById(R.id.activity_food_detailed_image_view)
        foodIsFavorite = findViewById(R.id.activity_food_detailed_favorite)

        foodTitle.text = productTitle
        foodCost.text = productCost

        Glide
            .with(this)
            .load(productImage)
            .centerCrop()
            .into(foodImage)

        if (productFavorite)
        {
            Glide
                .with(this)
                .load(R.drawable.ic_food_detailed_favorite_false)
                .centerCrop()
                .into(foodIsFavorite)
        }
        else
        {
            Glide
                .with(this)
                .load(R.drawable.ic_food_detailed_favorite_true)
                .centerCrop()
                .into(foodIsFavorite)
        }
    }
}