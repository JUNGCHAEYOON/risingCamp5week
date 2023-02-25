package com.example.risingcamp5week.recycler

data class MatzipVerticalItem(
    val image : Int,
    val location : String,
    val title : String,
    val foodtype : String,
    val point : String,
    val review : String,
    // 좌표
    val lat : Double,
    val long : Double
    )
