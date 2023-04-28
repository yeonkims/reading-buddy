package com.yeonkims.readingbuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.yeonkims.readingbuddy.model.tempBookList
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
        adapter = BookListAdapter(tempBookList)
        recyclerView.adapter = adapter

        CoroutineScope(Dispatchers.IO).launch {
            BooksApi.retrofitService.getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    // 성공적으로 데이터를 받은 경우
                    Log.d("TAG", "Data: ${response.items[0].title}")
                }, { error ->
                    // API 호출 중 에러 발생 시
                    Log.e("TAG", "API Error: $error")
                })
        }
    }
}