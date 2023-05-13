package com.yeonkims.readingbuddy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yeonkims.readingbuddy.databinding.ItemBookBinding
import com.yeonkims.readingbuddy.model.Book

class BookListAdapter(var items: List<Book>) : ListAdapter<Book, BookListAdapter.ViewHolder>(BookDiffUtil) {

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

object BookDiffUtil : DiffUtil.ItemCallback<Book>() {

    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }
}