package com.app.lock.code.rbx.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.app.lock.code.rbx.ui.theme.RbxTheme
import com.app.lock.code.rbx.util.AppNavigator
import com.app.lock.code.rbx.util.CurrencyModelEnum

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RbxTheme {
                MainScreen(
                    onClick = {conv->
                        val enums = CurrencyModelEnum.entries.firstOrNull { it.title == conv.title } ?: return@MainScreen
                        when (enums) {
                            CurrencyModelEnum.ALL_CALCULATOR -> {

                            }
                            CurrencyModelEnum.AD -> {

                            }
                            CurrencyModelEnum.PLAY_GAME_AD -> {

                            }
                            CurrencyModelEnum.SCRATCH_CARD -> {
                                AppNavigator.toScratchCard(this)
                            }
                            CurrencyModelEnum.QUIZ_GAME -> {

                            }
                            CurrencyModelEnum.PLAY_GAME_AD_2 -> {

                            }
                            CurrencyModelEnum.LUCKY_SPIN -> {
                                AppNavigator.toSpin(this)
                            }
                            CurrencyModelEnum.MEME -> {
                                AppNavigator.toMeme(this)

                            }
                            CurrencyModelEnum.TIPS_TRICKS -> {
                                AppNavigator.toTips(this)

                            }
                        }
                    }
                )
            }
        }
    }
}

