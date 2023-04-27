package com.yeonkims.readingbuddy.model

import com.yeonkims.readingbuddy.R

data class Book(
    val title: String,
    val author: String,
    val image: Int
)

val tempBook1 = Book("아주 작은 습관의 힘", "제임스 클리어", R.drawable.atomic_habits)
val tempBook2 = Book("인간관계론", "데일 카네키", R.drawable.how_to_win_people)

val tempBookList = listOf(
    tempBook1,
    tempBook2,
    tempBook1,
    tempBook2,
    tempBook1,
    tempBook2,
    tempBook1,
    tempBook2,
    tempBook1,
    tempBook2,
    tempBook1,
    tempBook2,
    tempBook1,
)