package com.sfinfotech.rblxcal.screens.memes.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShareButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(52.dp)
            .clip(CircleShape)
            .background(Color.White)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = "Share",
            tint = Color.Black
        )
    }
}

@Preview(
    name = "Share Button",
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun ShareButtonPreview() {
    Box(
        modifier = Modifier
            .background(Color(0xFF1C1C1E))
            .padding(16.dp)
    ) {
        ShareButton(onClick = {})
    }
}
