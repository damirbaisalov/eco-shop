package com.example.eco_shop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eco_shop.cart.view.CartAdapter
import com.example.eco_shop.cart.view.CartClickListener
import com.example.eco_shop.checkout.ConfirmOrderActivity
import com.example.eco_shop.favorite_products.view.FavoriteAdapter
import com.example.eco_shop.favorite_products.view.FavoriteClickListener
import com.example.eco_shop.food_detailed.FoodDetailedActivity
import com.example.eco_shop.popular_products.models.PopularProductsApiData

class ThirdFragment : Fragment() {

    private lateinit var rootView: View

    private lateinit var cartRecyclerView: RecyclerView
    private val cartAdapter = CartAdapter(getCartProductsClickListener())
    private lateinit var backButton: ImageView
    private lateinit var emptyCartTextView: TextView
    private lateinit var frameLayout: LinearLayout
    private lateinit var confirmOrderButton: Button

    private lateinit var sumOrderNumTextView: TextView
    private lateinit var totalSumWithDeliveryTextView: TextView
    private var costCounter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_third, container, false)
        init()
        bindCostsAdded()

        backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        confirmOrderButton.setOnClickListener {
            val intent = Intent(rootView.context, ConfirmOrderActivity::class.java)
            intent.putExtra("CONFIRM_COST", costCounter.toString())
            startActivity(intent)
        }

        return rootView
    }

    private fun init() {

        backButton = rootView.findViewById(R.id.fragment_third_back_button)
        emptyCartTextView = rootView.findViewById(R.id.third_fragment_empty_cart_text_view)
        cartRecyclerView = rootView.findViewById(R.id.third_fragment_recycler_view)
        frameLayout = rootView.findViewById(R.id.fragment_third_frame_layout)

        sumOrderNumTextView = rootView.findViewById(R.id.third_fragment_sum_order_num)
        totalSumWithDeliveryTextView = rootView.findViewById(R.id.third_fragment_total_sum_num)
        confirmOrderButton = rootView.findViewById(R.id.fragment_third_form_order_button)

        if (cartList.isEmpty()) {
            emptyCartTextView.visibility = View.VISIBLE
            frameLayout.visibility = View.GONE
        }  else {
            emptyCartTextView.visibility = View.GONE
            frameLayout.visibility = View.VISIBLE
        }

        cartRecyclerView.layoutManager = LinearLayoutManager(rootView.context)
        cartRecyclerView.adapter = cartAdapter
        cartAdapter.setList(cartList)

    }

    private fun bindCostsAdded() {
        sumOrderNumTextView.text = (getAllCosts().toString()+"Т")
        totalSumWithDeliveryTextView.text = (getAllCostsWithDelivery().toString()+"Т")
    }


    private fun getAllCosts(): Int {
        for (c in cartList) {
            val costConverted = c.cost.dropLast(1).toInt()
            costCounter += costConverted
        }

        return costCounter
    }

    private fun getAllCostsWithDelivery(): Int {
        return costCounter+500
    }



    private fun getCartProductsClickListener(): CartClickListener {
        return object: CartClickListener {
            override fun onCartClick(popularProductsApiData: PopularProductsApiData) {

                val intent = Intent(rootView.context, FoodDetailedActivity::class.java)
                intent.putExtra("PRODUCT_TITLE", popularProductsApiData.title)
                intent.putExtra("PRODUCT_COST", popularProductsApiData.cost)
                intent.putExtra("PRODUCT_IMAGE", popularProductsApiData.image)
                intent.putExtra("PRODUCT_IS_FAVORITE", popularProductsApiData.isFavorite)
                startActivity(intent)
            }

            override fun onRemoveClick(popularProductsApiData: PopularProductsApiData) {

                cartList.remove(popularProductsApiData)
                costCounter -= popularProductsApiData.cost.dropLast(1).toInt()
//                Toast.makeText(rootView.context, removeCost(popularProductsApiData).toString(), Toast.LENGTH_LONG).show()
                sumOrderNumTextView.text = ((costCounter).toString()+"Т")
                totalSumWithDeliveryTextView.text = (getAllCostsWithDelivery().toString()+"Т")

                cartAdapter.notifyDataSetChanged()
                init()
            }

            override fun onIncreaseClick(
                popularProductsApiData: PopularProductsApiData,
                itemCount: TextView
            ) {
                var productCount = itemCount.text.toString().toInt()
                productCount+=1
                costCounter+=popularProductsApiData.cost.dropLast(1).toInt()
                sumOrderNumTextView.text = ((costCounter).toString()+"Т")
                totalSumWithDeliveryTextView.text = (getAllCostsWithDelivery().toString()+"Т")
                itemCount.text = productCount.toString()
            }

            override fun onDecreaseClick(
                popularProductsApiData: PopularProductsApiData,
                itemCount: TextView
            ) {
                var productCount = itemCount.text.toString().toInt()
                if (productCount==1) {
                    onRemoveClick(popularProductsApiData)
                    return
                }
                productCount-=1
                costCounter-=popularProductsApiData.cost.dropLast(1).toInt()
                sumOrderNumTextView.text = ((costCounter).toString()+"Т")
                totalSumWithDeliveryTextView.text = (getAllCostsWithDelivery().toString()+"Т")
                itemCount.text = productCount.toString()
            }
        }
    }

    //Container of cart products
    companion object {
        val cartList: MutableList<PopularProductsApiData> = ArrayList()
    }
}