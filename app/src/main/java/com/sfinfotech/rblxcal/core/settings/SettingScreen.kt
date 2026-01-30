package com.sfinfotech.rblxcal.core.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sfinfotech.rblxcal.core.settings.composables.SettingsItem
import com.sfinfotech.rblxcal.core.settings.composables.SettingsTopBar
import com.sfinfotech.rblxcal.ui.theme.RbxTheme

@Composable
fun SettingScreen(
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onRateClick: () -> Unit,
    onPrivacyClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .systemBarsPadding()
    ) {

        SettingsTopBar(onBackClick)

        Spacer(Modifier.height(20.dp))

        SettingsItem(
            icon = Icons.Default.Share,
            title = "Share App",
            onClick = onShareClick
        )

        SettingsItem(
            icon = Icons.Default.StarBorder,
            title = "Rate Us",
            onClick = onRateClick
        )

        SettingsItem(
            icon = Icons.Default.PrivacyTip,
            title = "Privacy Policy",
            onClick = onPrivacyClick
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000, showSystemUi = true)
@Composable
fun SettingScreenPreview() {
    RbxTheme {
        SettingScreen(
            onBackClick = {},
            onShareClick = {},
            onRateClick = {},
            onPrivacyClick = {}
        )
    }
}
