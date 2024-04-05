package com.example.foodorderapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapp.R
import com.example.foodorderapp.adapter.MenuAdapter
import com.example.foodorderapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
     private lateinit var binding: FragmentSearchBinding
     private lateinit var adapter : MenuAdapter
     private val originalMenuFoodName = listOf(
        "Burger", "Pizza", "Pasta", "Sandwich", "Pizza", "Pasta", "Pizza", "Pasta", "Sandwich", "Pizza", "Pasta"
         )
    private val originalMenuItemPrice = listOf(
        "50.000VND", "60.000VND", "30.000VND", "40.000VND", "50.000VND", "60.000VND", "60.000VND", "30.000VND", "40.000VND", "50.000VND", "60.000VND"
    )
    private val originalMenuImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val fillerMenuFoodName = mutableListOf<String>()
    private val fillerMenuItemPrice = mutableListOf<String>()
    private val fillerMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
//        adapter = MenuAdapter(fillerMenuFoodName, fillerMenuItemPrice, fillerMenuImage,requireContext())
        binding.searchRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecycleView.adapter = adapter

        //setup for search view
        setupSeachView()

        //show All menu Items
        showAllMenuItems()
        return binding.root
    }

    private fun showAllMenuItems() {
        fillerMenuFoodName.clear()
        fillerMenuItemPrice.clear()
        fillerMenuImage.clear()

        fillerMenuFoodName.addAll(originalMenuFoodName)
        fillerMenuItemPrice.addAll(originalMenuItemPrice)
        fillerMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSeachView() {
    binding.searchView.setOnQueryTextListener(/* listener = */ object :SearchView.OnQueryTextListener{
        override fun onQueryTextSubmit(query: String): Boolean {
            fillerMenuItems(query)
            return true
        }

        override fun onQueryTextChange(newText: String): Boolean {
            fillerMenuItems(newText)
            return true
        }
    })

    }

    private fun fillerMenuItems(query: String) {
        fillerMenuFoodName.clear()
        fillerMenuItemPrice.clear()
        fillerMenuImage.clear()

        originalMenuFoodName.forEachIndexed{index, foodName ->
            if(foodName.contains(query, ignoreCase = true)){
                fillerMenuFoodName.add(foodName)
                fillerMenuItemPrice.add(originalMenuItemPrice[index])
                fillerMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}