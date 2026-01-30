package com.sfinfotech.rblxcal.screens.sctach.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpinHeader(balance: Int, onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF1B1B1B), Color(0xFF0D0D0D))
                )
            )
    ) {

        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .padding(start = 16.dp, top = 18.dp)
                .size(48.dp)
                .background(Color.Black, CircleShape)
        ) {
            Icon(Icons.AutoMirrored.Default.ArrowBack, null, tint = Color.White)
        }

        Text(
            text = "Scratch Card",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.TopCenter)
                .padding(top = 24.dp)
        )

        WalletBar(
            amount = balance,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 20.dp)
                .offset(y = 28.dp)
        )
    }
}
