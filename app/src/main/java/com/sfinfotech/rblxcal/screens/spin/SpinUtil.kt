package com.sfinfotech.rblxcal.screens.spin

object SpinUtil {


    val wheelPrizes = listOf(
        WheelPrize(600),
        WheelPrize(475),
        WheelPrize(100),
        WheelPrize(300),
        WheelPrize(325),
        WheelPrize(0),
        WheelPrize(525),
        WheelPrize(400),
        WheelPrize(425),
        WheelPrize(225)
    )


    fun calculateWinningIndex(rotation: Float, itemCount: Int): Int {
        val normalizedRotation = (rotation % 360 + 360) % 360
        val segmentAngle = 360f / itemCount

        val pointerAngle = 270f // pointer at top
        val relativeAngle = (pointerAngle - normalizedRotation + 360f) % 360f

        return (relativeAngle / segmentAngle).toInt().coerceIn(0, itemCount - 1)
    }



}