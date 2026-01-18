package com.app.lock.code.rbx.model

data class ConvertModel(
    val title : String,
    val subTitle : String,
    val icon : Int,
    val span : Int,
    val isAd: Boolean = false
)