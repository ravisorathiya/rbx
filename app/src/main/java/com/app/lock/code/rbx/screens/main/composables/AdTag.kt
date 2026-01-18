package com.app.lock.code.rbx.screens.main.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdTag() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(Color(0xFF0E2B1C))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = "AD",
            color = Color(0xFF5AC88E),
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
