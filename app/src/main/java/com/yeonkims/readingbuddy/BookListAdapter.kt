package com.yeonkims.readingbuddy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yeonkims.readingbuddy.model.Book

class BookListAdapter(val items: List<Book>) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.author.text = item.author
        holder.image.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title_text)
        val author: TextView = itemView.findViewById(R.id.author_text)
        val image: ImageView = itemView.findViewById(R.id.book_image)
    }
}