package com.app.lock.code.rbx.screens.tips.tip.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.lock.code.rbx.screens.tips.tip.TipIcon

@Composable
fun IconContainer(icon: TipIcon) {
    val imageVector = when (icon) {
        TipIcon.BULB -> Icons.Default.Lightbulb
        TipIcon.GAMEPAD -> Icons.Default.SportsEsports
    }

    Box(
        modifier = Modifier
            .size(44.dp)
            .clip(CircleShape)
            .background(Color.White.copy(alpha = 0.1f)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Preview(
    name = "Gamepad Icon",
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun IconContainerPreview_Gamepad() {
    IconContainer(icon = TipIcon.GAMEPAD)
}