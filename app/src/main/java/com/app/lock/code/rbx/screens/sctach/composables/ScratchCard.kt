package com.app.lock.code.rbx.screens.sctach.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.lock.code.rbx.util.Util

@Composable
fun ScratchCard(
    reward: Int,
    onScratchComplete: () -> Unit
) {
    var scratched by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(220.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(Color(0xFF1A1A1A)),
        contentAlignment = Alignment.Center
    ) {

        // 🎁 Reward underneath
        Text(
            text = "$reward RBX",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Util.PRIMARY__COLOR
        )

        // 🧩 Patterned scratch layer
        if (!scratched) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color(0xFF2B2B2E),
                                Color(0xFF1C1C1E)
                            )
                        )
                    )
                    .pointerInput(Unit) {
                        detectTapGestures {
                            scratched = true
                            onScratchComplete()
                        }
                    },
                contentAlignment = Alignment.Center
            ) {

                Text(
                    "Scratch Here",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun ScratchCardPreview_NotScratched() {
    ScratchCard(
        reward = 250,
        onScratchComplete = {}
    )
}
