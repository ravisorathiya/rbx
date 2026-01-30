package com.sfinfotech.rblxcal.screens.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sfinfotech.rblxcal.screens.ad.WebAdActivity
import com.sfinfotech.rblxcal.ui.theme.RbxTheme
import com.sfinfotech.rblxcal.util.AppNavigator
import com.sfinfotech.rblxcal.util.CurrencyModelEnum

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RbxTheme {
                MainScreen(
                    onClick = { conv ->
                        val enums = CurrencyModelEnum.entries.firstOrNull { it.title == conv.title }
                            ?: return@MainScreen
                        when (enums) {
                            CurrencyModelEnum.ALL_CALCULATOR -> {
                                AppNavigator.toCalc(this)

                            }

                            CurrencyModelEnum.AD -> {
                                AppNavigator.toAd(this)
                            }

                            CurrencyModelEnum.PLAY_GAME_AD -> {
                                val intent = Intent(this, WebAdActivity::class.java)
                                this.startActivity(intent)
                            }

                            CurrencyModelEnum.SCRATCH_CARD -> {
                                AppNavigator.toScratchCard(this)
                            }

                            CurrencyModelEnum.QUIZ_GAME -> {
                                AppNavigator.toQuiz(this)

                            }

                            CurrencyModelEnum.PLAY_GAME_AD_2 -> {
                                AppNavigator.toAd(this)

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
                    },
                    onSettingClick = { AppNavigator.toSetting(this) }
                )
            }
        }
    }
}

