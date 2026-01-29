package com.app.lock.code.rbx.util

import androidx.compose.ui.graphics.Color
import com.app.lock.code.rbx.model.CalcType
import com.app.lock.code.rbx.model.ConvertModel

object Util {


     val PRIMARY__COLOR = Color(0xFF22a7f2)

    val convertModelList = CurrencyModelEnum.entries.map {
        ConvertModel(
            title = it.title,
            subTitle = it.subTitle,
            icon = it.icon,
            span = it.span,
            isAd = it == CurrencyModelEnum.PLAY_GAME_AD ||
                    it == CurrencyModelEnum.PLAY_GAME_AD_2
        )
    }

    fun calculate(type: CalcType, amount: Double): Double {
        return when (type) {
            CalcType.USD_TO_RBX -> amount * 80
            CalcType.RBX_TO_USD -> amount / 80
            CalcType.RBX_TO_DOLLAR -> amount / 80
            CalcType.DOLLAR_TO_RBX -> amount * 80
            CalcType.BC_TO_RBX -> amount * 10
            CalcType.TBC_TO_RBX -> amount * 12
            CalcType.OBC_TO_RBX -> amount * 15
            else -> 1.0
        }
    }


}