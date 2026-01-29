package com.app.lock.code.rbx.screens.calc

import com.app.lock.code.rbx.model.CalcType

data class CalcItem(
    val title: String,
    val subtitle: String,
    val icon: Int,
    val type: CalcType,
    val isAdBadge: Boolean = false
)
