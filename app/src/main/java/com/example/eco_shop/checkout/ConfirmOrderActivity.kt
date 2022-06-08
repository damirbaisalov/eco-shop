package com.example.eco_shop.checkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.eco_shop.R
import com.example.eco_shop.dialog_fragments.SuccessDialogFragment

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

            if (checkFields()) {

                val dialogFragment = SuccessDialogFragment()
                val fragmentManager = supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                dialogFragment.show(transaction, "success_dialog")
            }
            else
            {
                Toast.makeText(
                    this,
                    "Заполните все необходимые поля для подтверждения заказа",
                    Toast.LENGTH_LONG
                ).show()
            }
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

    private fun checkFields(): Boolean {

        if (nameEditText.text.toString() == "" ||
            addressEditText.text.toString() == "" ||
            telephoneEditText.text.toString().length != 16
        ) {

            Log.e("tel", addressEditText.text.toString())
            Log.e("tel", nameEditText.text.toString())
            Log.e("tel", telephoneEditText.text.toString())

                return false
            }

        return true
    }
}