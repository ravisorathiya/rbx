package com.app.lock.code.rbx.util

import com.app.lock.code.rbx.R

enum class CurrencyModelEnum(
    val title: String,
    val subTitle: String,
    val icon: Int,
    val span: Int,
) {
    ALL_CALCULATOR("All Calculator", "All RBX Calculator", R.drawable.calc, 2),
    AD("", "", R.drawable.calc, 2),
    PLAY_GAME_AD("Play Game", "Play Smart Pay Hard", R.drawable.calc, 1),
    SCRATCH_CARD(
        "Scratch Card",
        "Scratch the card win a prize",
        R.drawable.calc,
        1
    ),
    QUIZ_GAME("Quiz Time", "Play Quiz and get amazing gift", R.drawable.calc, 1),
    PLAY_GAME_AD_2("Play Game", "Play smart play hard", R.drawable.calc, 1),
    LUCKY_SPIN(
        "Lucky Spin Wheel",
        "spin wheels and get amazing gift",
        R.drawable.calc,
        2
    ),
    MEME(
        "Meme",
        "play meme sound or visuals for quick humor",
        R.drawable.calc,
        1
    ),
    TIPS_TRICKS(
        "Tips & Tricks",
        "Provide helpful shortcuts or advice salinity",
        R.drawable.calc,
        1
    )

}