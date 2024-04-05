package com.example.foodorderapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapp.R
import com.example.foodorderapp.adapter.BuyAgainAdapter
import com.example.foodorderapp.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView(){
        val buyAgainFoodName = arrayListOf("Burger", "Pizza", "Pasta", "Sandwich", "Pizza", "Pasta")
        val buyAgainFoodPrice = arrayListOf("50.000đ", "60.000đ", "30.000đ", "40.000đ", "50.000đ", "60.000đ")
        val buyAgainFoodImage = arrayListOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,)
        buyAgainAdapter = BuyAgainAdapter(
            buyAgainFoodName,
            buyAgainFoodPrice,
            buyAgainFoodImage
        )
        binding.buyAgainRecycleView.adapter = buyAgainAdapter
        binding.buyAgainRecycleView.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {

    }
}