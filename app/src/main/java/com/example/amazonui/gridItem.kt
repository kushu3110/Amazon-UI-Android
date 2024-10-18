package com.example.amazonui

import androidx.annotation.DrawableRes

data class gridItem(
    @DrawableRes val image : Int,
    val name: String,
    val mrp: String,
    val rate: String
)
