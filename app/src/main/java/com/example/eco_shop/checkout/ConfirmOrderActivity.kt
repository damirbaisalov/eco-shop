package com.example.eco_shop.checkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.eco_shop.R

class ConfirmOrderActivity : AppCompatActivity() {

    private lateinit var checkOutButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var telephoneEditText: EditText
    private lateinit var addressEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_order)
        init()

        checkOutButton.setOnClickListener {

        }
    }

    private fun init() {
        checkOutButton = findViewById(R.id.activity_confirm_order_checkout_button)
        nameEditText = findViewById(R.id.activity_confirm_order_name_edit_text)
        telephoneEditText = findViewById(R.id.activity_confirm_order_telephone_edit_text)
        addressEditText = findViewById(R.id.activity_confirm_order_address_edit_text)

        val costIntent = intent.getStringExtra("CONFIRM_COST")

        checkOutButton.text = ("Оплатить $costIntent"+"Т")
    }
}