package com.app.lock.code.rbx.screens.spin

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


    fun calculateWinningIndex(finalRotation: Float, itemCount: Int): Int {
        val adjustedRotation = (finalRotation - 90f) % 360
        val normalized = (360 - adjustedRotation) % 360
        val segmentAngle = 360f / itemCount
        return (normalized / segmentAngle).toInt()
    }



}