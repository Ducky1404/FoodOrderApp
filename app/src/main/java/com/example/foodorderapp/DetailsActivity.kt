package com.example.foodorderapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.foodorderapp.Model.CartItems
import com.example.foodorderapp.databinding.ActivityDetailsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailsBinding
    private var foodName: String? = null
    private var foodPrice: String? = null
    private var foodDescription: String? = null
    private var foodImage: String? = null
    private var foodIngredients: String? = null
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //initialize firebase auth
        auth = FirebaseAuth.getInstance()
        foodName = intent.getStringExtra("MenuItemName")
        foodPrice = intent.getStringExtra("MenuItemPrice")
        foodDescription = intent.getStringExtra("MenuItemDescription")
        foodImage = intent.getStringExtra("MenuItemImage")
        foodIngredients = intent.getStringExtra("MenuItemIngredients")

        with(binding){
            detailFoodName.text = foodName
            detailFoodDescription.text = foodDescription
            detailFoodIngredients.text = foodIngredients
            Glide.with(this@DetailsActivity).load(foodImage).into(detailFoodImage)
        }

        binding.imageButton.setOnClickListener {
            finish()
        }
        binding.addItemButton.setOnClickListener {
            //add item to cart
            addItemToCart()
        }
    }

    private fun addItemToCart() {
        val database = FirebaseDatabase.getInstance().reference
        val userId = auth.currentUser?.uid?:""
        //Create a cartitem object
        val cartItem = CartItems(foodName.toString(), foodPrice.toString(), foodDescription.toString(),foodImage.toString(),1)


        //save data to cart item to firebase database
        database.child("user").child(userId).child("CartItems").push().setValue(cartItem).addOnSuccessListener {
            Toast.makeText(this, "Thêm vào giỏ thành công", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this, "Thêm vào giỏ thất bại", Toast.LENGTH_SHORT).show()
        }

    }
}