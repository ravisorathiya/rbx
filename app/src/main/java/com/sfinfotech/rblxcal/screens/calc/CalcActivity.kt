package com.sfinfotech.rblxcal.screens.calc

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.sfinfotech.rblxcal.ui.theme.RbxTheme
import com.sfinfotech.rblxcal.util.AppNavigator
import kotlin.jvm.java

class CalcActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RbxTheme {
                CalcScreen(
                    onBackClick = ::finish,
                    onItemClick = {
                        AppNavigator.toCalcResult(this@CalcActivity,it)
                    }
                )
            }
        }
    }
}
