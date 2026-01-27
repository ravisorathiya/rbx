package com.app.lock.code.rbx.screens.spin.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.lock.code.rbx.screens.spin.SpinUtil.wheelPrizes
import com.app.lock.code.rbx.screens.spin.WheelPrize
import kotlin.collections.forEachIndexed
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun LuckyWheel(
    prizes: List<WheelPrize>,
    rotation: Float
) {
    Canvas(
        modifier = Modifier.size(300.dp)
    ) {
        val sweepAngle = 360f / prizes.size
        val radius = size.minDimension / 2
        val center = this.center

        // Rotate entire wheel so first slice starts at TOP
        rotate(rotation - 90f, center) {

            prizes.forEachIndexed { index, prize ->
                val startAngle = index * sweepAngle

                drawArc(
                    color = if (index % 2 == 0) Color(0xFF1C1C1E) else Color(0xFF2A2A2D),
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = true
                )

                // Divider
                drawLine(
                    color = Color.Black,
                    start = center,
                    end = Offset(
                        x = center.x + radius * cos(Math.toRadians(startAngle.toDouble())).toFloat(),
                        y = center.y + radius * sin(Math.toRadians(startAngle.toDouble())).toFloat()
                    ),
                    strokeWidth = 4f
                )

                // Prize Text
                drawContext.canvas.nativeCanvas.apply {
                    val textAngle = startAngle + sweepAngle / 2
                    val textRadius = radius * 0.65f

                    val x = center.x + textRadius *
                            cos(Math.toRadians(textAngle.toDouble())).toFloat()
                    val y = center.y + textRadius *
                            sin(Math.toRadians(textAngle.toDouble())).toFloat()

                    save()
                    rotate(textAngle + 90, x, y)

                    val paint = android.graphics.Paint().apply {
                        color = android.graphics.Color.WHITE
                        textSize = 40f
                        textAlign = android.graphics.Paint.Align.CENTER
                        isFakeBoldText = true
                    }

                    drawText(prize.amount.toString(), x, y, paint)
                    restore()
                }
            }
        }

        drawCircle(
            color = Color(0xFF0F0F10),
            radius = radius,
            style = Stroke(width = 12f)
        )

        drawCircle(color = Color.White, radius = 20f)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun LuckyWheelPreview() {
    LuckyWheel(
        prizes = wheelPrizes,
        rotation = 0f
    )
}
