package com.sfinfotech.rblxcal.screens.sctach

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sfinfotech.rblxcal.screens.sctach.composables.ScratchCard
import com.sfinfotech.rblxcal.screens.spin.composables.SpinHeader
import com.sfinfotech.rblxcal.util.DataUtil
import kotlinx.coroutines.launch

@Composable
fun ScratchCardScreen(
    onBackClick: () -> Unit,
) {

    var revealed by remember { mutableStateOf(false) }
    var reward by remember { mutableStateOf((50..600).random()) }

    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
//                .systemBarsPadding()
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SpinHeader(
            balance = DataUtil.rbxCoins,
            onBackClick = onBackClick,
            title = "Scratch Card"
        )

        Spacer(Modifier.height(60.dp))

        ScratchCard(
            reward = reward,
            onScratchComplete = {
                scope.launch {
                    revealed = true
                    DataUtil.incrementCoins(reward)
                }
            }
        )
    }

}

@Preview
@Composable
fun ScratchCardScreenReview() {
    ScratchCardScreen(
        onBackClick = {}
    )
}