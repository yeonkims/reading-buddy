package com.yeonkims.readingbuddy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yeonkims.readingbuddy.model.Book
import com.yeonkims.readingbuddy.repository.BookRepository
import javax.inject.Inject

class BookListViewModel @Inject constructor(
    private val bookRepository: BookRepository
) : ViewModel() {

    private val _latestNotes = MutableLiveData<List<Book>>()
    val latestNotes: LiveData<List<Book>> = bookRepository.getBooks()


    fun fetchBooks() {
        bookRepository.fetchBooks()
        _latestNotes.value = bookRepository.getBooks().value
    }
}