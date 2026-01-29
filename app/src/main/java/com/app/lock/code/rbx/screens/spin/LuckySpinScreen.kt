package com.app.lock.code.rbx.screens.spin

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.sp
import com.app.lock.code.rbx.screens.spin.SpinUtil.calculateWinningIndex
import com.app.lock.code.rbx.screens.spin.SpinUtil.wheelPrizes
import com.app.lock.code.rbx.screens.spin.composables.LuckyWheel
import com.app.lock.code.rbx.screens.spin.composables.SpinHeader
import com.app.lock.code.rbx.screens.spin.composables.TrianglePointer
import com.app.lock.code.rbx.screens.spin.composables.WinDialog
import com.app.lock.code.rbx.util.DataUtil
import com.app.lock.code.rbx.util.Util
import kotlinx.coroutines.launch

@Composable
fun LuckySpinScreen(onBackClick: () -> Unit = {}) {

    var rotation by remember { mutableStateOf(0f) }
    var isSpinning by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var wonAmount by remember { mutableStateOf(0) }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        SpinHeader(
            balance = DataUtil.rbxCoins, onBackClick = onBackClick,
            title = "Lucky Spin",
        )

        Spacer(Modifier.height(60.dp)) // space after overlapping wallet

        Spacer(Modifier.height(40.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            LuckyWheel(prizes = wheelPrizes, rotation = rotation)
            TrianglePointer()
        }

        Spacer(Modifier.height(40.dp))

        Button(
            onClick = {
                if (isSpinning) return@Button

                isSpinning = true

                val extraSpins = (5..8).random() * 360
                val randomAngle = (0..359).random()
                val spinTarget = rotation + extraSpins + randomAngle

                scope.launch {
                    animate(
                        initialValue = rotation,
                        targetValue = spinTarget.toFloat(),
                        animationSpec = tween(4000, easing = FastOutSlowInEasing)
                    ) { value, _ ->
                        rotation = value
                    }

                    // Normalize once animation ends
                    rotation = (rotation % 360 + 360) % 360

                    val index = calculateWinningIndex(rotation, wheelPrizes.size)
                    wonAmount = wheelPrizes[index].amount

                    showDialog = true
                    isSpinning = false
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Util.PRIMARY__COLOR),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.8f)
                .height(55.dp)
        ) {
            Text("Spin Now", fontSize = 18.sp, color = Color.Black)
        }
    }

    if (showDialog) {
        WinDialog(
            amount = wonAmount,
            onAddToWallet = {
                scope.launch {
                    DataUtil.incrementCoins(wonAmount)
                    showDialog = false
                }
            },
            onDismiss = { showDialog = false }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000, showSystemUi = true)
@Composable
fun LuckySpinScreenPreview() {
    LuckySpinScreen()
}
