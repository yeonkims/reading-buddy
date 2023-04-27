package com.yeonkims.readingbuddy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeonkims.readingbuddy.databinding.ItemBookBinding
import com.yeonkims.readingbuddy.model.Book

class BookListAdapter(val items: List<Book>) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    private lateinit var binding: ItemBookBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Book) {
            binding.book = item
        }
    }
}