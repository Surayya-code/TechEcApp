package com.example.techecapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.techecapp.databinding.ItemCategoriesBinding
import com.example.techecapp.databinding.ItemProductsBinding
import com.example.techecapp.modul.product.ProductResponseItem
import com.squareup.picasso.Picasso

class ProductsAdapter:RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    private val arrayList=ArrayList<ProductResponseItem>()

    inner class ProductViewHolder(val binding:ItemProductsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:ProductResponseItem){
            binding.productData=item
            Picasso.get().load(item.images[0]).into(binding.imageProduct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layout=ItemProductsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(layout)
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item=arrayList[position]
        holder.bind(item)
    }

    fun updateList(list:List<ProductResponseItem>){
        arrayList.clear()
        arrayList.addAll(list)
        notifyDataSetChanged()
    }

}