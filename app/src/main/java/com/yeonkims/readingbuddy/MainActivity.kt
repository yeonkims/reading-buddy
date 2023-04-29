package com.yeonkims.readingbuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.yeonkims.readingbuddy.model.Book
import com.yeonkims.readingbuddy.network.BooksApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BookListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)

        CoroutineScope(Dispatchers.IO).launch {
            BooksApi.retrofitService.getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ booksJson ->
                    val books = booksJson.items.map { bookJson ->
                        Book(bookJson.title, bookJson.author, bookJson.image)
                    }
                    adapter = BookListAdapter(books)
                    recyclerView.adapter = adapter
                }, { error ->
                    Log.e("TAG", "API Error: $error")
                })
        }
    }
}