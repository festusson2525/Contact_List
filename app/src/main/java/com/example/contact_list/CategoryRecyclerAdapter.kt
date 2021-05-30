package com.example.contact_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contact_list.databinding.CategoryRvItemBinding

class CategoryRecyclerAdapter(
    private val categories : List<String>,
    private val listener: (String) -> Unit
) :
    RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val categoryRvItemBinding : CategoryRvItemBinding) :
        RecyclerView.ViewHolder(categoryRvItemBinding.root){
        fun bind(category: String) {
            categoryRvItemBinding.categoryTv.text = category
            categoryRvItemBinding.root.setOnClickListener {
                listener.invoke(category)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            CategoryRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}