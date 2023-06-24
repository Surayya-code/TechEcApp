package com.example.techecapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.techecapp.databinding.ItemCategoriesBinding
import com.example.techecapp.modul.category.CategoryResponseItem

class CategoriesAdapter :RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>(){

    private val arrayList=ArrayList<CategoryResponseItem>()

    inner class CategoriesViewHolder(val binding:ItemCategoriesBinding ):RecyclerView.ViewHolder(binding.root){
        fun bind(item:CategoryResponseItem){
            binding.categoryData=item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
      val layout=ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoriesViewHolder(layout)
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
       val item=arrayList[position]
        holder.bind(item)
    }

    fun updateList(list:List<CategoryResponseItem>){
        arrayList.clear()
        arrayList.addAll(list)
        notifyDataSetChanged()
    }
}