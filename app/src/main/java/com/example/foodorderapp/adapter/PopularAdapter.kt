package com.example.foodorderapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderapp.DetailsActivity
import com.example.foodorderapp.databinding.PopulerItemBinding

class PopularAdapter (private val items:List<String>,private val price:List<String>,private val image:List<Int>,private val requireContext:Context) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopulerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price, images)

        holder.itemView.setOnClickListener{
            val intent = Intent(requireContext, DetailsActivity::class.java)
            intent.putExtra("MenuItemName",item)
            intent.putExtra("MenuItemImage",images)
            requireContext.startActivity(intent)
        }
    }

    class PopularViewHolder (private val binding: PopulerItemBinding): RecyclerView.ViewHolder(binding.root){
        private val imagesView= binding.imageView6
        fun bind(item: String,price: String, image: Int) {
            binding.foodNamePopular.text = item
            binding.PricePopular.text = price
            imagesView.setImageResource(image)
        }
    }
}