package com.sfinfotech.rblxcal.screens.ad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.sfinfotech.rblxcal.ui.theme.RbxTheme
import com.sfinfotech.rblxcal.util.Util

class WebAdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RbxTheme {
                WebAdScreen(
                    url = Util.adLink,
                    onBack = { finish() }
                )
            }
        }
    }
}

