package com.app.lock.code.rbx.screens.sctach

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.lock.code.rbx.screens.sctach.composables.ScratchCard
import com.app.lock.code.rbx.screens.spin.composables.SpinHeader

@Composable
fun ScratchCardScreen() {

    var totalRbx by remember { mutableStateOf(472) }
    var revealed by remember { mutableStateOf(false) }
    var reward by remember { mutableStateOf((50..600).random()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SpinHeader(
            balance = totalRbx,
            onBackClick = {}
        )

        Spacer(Modifier.height(60.dp))

        ScratchCard(
            reward = reward,
            onScratchComplete = {
                revealed = true
                totalRbx += reward
            }
        )
    }
}

@Preview
@Composable
fun ScratchCardScreenReview() {
    ScratchCardScreen()
}