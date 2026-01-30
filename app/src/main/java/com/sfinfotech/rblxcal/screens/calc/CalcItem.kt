package com.sfinfotech.rblxcal.screens.calc

import com.sfinfotech.rblxcal.model.CalcType

data class CalcItem(
    val title: String,
    val subtitle: String,
    val icon: Int,
    val type: CalcType,
    val isAdBadge: Boolean = false
)
