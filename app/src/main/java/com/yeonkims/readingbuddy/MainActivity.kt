package com.yeonkims.readingbuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.yeonkims.readingbuddy.viewmodel.BookListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: BookListViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BookListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchBooks()

        recyclerView = findViewById(R.id.recycler_view)

        adapter = BookListAdapter(listOf())

        viewModel.latestNotes.observe(this) { books ->
            adapter.items = books
            adapter.submitList(books)

        }
        recyclerView.adapter = adapter


    }
}