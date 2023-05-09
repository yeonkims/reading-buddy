package com.yeonkims.readingbuddy.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.yeonkims.readingbuddy.model.Book
import com.yeonkims.readingbuddy.network.BooksApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class BookRepository @Inject constructor() {

    private var books = MutableLiveData<List<Book>>()

    fun getBooks() = books

    fun fetchBooks() {
        CoroutineScope(Dispatchers.IO).launch {
            BooksApi.retrofitService.getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ booksJson ->
                    books.value = booksJson.items.map { bookJson ->
                        Book(bookJson.title, bookJson.author, bookJson.image)
                    }
                    Log.d("testest repository", "${books.value?.size}")
                }, { error ->
                    Log.e("TAG", "API Error: $error")
                })
        }
    }

}