package com.app.lock.code.rbx.core.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.app.lock.code.rbx.ui.theme.RbxTheme

class SettingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RbxTheme {
                SettingScreen(
                    onBackClick = { finish() },
                    onShareClick = { SettingUtil.shareApp(this) },
                    onRateClick = { SettingUtil.rateApp(this) },
                    onPrivacyClick = { SettingUtil.openPrivacyPolicy(this) }
                )
            }
        }
    }
}
