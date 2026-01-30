package com.sfinfotech.rblxcal.screens.tips.detail

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sfinfotech.rblxcal.screens.tips.tip.TipItem
import com.sfinfotech.rblxcal.ui.theme.RbxTheme

class TipDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val tipItem: TipItem? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra("tip_item", TipItem::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent.getParcelableExtra("tip_item")
            }

            RbxTheme {
                TipDetailScreen(tipItem = tipItem, onBackClick = {
                    finish()
                })
            }
        }
    }
}
