package com.sfinfotech.rblxcal.screens.spin.composables

import android.system.Os.close
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TrianglePointer() {
    Canvas(modifier = Modifier.size(30.dp)) {
        drawPath(
            path = Path().apply {
                moveTo(size.width / 2, size.height)
                lineTo(0f, 0f)
                lineTo(size.width, 0f)
                close()
            },
            color = Color.White
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun TrianglePointerPreview() {
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        TrianglePointer()
    }
}
