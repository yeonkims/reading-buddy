package com.yeonkims.readingbuddy.network

import com.yeonkims.readingbuddy.model.Book
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://openapi.naver.com/v1/"
private const val CLIENT_ID = "ILL0azNCUUahF8PnhpTc"
private const val CLIENT_SECRET = "_si9CcOPZd"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

interface BooksApiService {
    @Headers("X-Naver-Client-Id: $CLIENT_ID", "X-Naver-Client-Secret: $CLIENT_SECRET")
    @GET("search/book.json")
    fun getBooks(
        @Query("query") query: String = "비즈니스",
        @Query("display") pageSize: Int = 20,
        @Query("start") pageStart: Int = 1
    ): Observable<BooksJson>
}

object BooksApi {
    val retrofitService: BooksApiService by lazy { retrofit.create(BooksApiService::class.java) }
}