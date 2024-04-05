package com.example.foodorderapp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderapp.DetailsActivity
import com.example.foodorderapp.Model.MenuItem
import com.example.foodorderapp.databinding.MenuItemBinding
// import glide
import com.bumptech.glide.Glide


class MenuAdapter(
//    private val menuItemsName: MutableList<String>,
//    private val menuItemPrice: MutableList<String>,
//    private val MenuImage: MutableList<Int>,
    private val menuItems : List<MenuItem>,
    private val requireContext: Context
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItems.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    openDetailsActivity(position)
                }
            }
        }

        private fun openDetailsActivity(position: Int) {
            val menuItem = menuItems[position]

            //a intent to open details activity and pass the data
            val intent = Intent(requireContext, DetailsActivity::class.java).apply {
                putExtra("MenuItemName", menuItem.foodName)
                putExtra("MenuItemPrice", menuItem.foodPrice)
                putExtra("MenuItemDescription", menuItem.foodDescription)
                putExtra("MenuItemImage", menuItem.foodImage)
                putExtra("MenuItemIngredients", menuItem.foodIngredient)
            }
            //start the details activity
            requireContext.startActivity(intent)

        }

        //set data to the recycler view items name, price and image
        fun bind(position: Int) {
            val menuItem = menuItems[position]
            binding.apply {
                menuFoodName.text = menuItem.foodName
                menuPrice.text = menuItem.foodPrice
                val uri = Uri.parse(menuItem.foodImage.toString())
                Glide.with(requireContext).load(uri).into(menuImage)
            }
        }
    }



    interface OnClickListener {
        fun onItemClick(position: Int)
    }
}