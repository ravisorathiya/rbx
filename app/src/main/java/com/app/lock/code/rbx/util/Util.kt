package com.app.lock.code.rbx.util

import com.app.lock.code.rbx.model.ConvertModel

object Util {



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


}