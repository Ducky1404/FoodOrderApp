package com.example.foodorderapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapp.Model.MenuItem
import com.example.foodorderapp.adapter.MenuAdapter
import com.example.foodorderapp.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var menuItems: MutableList<MenuItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)


        binding.buttonBack.setOnClickListener {
            dismiss()
        }


        retrieveMenuItems()


        return binding.root
    }

    private fun retrieveMenuItems() {
        database = FirebaseDatabase.getInstance()
        val foodRef : DatabaseReference = database.reference.child("menu")
        menuItems = mutableListOf()

        foodRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (foodSnapshot in snapshot.children) {
                    val menuItem = foodSnapshot.getValue(MenuItem::class.java)
                    menuItem?.let{ menuItems .add(it) }
                }
                Log.d("ITEMS", "onDataChange: data recieved")
                //once data recieve, set the adapter
                setAdapter()

            }


            override fun onCancelled(error: DatabaseError) {
                Log.e("MenuBottomSheetFragment", "Error retrieving menu items", error.toException())
            }
        })
    }
    private fun setAdapter() {
        if (menuItems.isEmpty()) {
            val adapter = MenuAdapter(menuItems, requireContext())
            binding.menuRecycleView.layoutManager = LinearLayoutManager(requireContext())
            binding.menuRecycleView.adapter = adapter
            Log.d("ITEMS", "setAdapter: data set")
        }else{
            Log.d("ITEMS", "setAdapter: data not set")
        }

    }
    companion object {
    }
}