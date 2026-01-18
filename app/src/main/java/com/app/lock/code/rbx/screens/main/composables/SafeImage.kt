package com.app.lock.code.rbx.screens.main.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun SafeImage(
    @DrawableRes resId: Int?,
    modifier: Modifier = Modifier
) {
    if (resId != null) {
        Image(
            painter = painterResource(resId),
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    } else {
        Box(
            modifier = modifier.background(Color.DarkGray)
        )
    }
}
