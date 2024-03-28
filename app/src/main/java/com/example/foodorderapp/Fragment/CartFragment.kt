package com.example.foodorderapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapp.R
import com.example.foodorderapp.adapter.CartAdapter
import com.example.foodorderapp.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        val cartFoodName = listOf("Burger", "Pizza", "Pasta", "Sandwich", "Pizza", "Pasta")
        val cartItemPrice =
            listOf("50.000VND", "60.000VND", "30.000VND", "40.000VND", "50.000VND", "60.000VND")
        val cartImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
        )
        val adapter = CartAdapter(ArrayList(cartFoodName), ArrayList(cartItemPrice), ArrayList(cartImage))
        binding.cartRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecycleView.adapter = adapter
        return binding.root
    }
    companion object{

    }
}